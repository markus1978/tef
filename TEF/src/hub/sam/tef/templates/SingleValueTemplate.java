package hub.sam.tef.templates;

import hub.sam.tef.controllers.AbstractRequestHandler;
import hub.sam.tef.controllers.RetifyCursorPositionModelEventListener;
import hub.sam.tef.liveparser.SymbolASTNode;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.ITextStatusListener;
import hub.sam.tef.views.Text;

public abstract class SingleValueTemplate<ModelType> extends PropertyTemplate<ModelType> {
	
	private final ValueTemplate<ModelType> fValueTemplate;
	
	public SingleValueTemplate(ElementTemplate elementTemplate, String property) {
		super(elementTemplate, property);
		fValueTemplate = createValueTemplate();
	}

	protected abstract ValueTemplate<ModelType> createValueTemplate();
	
	class ModelEventListener extends RetifyCursorPositionModelEventListener {
		private final IModelElement fModel;
		private final Text valueView;
		
		public ModelEventListener(final IModelElement model, final Text valueView) {
			super(model, valueView);
			fModel = model;
			this.valueView = valueView;
		}

		@Override
		public void propertyChanged(Object element, String property) {
			if (property == getProperty()) {
				fValueTemplate.updateView(valueView, (ModelType)fModel.getValue(property));
				setNewCursorPosition(valueView.nextText(), 1);				
				valueView.update();				
			}			
		}	
	}
	
	class ValueChangeListener extends AbstractRequestHandler<ModelType> 
			implements IValueChangeListener<ModelType> {
		
		public ValueChangeListener(final IModelElement owner, String property) {
			super(owner, property, null);			
		}
		
		public void valueChanges(ModelType newValue) {
			getModel().getCommandFactory().set(getOwner(), getProperty(), newValue).execute();
		}

		public void valueChanges(SymbolASTNode node) {
			node.createModelElements(getModel(), getOwner(), getProperty());
		}				
		
	}
	
	@Override
	public Text createView(final IModelElement model) {
		ModelType value = (ModelType)model.getValue(getProperty());
		final Text result = fValueTemplate.createView(value, 
				new ValueChangeListener(model, getProperty()));
		new ModelEventListener(model, result); // activates itself once the view is shown
		return result;
	}
		
}
