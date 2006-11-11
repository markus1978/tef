package editortest.template;

import editortest.controller.Proposal;
import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.view.CompoundText;
import editortest.view.Text;

public abstract class ElementTemplate extends ValueTemplate<IModelElement> {
	
	private final IMetaModelElement fMetaModel;
	private Template[] fTemplates;

	public ElementTemplate(Template template, IMetaModelElement metaModel) {
		super(template);		
		fMetaModel = metaModel;
	}	

	public abstract Template[] createTemplates();
	
	private final Template[] getTemplates() {
		if (fTemplates == null) {
			fTemplates = createTemplates();
		}
		return fTemplates;
	}
	
	protected IMetaModelElement getMetaElement() {
		return this.fMetaModel;
	}

	public Text createView(IModelElement model) {
		return createView(model, new IValueChangeListener<IModelElement>() {
			public void valueChanges(IModelElement newValue) {
				// empty				
			}			
		});
	}
	
	@Override
	public Text createView(IModelElement model, IValueChangeListener<IModelElement> changeListener) {
		CompoundText result = new CompoundText();
		for (Template template: getTemplates()) {
			if (template instanceof TerminalTemplate) {
				result.addText(((TerminalTemplate)template).createView());
			} else if (template instanceof PropertyTemplate) {
				PropertyTemplate propertyTemplate = (PropertyTemplate)template;
				Text propertyText = ((PropertyTemplate)template).createView(model);
				if (isIdentifierProperty(propertyTemplate.getProperty())) {
					model.registerOccurence(propertyText);
				}											
				result.addText(propertyText);
			} else if (template instanceof ElementTemplate) {
				result.addText(((ElementTemplate)template).createView(model));
			} else {
				throw new RuntimeException("assert");
			}			
		}
		return result;
	}	

	public IModelElement createModelFromProposal(Proposal proposal) {
		IModelElement result = getModel().createElement(getMetaElement());		
		return result;
	}	
	
	public boolean isTemplateFor(IModelElement model) {		
		return getMetaElement().isMetaModelFor(model);
	}

	@Override
	public void deleteModel(IModelElement model) {
		model.delete();
	}
	
	protected boolean isIdentifierProperty(String property) {
		return false;
	}
}
