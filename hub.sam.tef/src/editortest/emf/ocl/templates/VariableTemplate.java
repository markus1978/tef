package editortest.emf.ocl.templates;

import java.util.Arrays;
import java.util.List;

import editortest.emf.model.EMFMetaModelElement;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class VariableTemplate extends ElementTemplate {

	public VariableTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Variable"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {			
					return new StringTemplate(this);
				};
			}
		};
	}

	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
		});
	}
	
	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}
}
