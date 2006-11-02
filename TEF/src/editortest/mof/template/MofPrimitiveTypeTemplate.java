package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.text.Proposal;

public class MofPrimitiveTypeTemplate extends ElementTemplate {

	public MofPrimitiveTypeTemplate(Template template) {
		super(template, template.getModel().getMetaElement("PrimitiveType"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] { 
				new MofIndentationTemplate(this), 
				new TerminalTemplate(this, "primitive "),		
				new IdentifierTemplate(this, getMetaElement(), false),
				new TerminalTemplate(this, ";\n")				
		};
	}

	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("primitive... ", null, 0)
		});
	}
	
	@Override
	public boolean isTemplateFor(Object model) {
		return ((MofModelElementImpl)model).getMofObject() instanceof cmof.PrimitiveType;
	}
}
