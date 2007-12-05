package hub.sam.tef.editor.popup;


import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;

public class PopupSourceViewer extends SourceViewer {
	
	private final PopupEditor fEditor;
	
	public static final int CLOSE_POPUP_EDITOR_ACTION_KEY = 
		SourceViewer.QUICK_ASSIST + 1;
	
	public PopupSourceViewer(Composite parent, IVerticalRuler verticalRuler,
			IOverviewRuler overviewRuler, boolean showAnnotationsOverview,
			int styles, PopupEditor editor) {
		super(parent, verticalRuler, overviewRuler, showAnnotationsOverview, styles);
		this.fEditor = editor;
	}
	
	@Override
	public boolean canDoOperation(int operation) {
		if (operation == CLOSE_POPUP_EDITOR_ACTION_KEY) {			
			return true;
		} else {
			return super.canDoOperation(operation);
		}
	}


	@Override
	public void doOperation(int operation) {
		if (operation == CLOSE_POPUP_EDITOR_ACTION_KEY) {
			fEditor.close(true);
		} else {
			super.doOperation(operation);
		}
	}
}
