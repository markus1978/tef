package hub.sam.tef.tdl.templates;

import java.util.Collection;

import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.emf.EMFCompletions;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.layout.ExpressionLayout;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.OptionalTemplate;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;
import hub.sam.tef.templates.primitives.StringLiteralTemplate;

public class TDLElementTemplateTemplate extends ElementTemplate {

	
	public TDLElementTemplateTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLElementTemplate"));	
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
			new SingleValueTemplate<IModelElement>(this, "identifierProperty") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new OptionalTemplate(this, this.getModel().getMetaElement("EStructuralFeature")) {
							@Override
							public Template[] createOptionTemplate() {
								return new Template[] {
									new WhitespaceTemplate(this, BlockLayout.EMPTY),
									new TerminalTemplate(this, ","),										
									new WhitespaceTemplate(this, BlockLayout.SPACE),
									new TerminalTemplate(this, "idprop"),
									new WhitespaceTemplate(this, BlockLayout.SPACE),									
									new ReferenceTemplate(this, getModel().getMetaElement("EStructuralFeature")) {
										@Override
										protected ElementTemplate getElementTemplate() {
											return new EMFIdentifierTemplate(this);
										}																		
									}
								};
							}				
					};
				}				
			},	
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
					return new TDLTemplateTemplate(this);
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
		return new String[] { "metaElement", "identifierProperty" };
	}

	@Override
	public Collection<TEFCompletionProposal> createPropertyCompletionProposals(String property, 
			ASTElementNode completionNode, CompletionContext context) {
		if (property.equals("metaElement")) {
			return EMFCompletions.createProposals("EClass", "name", context);
		} else if (property.equals("identifierProperty")) {
			return EMFCompletions.createProposals("EAttribute", "name", context);
		} else {
			throw new RuntimeException("assert");
		}
	}

	@Override
	protected boolean isIdentifierProperty(String property) {
		return "name".equals(property);
	}	
}
