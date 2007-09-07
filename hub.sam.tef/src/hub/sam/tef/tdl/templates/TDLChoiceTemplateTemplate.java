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
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

public class TDLChoiceTemplateTemplate extends ElementTemplate {

	
	public TDLChoiceTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLChoiceTemplate"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new WhitespaceTemplate(this, BlockLayout.INDENT),
				new TerminalTemplate(this, "choice"),
				new WhitespaceTemplate(this, BlockLayout.SPACE),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new IdentifierTemplate(this);
					}					
				},
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
				new WhitespaceTemplate(this, BlockLayout.SPACE),
				new TerminalTemplate(this, "{"),
				new WhitespaceTemplate(this, BlockLayout.BEGIN_BLOCK),
				new SequenceTemplate<IModelElement>(this, "alternatives", null, false) {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new TemplateValueTemplate(this);
					}				
				},
				new WhitespaceTemplate(this, BlockLayout.END_BLOCK),
				new WhitespaceTemplate(this, BlockLayout.INDENT),
				new TerminalTemplate(this, "}"),
				new WhitespaceTemplate(this, BlockLayout.STATEMENT)
		};
	}
	
	@Override
	public String[] getPropertiesWithCompletion() {
		return new String[] { "metaElement" };
	}

	@Override
	public Collection<TEFCompletionProposal> createPropertyCompletionProposals(String property, 
			ASTElementNode completionNode, CompletionContext context) {		
		return EMFCompletions.createProposals("EClass", "name", context);
	}
	
	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}	
}
