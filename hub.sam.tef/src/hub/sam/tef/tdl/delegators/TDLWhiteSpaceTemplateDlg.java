package hub.sam.tef.tdl.delegators;

import java.lang.reflect.Field;

import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.tdl.model.TDLWhiteSpaceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.WhitespaceTemplate;

public class TDLWhiteSpaceTemplateDlg extends WhitespaceTemplate {
	
	private final TDLWhiteSpaceTemplate fTdlWhiteSpaceTemplate;
	private final Class fLayoutRoles;
			
	public TDLWhiteSpaceTemplateDlg(Template template, TDLWhiteSpaceTemplate tdlWhiteSpaceTemplate,
			TemplateFactory factory) {
		super(template, -1);		
		this.fTdlWhiteSpaceTemplate = tdlWhiteSpaceTemplate;
		this.fLayoutRoles = BlockLayout.class;
	}

	@Override
	protected int getRole() {
		System.out.println(computeRoleFromString(fTdlWhiteSpaceTemplate.getRole()));
		return computeRoleFromString(fTdlWhiteSpaceTemplate.getRole());
	}	
	
	private int computeRoleFromString(String roleAsString) {
		for(Field field: fLayoutRoles.getDeclaredFields()) {
			if (field.getType().getName().equals("int") && field.getName().equals(roleAsString)) {
				try {
					return (int)field.getInt(null);
				} catch (Exception e) {			
					e.printStackTrace();
					throw new TDLException("Unknown white space role");
				}
			}
		}
		throw new TDLException("Unknown white space role");
	}
}