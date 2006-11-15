package editortest.editor.presentation;

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

import editortest.editor.TEFDocument;
import editortest.editor.TEFSourceViewer;
import editortest.view.CompoundText;
import editortest.view.Text;

public class PresentationDamagerRepairer implements IPresentationDamager, IPresentationRepairer {

	private TEFDocument fDocument;
	private final TEFSourceViewer fSourceViewer;
	
	public PresentationDamagerRepairer(final TEFSourceViewer sourceViewer) {
		super();
		fSourceViewer = sourceViewer;
	}
	
	private void collectAllTextsInRanger(Text actualText, ITypedRegion range, Collection<Text> allTexts) {
		int textBegin = actualText.getAbsolutOffset(0);
		int textEnd = textBegin + actualText.getLength();
		int rangeBegin = range.getOffset();
		int rangeEnd = rangeBegin + range.getLength();
		if ((textEnd >= rangeBegin && textEnd <= rangeEnd) || (textBegin <= rangeEnd && textBegin >= rangeBegin)) {
			allTexts.add(actualText);
		}
		if (!(textEnd <= rangeBegin || textBegin >= rangeEnd)) {
			if (actualText instanceof CompoundText) {
				for (Text innerText: ((CompoundText)actualText).getTexts()) {
					collectAllTextsInRanger(innerText, range, allTexts);
				}
			}
		}
	}
		
	public void createPresentation(TextPresentation presentation, final ITypedRegion damage) {
		presentation.setDefaultStyleRange(new StyleRange(damage.getOffset(), damage.getLength(), null, null));		
		Collection<Text> allTextsInRange = new Vector<Text>();
		collectAllTextsInRanger(fDocument.getDocument(), damage, allTextsInRange);
		
		for (Text text: allTextsInRange) {
			TextAttribute attr = text.getAttribute(TextAttribute.class);
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
		return new Region(event.getOffset(), (event.getText().length() > event.getLength()) ? event.getText().length() : event.getLength());
	}

	public void setDocument(IDocument document) {
		fDocument = (TEFDocument)document;
	}	
}
