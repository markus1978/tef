package editortest.editor.presentation;

import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.Text;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.swt.custom.StyleRange;

import editortest.controller.AbstractOffsetBasedVisitor;
import editortest.editor.TEFDocument;
import editortest.editor.TEFSourceViewer;

public class PresentationDamagerRepairer implements IPresentationDamager, IPresentationRepairer {

	private TEFDocument fDocument;
	private final TEFSourceViewer fSourceViewer;
	
	public PresentationDamagerRepairer(final TEFSourceViewer sourceViewer) {
		super();
		fSourceViewer = sourceViewer;
	}
	
	class FirstTextAtOffsetVisitor extends AbstractOffsetBasedVisitor {
		Text result = null;
		public FirstTextAtOffsetVisitor(int forOffset) {
			super(forOffset);
		}
		public void visitCompoundText(CompoundText visitedText, int atOffset) {
			// empty
		}
		public void visitText(Text visitedText, int atOffset) {
			if (result == null) {
				result = visitedText;				
			}
		}		
	}
		
	public void createPresentation(TextPresentation presentation, final ITypedRegion damage) {
		presentation.setDefaultStyleRange(new StyleRange(damage.getOffset(), damage.getLength(), null, null));		
		FirstTextAtOffsetVisitor visitor = new FirstTextAtOffsetVisitor(damage.getOffset());	
		fDocument.getDocument().process(visitor, damage.getOffset());
		Collection<Text> allTextsInRange = new Vector<Text>();
		Text runningText = visitor.result;		
		loop: while (runningText.getAbsolutOffset(0) < damage.getOffset() + damage.getLength()) {
			allTextsInRange.add(runningText);
			if (runningText == runningText.nextText()) {
				break loop;
			} else {
				runningText = runningText.nextText();
			}			
		}

		for (Text text: allTextsInRange) {
			TextAttribute attr = text.getElement(TextAttribute.class);
			if (attr != null) {				
				int begin = text.getAbsolutOffset(0);
				int end = begin + text.getLength();
				
				int damageBegin = damage.getOffset();
				int damageEnd = damageBegin + damage.getLength();
				if (begin < damageBegin) {
					begin = damageBegin;
				}
				if (end > damageEnd) {
					end = damageEnd;
				}				
				presentation.addStyleRange(new StyleRange(begin, end - begin,  attr.getForeground(), attr.getBackground(), attr.getStyle()));
			}
		}
	}

	public IRegion getDamageRegion(ITypedRegion partition, DocumentEvent event, boolean documentPartitioningChanged) {		
		return new Region(event.getOffset(), event.getText().length()); 
	}

	public void setDocument(IDocument document) {
		fDocument = (TEFDocument)document;
	}	
}
