package editortest.template;

import editortest.model.IModelElement;
import editortest.model.ModelEventListener;
import editortest.text.Text;

public abstract class SingleValueTemplate<ModelType> extends PropertyTemplate<ModelType> {
	
	private final ValueTemplate<ModelType> fValueTemplate;
	
	public SingleValueTemplate(ElementTemplate elementTemplate, String property) {
		super(elementTemplate, property);
		fValueTemplate = createValueTemplate();
		fValueTemplate.setPropertyTemplate(this);
	}

	protected abstract ValueTemplate<ModelType> createValueTemplate();
	
	class MyModelEventListener extends ModelEventListener {
		private final IModelElement fModel;
		private final Text valueView;
		
		public MyModelEventListener(final IModelElement model, final Text valueView) {
			super();
			fModel = model;
			this.valueView = valueView;
		}

		@Override
		public void propertyChanged(Object element, String property) {
			if (property == getProperty()) {
				fValueTemplate.updateView(valueView, (ModelType)fModel.getValue(property));
			}
		}	
	}
	
	@Override
	public Text createView(final IModelElement model) {
		final Text result = fValueTemplate.createView((ModelType)model.getValue(getProperty()), model);
		model.addChangeListener(new MyModelEventListener(model, result));
		return result;
	}

	@Override
	public void updateProperty(Text view, IModelElement model, ModelType value) {
		model.setValue(getProperty(), value);		
	}		
}
