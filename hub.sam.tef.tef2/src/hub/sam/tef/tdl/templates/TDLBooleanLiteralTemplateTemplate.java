package hub.sam.tef.tdl.templates;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;

public class TDLBooleanLiteralTemplateTemplate extends ElementTemplate {

	public TDLBooleanLiteralTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLBooleanLiteralTemplate"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new TerminalTemplate(this, "BOOLEAN") { 
					protected Color getColor() {
						return new Color(Display.getCurrent(), new RGB(120,0,120));
					}	
				}
		};
	}
}
