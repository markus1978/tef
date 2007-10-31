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
import hub.sam.tef.templates.primitives.BooleanLiteralTemplate;
import hub.sam.tef.templates.primitives.StringLiteralTemplate;

public class TDLSequenceTemplateTemplate extends ElementTemplate {

	
	public TDLSequenceTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLSequenceTemplate"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new WhitespaceTemplate(this, BlockLayout.INDENT),			
			new TerminalTemplate(this, "sequence"),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new TerminalTemplate(this, "for"),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new SingleValueTemplate<IModelElement>(this, "property") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ReferenceTemplate(this, getModel().getMetaElement("EStructuralFeature")) {
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
			new SingleValueTemplate<IModelElement>(this, "valueTemplate") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new TemplateValueTemplate(this);
				}				
			},
			new TerminalTemplate(this, ","),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new TerminalTemplate(this, "seperator"),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new SingleValueTemplate<String>(this, "separator") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new StringLiteralTemplate(this);
				}				
			},
			new TerminalTemplate(this, ","),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new TerminalTemplate(this, "last"),
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new SingleValueTemplate<Boolean>(this, "separateLast") {
				@Override
				protected ValueTemplate<Boolean> createValueTemplate() {
					return new BooleanLiteralTemplate(this);
				}				
			},
			new WhitespaceTemplate(this, BlockLayout.EMPTY),
			new TerminalTemplate(this, ";"),
			new WhitespaceTemplate(this, BlockLayout.STATEMENT),
		};
	}

	@Override
	public String[] getPropertiesWithCompletion() {
		return new String[] { "property" };
	}

	@Override
	public Collection<TEFCompletionProposal> createPropertyCompletionProposals(String property, 
			ASTElementNode completionNode, CompletionContext context) {		
		return EMFCompletions.createProposals("EStructuralFeature", "name", context);
	}
}
