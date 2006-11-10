package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.mof.template.MofPropertyTemplate.MyReferenceProposalStrategy;
import editortest.template.ElementTemplate;
import editortest.template.ReferenceTemplate;
import editortest.template.SetTemplate;
import editortest.template.SingleValueTemplate;
import editortest.template.StringTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;
import editortest.text.visitors.Proposal;

public class MofLiteralTemplate extends MofNamedElementTemplate {
	
	public MofLiteralTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EnumerationLiteral"));
	}
	

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(this),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				},				
				new TerminalTemplate(this, ";")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("literal... ", null, 0)
		});
	}

}
