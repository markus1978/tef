package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IModelElement;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.ChoiceTemplate;
import editortest.template.CollectionTemplate;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;
import editortest.text.Proposal;

public class MofPackageTemplate extends ElementTemplate {

	public MofPackageTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Package"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(this), 
				new TerminalTemplate(this, "package "),
				new IdentifierTemplate(this, getMetaElement(), false),
				new TerminalTemplate(this, " {\n"),
				new CollectionTemplate<IModelElement>(this, "nestedPackage", "\n", true) {
					@Override
					protected ValueTemplate<IModelElement> createElementTemplate() {
						return new MofPackageTemplate(this);						
					}
				},
				new CollectionTemplate<IModelElement>(this, "ownedType", "\n", true) {
					@Override
					public ValueTemplate<IModelElement> createElementTemplate() {
						return new ChoiceTemplate(this) {
							@Override
							public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
								return new ValueTemplate[] {
										new MofClassTemplate(this),
										new MofPrimitiveTypeTemplate(this)
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
