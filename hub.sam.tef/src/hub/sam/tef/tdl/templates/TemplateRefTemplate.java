package hub.sam.tef.tdl.templates;

import java.util.Collection;

import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.emf.EMFCompletions;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;

public class TemplateRefTemplate extends ElementTemplate {
	
	public TemplateRefTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TemplateRef"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new TerminalTemplate(this, "@"),
				new WhitespaceTemplate(this, BlockLayout.EMPTY),
				new SingleValueTemplate<IModelElement>(this, "template") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new ReferenceTemplate(this, getModel().getMetaElement("TDLTemplate")) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new TDLTemplateIdentifierTemplate(this);
							}							
						};
					}					
				}
		};
	}

	@Override
	public String[] getPropertiesWithCompletion() {
		return new String[] { "template" };
	}

	@Override
	public Collection<TEFCompletionProposal> createPropertyCompletionProposals(String property, 
			ASTElementNode completionNode, CompletionContext context) {		
		return EMFCompletions.createProposals("TDLTemplate", "name", context);
	}	
}
