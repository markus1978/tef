/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */
package hub.sam.tef.templates;

import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.IProposalHandler;
import hub.sam.tef.controllers.ITextEventListener;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.controllers.TextEvent;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.parse.IASTBasedModelUpdater;
import hub.sam.tef.parse.ISyntaxProvider;
import hub.sam.tef.parse.ModelUpdateConfiguration;
import hub.sam.tef.parse.TextBasedAST;
import hub.sam.tef.templates.ChoiceTemplate.ModelUpdater;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.FixText;
import hub.sam.tef.views.Text;

import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.TextAttribute;


public class FlagTemplate extends PrimitiveValueTemplate<Boolean> {
	
	private final String fFlagKeyword;

	public FlagTemplate(Template template, String flagKeywork) {
		super(template, template.getModelProvider().getModel().getType(Boolean.class));
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

	@Override
	public ICommand getCommandToCreateADefaultValue(IModelElement owner, String property, boolean composite) {	
		return null;
	}	
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (IASTBasedModelUpdater.class == adapter || ISyntaxProvider.class == adapter) {
			return (T)new ModelUpdater();
		} else {
			return super.getAdapter(adapter);
		}
	}
	
	class ModelUpdater implements IASTBasedModelUpdater, ISyntaxProvider {		
		public void executeModelUpdate(ModelUpdateConfiguration configuration) {
			if (configuration.getPrimitiveValue().equals(fFlagKeyword)) {
			executeASTSemanticsWithConvertedValue(true, configuration.getOwner(), configuration.getProperty(), 
					configuration.isCollection(), configuration.isOldNode());
			} else {
				throw new RuntimeException("assert");
			}
		}

		public TextBasedAST createAST(TextBasedAST parent,  IModelElement model, Text text) {
			return null;
		}

		public String getNonTerminal() {
			return "'" + fFlagKeyword + "'";
		}

		public String[][] getRules() {		
			return new String[][] {};
		}				
	}
}
