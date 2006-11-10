package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IModelElement;
import editortest.template.ElementTemplate;
import editortest.template.ReferenceTemplate;
import editortest.template.SingleValueTemplate;
import editortest.template.StringTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;
import editortest.text.visitors.Proposal;

public class MofParameterTemplate extends MofNamedElementTemplate {
	public MofParameterTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Parameter"));
	}

	@Override
	public Template[] createTemplates() {		
		return new Template[] {
				new SingleValueTemplate<IModelElement>(this, "type") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new ReferenceTemplate(this, getModel().getMetaElement("Type"), null) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new IdentifierTemplate(this);
							}							
						};
					}										
				},
				new TerminalTemplate(this, " "),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				},
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("parameter... ", null, 0)
		});
	}
}
