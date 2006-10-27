package editortest.template;

import editortest.model.IMetaModelElement;

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
