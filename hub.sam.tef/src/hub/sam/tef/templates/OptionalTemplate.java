package hub.sam.tef.templates;

import hub.sam.tef.controllers.AbstractRequestHandler;
import hub.sam.tef.controllers.CursorMovementStrategy;
import hub.sam.tef.controllers.IDeleteEventHandler;
import hub.sam.tef.controllers.IProposalHandler;
import hub.sam.tef.controllers.MarkFlag;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.ICommand;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.FixText;
import hub.sam.tef.views.Text;

import java.util.List;

/**
 * This template is completly wrong. It should function like any other MVC template. But it does not.
 * This template does not listen to changes to all outermost composites (as it should). It simple
 * starts with a seed if there is no otermost composite. Otherwise it starts with the outermost composite.
 * But of course it cannot be removed or another one added.
 * 
 * It should actually work like anyother SequenceTemplate, with the sequence of outermost composites as
 * model.
 */
@Deprecated
public abstract class OptionalTemplate<ModelType> extends PropertyTemplate<ModelType> {
	
	public OptionalTemplate(ElementTemplate elementTemplate, String property) {
		super(elementTemplate, property);
	}
	
	@Override
	public Text createView(final IModelElement model) {
		ModelType value = readValue(model);
		CompoundText result = new CompoundText();
		Text valueText = createValueView(value, model);
		result.addText(valueText);						
		model.addChangeListener(new ModelEventListener(model, result, valueText));
		return result;
	}
	
	private ModelType readValue(final IModelElement model) {
		ModelType value = (ModelType)model.getValue(getProperty());
		if (value instanceof ICollection) {
			ICollection<ModelType> collectionValue = (ICollection<ModelType>)value;
			if (collectionValue.size() == 0) {
				value = null;
			} else {
				value = ((ICollection<ModelType>)value).iterator().next();
			}
		}
		return value;
	}
	
	private Text createValueView(ModelType value, final IModelElement model) {
		if (value != null) {
			Text valueText = getValueTemplate().getView(value, null);
			valueText.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));
			valueText.setElement(MarkFlag.class, new MarkFlag());
			valueText.addElement(IDeleteEventHandler.class,  new RemoveTextEventListener(model, getProperty(), value));
			return valueText;
		} else{			
			Text seed = new FixText("<...>");
			seed.addElement(IProposalHandler.class, new IProposalHandler() {
				public ProposalKind getProposalKind() {
					return ProposalKind.insert;
				}		

				public List<Proposal> getProposals(Text context, int offset) {
					return getValueTemplate().getProposals();
				}

				public boolean handleProposal(Text text, int offset, Proposal proposal) {
					if (getProposals(text, offset).contains(proposal)) {
						ICommand command = getValueTemplate().getCommandForProposal(proposal,  model, getProperty(), 0);
						command.execute();										
						return true;
					} else {
						return false;
					}
				}		
			});			
			seed.setElement(CursorMovementStrategy.class, new CursorMovementStrategy(true, true));
			return seed;
		}
	}
	
	class ModelEventListener extends hub.sam.tef.models.ModelEventListener {
		private final IModelElement fModel;
		private final Text valueView;
		private Text currentText;
		
		public ModelEventListener(final IModelElement model, final Text valueView, final Text currentText) {
			super(valueView, model);
			this.currentText = currentText;
			this.fModel = model;
			this.valueView = valueView;
		}

		@Override
		public void propertyChanged(Object element, String property) {
			if (property == getProperty()) {
				Text newText = createValueView(readValue(fModel), fModel);
				((CompoundText)valueView).replaceText(currentText, newText);
				currentText = newText;				
				valueView.update();			
			}			
		}	
	}
	
	/**
	 * This controller element is notified when the user selects a element for
	 * deletion. It will then remove the according value from the property's values.
	 */
	class RemoveTextEventListener extends AbstractRequestHandler<ModelType>
			implements IDeleteEventHandler {
		
		public RemoveTextEventListener(final IModelElement owner, String property, final ModelType element) {
			super(owner, property, element);						
		}

		public void handleEvent(Text text) {						
			getModelProvider().getModel().getCommandFactory().delete(getValue()).execute();					
		}	
	}	
}
