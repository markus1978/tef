package hub.sam.tef.templates;

import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;

public class WhitespaceTemplate extends Template {

	private final int fRole;
	
	public WhitespaceTemplate(Template template, final int role) {
		super(template);
		this.fRole = role;
	}

	public String getSpace(AbstractLayoutManager layout) {
		return layout.getSpace(fRole);
	}
}
