package hub.sam.tef.tdl.templates;

import java.util.Collection;

import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.emf.EMFCompletions;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.BlockLayout;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;

public class TDLReferenceTemplateTemplate extends ElementTemplate {

	
	public TDLReferenceTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLReferenceTemplate"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new TerminalTemplate(this, "("),
			new WhitespaceTemplate(this, BlockLayout.EMPTY),			
			new TerminalTemplate(this, "ref"),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new TerminalTemplate(this, "for"),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new SingleValueTemplate<IModelElement>(this, "metaElement") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ReferenceTemplate(this, getModel().getMetaElement("EClass")) {
						@Override
						protected ElementTemplate getElementTemplate() {
							return new EMFIdentifierTemplate(this);
						}						
					};					
				}				
			},
			new WhitespaceTemplate(this, BlockLayout.EMPTY),
			new TerminalTemplate(this, ","),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new TerminalTemplate(this, "with"),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new SingleValueTemplate<IModelElement>(this, "elementTemplate") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new TemplateValueTemplate(this);
				}				
			},
			new WhitespaceTemplate(this, BlockLayout.EMPTY),
			new TerminalTemplate(this, ")")			
		};
	}
	
	@Override
	public String[] getPropertiesWithCompletion() {
		return new String[] { "metaElement", "elementTemplate" };
	}

	@Override
	public Collection<TEFCompletionProposal> createPropertyCompletionProposals(String property, 
			ASTElementNode completionNode, CompletionContext context) {
		if (property.equals("metaElement")) {
			return EMFCompletions.createProposals("EClass", "name", context);
		} else {
			return EMFCompletions.createProposals("TDLTemplate", "name", context);
		}
	}
}
