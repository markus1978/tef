package hub.sam.tef.tdl.templates;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;

public class TDLUnsignedIntegerTemplateTemplate extends ElementTemplate {

	public TDLUnsignedIntegerTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLUnsignedIntegerTemplate"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new TerminalTemplate(this, "UNSIGNEDINTEGER") {
					protected Color getColor() {
						return new Color(Display.getCurrent(), new RGB(120,0,120));
					}
				}
		};
	}

}
