package editortest.template;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.text.CompoundText;
import editortest.text.Proposal;
import editortest.text.Text;

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
				result.addText(((PropertyTemplate)template).createView(model));
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
		result.setValue("name", "<unnamed>");
		return result;
	}	
	
	public boolean isTemplateFor(IModelElement model) {		
		return getMetaElement().isMetaModelFor(model);
	}

	@Override
	public void deleteModel(IModelElement model) {
		model.delete();
	}
	
}
