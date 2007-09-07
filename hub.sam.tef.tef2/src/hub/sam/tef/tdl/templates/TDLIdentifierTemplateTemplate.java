package hub.sam.tef.tdl.templates;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;

public class TDLIdentifierTemplateTemplate extends ElementTemplate {

	public TDLIdentifierTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLIdentifierTemplate"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new TerminalTemplate(this, "IDENTIFIER") { 
					protected Color getColor() {
						return new Color(Display.getCurrent(), new RGB(120,0,120));
					}	
				}
		};
	}

}
