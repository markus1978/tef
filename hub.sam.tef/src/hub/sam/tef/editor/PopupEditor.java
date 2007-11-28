package hub.sam.tef.editor;

import org.eclipse.swt.widgets.Control;

public abstract class PopupEditor extends ModelEditor {

	public Control getWidget() {	
		return super.getSourceViewer().getTextWidget();
	}
}
