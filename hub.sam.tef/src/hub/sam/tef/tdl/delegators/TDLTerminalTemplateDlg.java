package hub.sam.tef.tdl.delegators;

import hub.sam.tef.tdl.model.TDLTerminalTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;

public class TDLTerminalTemplateDlg extends TerminalTemplate {

	public TDLTerminalTemplateDlg(Template template, TDLTerminalTemplate tdlTemplate) {
		super(template, tdlTemplate.getTerminal());
	}

}
