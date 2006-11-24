package editortest.template;

import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.TextAttribute;

import editortest.controller.CursorMovementStrategy;
import editortest.controller.IProposalHandler;
import editortest.controller.ITextEventListener;
import editortest.controller.Proposal;
import editortest.controller.TextEvent;
import editortest.view.CompoundText;
import editortest.view.FixText;
import editortest.view.Text;

public class FlagTemplate extends ValueTemplate<Boolean> {
	
	private final String fFlagKeyword;

	public FlagTemplate(Template template, String flagKeywork) {
		super(template);
		fFlagKeyword = flagKeywork;
	}	
	
	class ActualValue {
		boolean value;
	}

	@Override
	public Text createView(Boolean model, final IValueChangeListener<Boolean> changeListener) {
		final CompoundText result = new CompoundText();
		result.addElement(IProposalHandler.class, new IProposalHandler() {

			public ProposalKind getProposalKind() {
				return ProposalKind.change;
			}

			public List<Proposal> getProposals(Text text, int offset) {
				List<Proposal> result = new Vector<Proposal>(1);
				if (!text.getElement(ActualValue.class).value) {
					result.add(new Proposal(fFlagKeyword, null, 0));
				}
				return result;
			}

			public boolean handleProposal(Text text, int offset, Proposal proposal) {
				if (proposal.getContextDisplayString().equals(fFlagKeyword)) {
					changeListener.valueChanges(true);
				}
				return true;
			}
			
		});
		ActualValue actualValue = new ActualValue();
		actualValue.value = model;
		result.setElement(ActualValue.class, actualValue);
		result.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));
		result.addElement(ITextEventListener.class, new ITextEventListener() {
			public boolean handleEvent(Text text, TextEvent event) {
				changeListener.valueChanges(false);
				return true;
			}

			public boolean verifyEvent(Text text, TextEvent event) {				
				if (text.getElement(ActualValue.class).value) {
					if (event.getBegin() < event.getEnd() && event.getText().equals("")) {
						return true;
					}
				}
				return false;
			}			
		});
		updateView(result, model);
		return result;
	}

	@Override
	public void updateView(Text view, Boolean value) {
		if (value) {
			Text flag = new FixText(fFlagKeyword + " ");
			flag.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));
			((CompoundText)view).addText(flag);
			flag.setElement(TextAttribute.class, TerminalTemplate.FLAG_HIGHLIGHT);
		} else {
			((CompoundText)view).removeText();
		}
		view.getElement(ActualValue.class).value = value;		
	}
}
