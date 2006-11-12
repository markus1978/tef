package editortest.editor;

import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.widgets.Composite;

// this may change with future eclipse versions
public class TEFSourceViewer extends SourceViewer {
	
	public static final int INSERT_ELEMENT = SourceViewer.QUICK_ASSIST + 1;
	
	private IContentAssistant fInsertElementAssist;
	
	public TEFSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		super(parent, ruler, styles);
	}

	public TEFSourceViewer(Composite parent, IVerticalRuler verticalRuler, IOverviewRuler overviewRuler, boolean showAnnotationsOverview, int styles) {
		super(parent, verticalRuler, overviewRuler, showAnnotationsOverview, styles);		
	}

	@Override
	public void configure(SourceViewerConfiguration configuration) {				
		if (getTextWidget() == null) {
			return;
		}
		fInsertElementAssist = ((TEFSourceViewerConfiguration)configuration).getInsertContentAssistant(this);
		fInsertElementAssist.install(this);
		super.configure(configuration);
	}	

	@Override
	public boolean canDoOperation(int operation) {
		if (operation == INSERT_ELEMENT) {
			return fInsertElementAssist != null && isEditable();
		} else {
			return super.canDoOperation(operation);
		}
	}

	@Override
	public void doOperation(int operation) {
		switch (operation) {
			case INSERT_ELEMENT:
				fInsertElementAssist.showPossibleCompletions();
				return;							
		}		
		super.doOperation(operation);
	}	
}
