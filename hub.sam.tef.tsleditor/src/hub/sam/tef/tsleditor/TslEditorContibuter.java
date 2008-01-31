package hub.sam.tef.tsleditor;

import hub.sam.tef.editor.text.TextEditorContributer;

import java.util.Collection;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.RetargetTextEditorAction;

public class TslEditorContibuter extends TextEditorContributer {

	private RetargetTextEditorAction fValidateGrammarAction = null;
	
	public TslEditorContibuter() {
		super();
		fValidateGrammarAction = new RetargetTextEditorAction(TslEditorPlugin.getMessagesBundle(), 
				ValidateGrammarAction.MESSAGE_KEYS_PREFIX);		
		fValidateGrammarAction.setActionDefinitionId(ValidateGrammarAction.ACTION_DEFINITION_ID);
	}
	
	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		fValidateGrammarAction.setAction(getAction((ITextEditor)part, 
				ValidateGrammarAction.ACTION_DEFINITION_ID));
	}

	@Override
	protected void appendActionsToMenu(Collection<IAction> actions) {
		super.appendActionsToMenu(actions);
		actions.add(fValidateGrammarAction);
	}
}
