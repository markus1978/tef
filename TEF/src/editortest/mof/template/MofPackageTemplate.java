package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.AlternativeTemplate;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.CollectionTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.text.Proposal;

public class MofPackageTemplate extends ElementTemplate {

	public MofPackageTemplate(Template template, IModel model) {
		super(template, model, model.getMetaElement("Package"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(this), 
				new TerminalTemplate(this, "package "),
				new IdentifierTemplate(this, getModel(), "name", getMetaElement()),
				new TerminalTemplate(this, " {\n"),
				new CollectionTemplate(this, getModel(), "nestedPackage", getMetaElement()) {
					@Override
					public Template getElementTemplate() {
						return new MofPackageTemplate(this, getModel());							
					}
				},
				new CollectionTemplate(this, getModel(), "ownedType", getMetaElement()) {
					@Override
					public Template getElementTemplate() {
						return new AlternativeTemplate(this) {
							@Override
							public Template[] createAlternativeTemplates() {
								return new Template[] {
										new MofClassTemplate(this, getModel()),
										new MofPrimitiveTypeTemplate(this, getModel())
								};								
							}							
						};					
					}					
				},
				new MofIndentationTemplate(this),
				new TerminalTemplate(this, "}\n")
		};
	}

	@Override
	public boolean isTemplateFor(Object model) {
		return ((MofModelElementImpl)model).getMofObject() instanceof cmof.Package;
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("package... ", null, 0)
		});
	}
}
