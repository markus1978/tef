package hub.sam.tef.completion;

import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.reconciliation.syntax.ISyntaxProvider;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.LayoutElementTemplate;
import hub.sam.tef.templates.OptionalTemplate;
import hub.sam.tef.templates.PropertyTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TemplateException;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.WhitespaceTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * This is a single reduction completion which is automatically derived from an element template.
 */
public class StandardReferenceCompletion extends SingleReductionCompletion {

	private Rule fRule = null;
	private String[] fRulePrefix = null;
	private final ElementTemplate fTemplate;
	private final String fProperty;
	
	public StandardReferenceCompletion(ElementTemplate tpl, String property) {
		this.fTemplate = tpl;
		this.fProperty = property;			
	}
	
	@Override
	public Rule getRule() {
		if (fRule == null) {
			initialise();
		}
		return fRule;
	}

	@Override
	public String[] getRulePrefix() {
		if (fRulePrefix == null) {
			initialise();
		}
		return fRulePrefix;
	}
	
	private void initialise() {
		ISyntaxProvider syntaxProvider = fTemplate.getAdapter(ISyntaxProvider.class);
		List<String> rule = new Vector<String>();
		List<String> rulePrefix = new Vector<String>();
		rule.add(syntaxProvider.getNonTerminal());						
		
		if (addTemplatesToRule(rule, rulePrefix, fTemplate.getNestedTemplates())) {
			fRulePrefix = rulePrefix.toArray(new String[] {});
			fRule = new Rule (rule.toArray(new String[] {}));				
		} else {
			throw new TemplateException("The is no property "  + fProperty + " in element template " + 
					fTemplate + ".");		
		}  					
	}
	
	@SuppressWarnings("unchecked")
	private boolean addTemplatesToRule(List<String> rule, List<String> rulePrefix, Template[] templates) {
		for (Template part: templates) {
			if (part instanceof PropertyTemplate) {
				if (((PropertyTemplate)part).getProperty().equals(fProperty)) {
					if (((PropertyTemplate)part).getValueTemplate() instanceof OptionalTemplate) {
						loop: for (Template subPart:((PropertyTemplate)part).getValueTemplate().getNestedTemplates()) {
							if (subPart instanceof ValueTemplate) {
								break loop;
							}
							addATemplateToRule(rule, rulePrefix, subPart);
						}
						return true;
					} else {
						return true;
					}
				}
			}
			addATemplateToRule(rule, rulePrefix, part);
		}
		return false;
	}

	private void addATemplateToRule(List<String> rule, List<String> rulePrefix,
			Template part) {
		if (!(part instanceof WhitespaceTemplate) && !(part instanceof LayoutElementTemplate)) {
			rulePrefix.add(part.getAdapter(ISyntaxProvider.class).getNonTerminal());
			rule.add(part.getAdapter(ISyntaxProvider.class).getNonTerminal());
		}
	}

	public Collection<TEFCompletionProposal> createProposals(ASTElementNode completionNode, CompletionContext context) {
		return fTemplate.createPropertyCompletionProposals(fProperty, completionNode, context);
	}

	
}
