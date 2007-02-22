package editortest.mof.template;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.SetTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Arrays;
import java.util.List;

import editortest.mof.model.MofModelElementImpl;

public class MofPackageTemplate extends MofNamedElementTemplate {

	public MofPackageTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Package"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(this), 
				new TerminalTemplate(this, "package ", TerminalTemplate.KEY_WORD_HIGHLIGHT),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				},
				new TerminalTemplate(this, " {\n"),
				new SetTemplate<IModelElement>(this, "nestedPackage", "\n", true) {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new MofPackageTemplate(this);						
					}
				},
				new SetTemplate<IModelElement>(this, "ownedType", "\n", true) {
					@Override
					public ValueTemplate<IModelElement> createValueTemplate() {
						return new ChoiceTemplate(this, getModel().getMetaElement("Classifier")) {
							@Override
							public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
								return new ValueTemplate[] {
										new MofClassTemplate(this),
										new MofPrimitiveTypeTemplate(this),
										new MofEnumerationTemplate(this)
								};								
							}							
						};					
					}					
				},
				new MofIndentationTemplate(this),
				new TerminalTemplate(this, "}")
		};
	}

	@Override
	public boolean isTemplateFor(IModelElement model) {
		return ((MofModelElementImpl)model).getMofObject() instanceof cmof.Package;
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("package... ", null, 0)
		});
	}
}
