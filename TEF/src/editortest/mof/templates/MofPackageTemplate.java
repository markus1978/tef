package editortest.mof.template;

import editortest.model.IMetaModelElement;
import editortest.template.ElementTemplate;
import editortest.template.IdentifierTemplate;
import editortest.template.ListTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;

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
				new ListTemplate("ownedType", getMetaModel()) {
					@Override
					public Template getElementTemplate() {
						return new MofClassTemplate(getMetaModel().getType("Class"));
					}					
				},
				new TerminalTemplate("}\n")
		};
	}
}
