package hub.sam.tef.tdl.templates;

import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.emf.EMFCompletions;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.syntax.BlockLayout;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

import java.util.Collection;

public class TDLEmptyElementTemplateTemplate extends ElementTemplate {

	
	public TDLEmptyElementTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLEmptyElementTemplate"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new WhitespaceTemplate(this, BlockLayout.INDENT),
			new TerminalTemplate(this, "element"),
			new WhitespaceTemplate(this, BlockLayout.SPACE),			
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new IdentifierTemplate(this);
				}			
			},
			new WhitespaceTemplate(this, BlockLayout.SPACE),		
			/*
			new SingleValueTemplate<String>(this, "alternativeSymbol") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new OptionalTemplate<String>(this, this.getModel().getType(String.class)) {
							@Override
							public Template[] createOptionTemplate() {
								return new Template[] {
									new WhitespaceTemplate(this, BlockLayout.EMPTY),
									new TerminalTemplate(this, ","),
									new WhitespaceTemplate(this, BlockLayout.SPACE),
									new TerminalTemplate(this, "as"),
									new WhitespaceTemplate(this, BlockLayout.SPACE),
									new StringLiteralTemplate(this)																									
								};
							}

							@Override
							public String getAlternativeSymbol() {
								return "Element_alternativeSymbol_opt";
							}											
					};
				}				
			},	
			*/		
			new WhitespaceTemplate(this, BlockLayout.SPACE),
			new TerminalTemplate(this, "{"),
			new WhitespaceTemplate(this, BlockLayout.BEGIN_BLOCK),
			new SequenceTemplate<IModelElement>(this, "templates", null, false) {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new ChoiceTemplate(this, getModel().getMetaElement("TemplateValue")) {
						@Override
						public ValueTemplate<IModelElement>[] createAlternativeTemplates() {
							return new ValueTemplate[] {
								new TDLTerminalTemplateTemplate(this),
								new TDLWhiteSpaceTemplateTemplate(this),
								new TemplateRefTemplate(this)
							};
						}
						@Override
						public String getAlternativeSymbol() {
							return "TDLEmptyElementTemplateChoices";
						}												
					};							
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
}