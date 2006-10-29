package editortest.mof.template;

import java.util.Arrays;
import java.util.List;

import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.AlternativeTemplate;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.ListTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.text.Proposal;

public class MofPackageTemplate extends ElementTemplate {

	public MofPackageTemplate(IMetaModelElement metaModel) {
		super(metaModel);
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new TerminalTemplate("package "),
				new IdentifierTemplate("name", getMetaModel()),
				new TerminalTemplate(" {\n"),
				new ListTemplate("nestedPackage", getMetaModel()) {
					@Override
					public Template getElementTemplate() {
						return new MofPackageTemplate(getMetaModel());							
					}
				},
				new ListTemplate("ownedType", getMetaModel()) {
					@Override
					public Template getElementTemplate() {
						return new AlternativeTemplate() {
							@Override
							public Template[] createAlternativeTemplates() {
								return new Template[] {
										new MofClassTemplate(getMetaModel().getType("Class")),
										new MofPrimitiveTypeTemplate(getMetaModel().getType("PrimitiveType"))
								};								
							}							
						};					
					}					
				},
				new TerminalTemplate("}\n")
		};
	}

	@Override
	public boolean isTemplateFor(Object model) {
		return ((MofModelElementImpl)model).getMofObject() instanceof cmof.Package;
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("package... ", "package <unnamed> {\n}\n")
		});
	}
}
