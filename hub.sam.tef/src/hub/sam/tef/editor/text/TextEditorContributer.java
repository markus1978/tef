package hub.sam.tef.editor.text;

import hub.sam.tef.TEFPlugin;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.editors.text.TextEditorActionContributor;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.RetargetTextEditorAction;

public class TextEditorContributer extends TextEditorActionContributor {
	
	private RetargetTextEditorAction fFormat = null;
	
	public TextEditorContributer() {
		super();
		fFormat = new RetargetTextEditorAction(TEFPlugin.getMessagesBundle(), 
				FormatAction.MESSAGE_KEYS_PREFIX);		
		fFormat.setActionDefinitionId(FormatAction.ACTION_DEFINITION_ID);
	}

	public void contributeToMenu(IMenuManager mm) {
		super.contributeToMenu(mm);
		IMenuManager editMenu = mm.findMenuUsingPath(IWorkbenchActionConstants.M_EDIT);
		if (editMenu != null) {
			editMenu.add(new Separator(ICommonMenuConstants.GROUP_OPEN));
			editMenu.add(new Separator(ICommonMenuConstants.GROUP_GENERATE));
			editMenu.add(new Separator(ICommonMenuConstants.GROUP_ADDITIONS));			
		
			Collection<IAction> actions = new ArrayList<IAction>();
			appendActionsToMenu(actions);
			for (IAction action: actions) {
				editMenu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS, action);				
			}
		}
	}
	
	protected void appendActionsToMenu(Collection<IAction> actions) {
		actions.add(fFormat);
	}

	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		fFormat.setAction(getAction((ITextEditor)part, 
				FormatAction.ACTION_DEFINITION_ID));
	}
}
