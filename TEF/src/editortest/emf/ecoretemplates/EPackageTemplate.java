package editortest.emf.ecoretemplates;

import java.util.Collection;
import java.util.Vector;

import editortest.template.SingleValueTemplate;
import editortest.template.StringTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;
import editortest.template.whitespaces.LayoutElementTemplate;
import editortest.template.whitespaces.LayoutManager;
import editortest.view.DocumentText;

public class EPackageTemplate extends EModelElementTemplate {
	
	public EPackageTemplate(Template template) {
		super(template, template.getModel().getMetaElement("EPackage"));
	}
	
	public EPackageTemplate(DocumentText document) {
		super(document, document.getDocument().getModel().getMetaElement("EPackage"));
	}

	@Override
	public Template[] createTemplates() {
		Template[] t1 = new Template[] {
				new LayoutElementTemplate(this, LayoutManager.INDENT),
				new TerminalTemplate(this, "package "),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				},
				new TerminalTemplate(this, "\n"),
				new LayoutElementTemplate(this, LayoutManager.BEGIN_BLOCK),
		};
		Template[] t2 = getAnnotationTemplates();
	    Template[] t3 = new Template[] {
	    		new LayoutElementTemplate(this, LayoutManager.END_BLOCK)
		};
	    return concat(new Template[][]{ t1, t2, t3});
	}

	protected static Template[] concat(Template[][] ts) {		
		Collection<Template> result = new Vector<Template>();
		for(Template[] t: ts) {
			for(Template s: t) {
				result.add(s);
			}
		}
		return result.toArray(new Template[]{});
	}
}
