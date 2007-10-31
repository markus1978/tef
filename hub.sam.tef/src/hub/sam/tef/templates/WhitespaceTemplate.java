package hub.sam.tef.templates;

import hub.sam.tef.layout.AbstractLayoutManager;

public class WhitespaceTemplate extends Template {

	private final int fRole;
	
	public WhitespaceTemplate(Template template, final int role) {
		super(template);
		this.fRole = role;
	}

	public final String getSpace(AbstractLayoutManager layout) {
		return layout.getSpace(getRole());
	}
	
	protected int getRole() {
		return fRole;
	}
}
