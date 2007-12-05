package hub.sam.tef.primitivetypes;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.semantics.IValuePrintSemantics;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.Pattern;
import hub.sam.tef.tsl.PatternTerminal;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslFactory;
import hub.sam.tef.tsl.ValueBinding;
import hub.sam.tef.prettyprinting.PrettyPrintState;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.rules.IRule;

/**
 * Primitive type descriptors describe how primitive types are represented in a
 * syntax. TEF works with the RCC parser library, which uses specific symbols to
 * represent tokens based on regular expressions. The user is not intended to
 * use these tokens directly within its TSL syntaxes. Instead he should use
 * specific non terminals, which have implicit rules that reduce these terminals
 * with the according tokens. This class allows to define such terminals
 * (rccSymbol), their non terminal representative (nonTerminalName), and
 * according implicit rules (primitive type rule).<br/>
 * 
 * This class allows to describe extensions to RCC syntaxes with additional
 * rules necessary to describe the tokens. It allows to describe extension to
 * TSL syntaxes with the implicit primitive type rules; primitive bindings to
 * these rules; semantics for these bindings.<br/>
 * 
 * Primitive type descriptors can be registered with TEF using the extension
 * point hub.sam.tef.primitivetypedescriptor.
 */
public abstract class PrimitiveTypeDescriptor {
	
	private static class RccStandardPrimitiveTypeDescriptor extends PrimitiveTypeDescriptor {
		private final String fNonTerminalName;
		private final String fRccSymbol;
		
		
		public RccStandardPrimitiveTypeDescriptor(String nonTerminalName,
				String rccSymbol) {
			super();
			fNonTerminalName = nonTerminalName;
			fRccSymbol = rccSymbol;
		}

		@Override
		public String getNonTerminalName() {
			return fNonTerminalName;
		}

		@Override
		public String getRCCSymbol() {
			return fRccSymbol;
		}		
	}
	
	private static Collection<PrimitiveTypeDescriptor> fRegisteredTypeDescriptors = null;
	/**
	 * Retrieves all primitive type descriptors from eclipse's extension registry.
	 */
	public static Collection<PrimitiveTypeDescriptor> getRegisteredTypeDescriptors() {
		if (fRegisteredTypeDescriptors == null) {
			fRegisteredTypeDescriptors = new ArrayList<PrimitiveTypeDescriptor>();
			IExtensionRegistry reg = Platform.getExtensionRegistry();
			
			IConfigurationElement[] elements = reg.getConfigurationElementsFor(TEFPlugin.PLUGIN_ID, 
					"primitivetypedescriptor");
			for (IConfigurationElement element: elements) {
				PrimitiveTypeDescriptor primitiveTypeDescriptor = null;
				try {
					String symbolName = element.getAttribute("symbolname");
					if (element.getAttribute("class") != null) {
						primitiveTypeDescriptor = 
							(PrimitiveTypeDescriptor)element.createExecutableExtension("class");
					} else {
						String rccSymbol = element.getAttribute("rccsymbol");				
						primitiveTypeDescriptor = new RccStandardPrimitiveTypeDescriptor(
								symbolName, rccSymbol);
					}
				} catch (Exception e) {
					TEFPlugin.getDefault().getLog().log(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
							Status.ERROR, "could not instantiate a primitive type descriptor", e));
				}
				fRegisteredTypeDescriptors.add(primitiveTypeDescriptor);
			}
		}
		return fRegisteredTypeDescriptors;
	}
	
	/**
	 * Used to identify the type descriptor by its binding.
	 */
	private ValueBinding binding = null;

	/**
	 * @return the non terminal for the primitive type rule. This will be used
	 *         as LHS symbol in this rule. Users can use this symbol as a RHS
	 *         symbol.
	 */
	public abstract String getNonTerminalName();
	
	/**
	 * @return the RCC symbol for the primitive type rule. This will be used as
	 *         the only RHS symbol in this rule.
	 */
	public abstract String getRCCSymbol();
	
	/**
	 * Adds the implicit primitive type rule to an existing syntax. The rules
	 * are only added when the syntax uses the primitive types (uses the
	 * according non terminals).
	 */
	public final void addRulesToATslSyntax(Syntax syntax) {
		TslFactory factory = TslFactory.eINSTANCE;
		EList<Pattern> patterns = syntax.getPattern();
		EList<Rule> rules = syntax.getRules();
		
		// check whether the non terminal is used
		Iterator<EObject> it = syntax.eAllContents();
		boolean usesType = false;
		String nonTerminalName = getNonTerminalName();
		contentLoop: while(it.hasNext()) {
			EObject next = it.next();
			if (next instanceof NonTerminal && ((NonTerminal)next).getName().equals(
					nonTerminalName)) {
				usesType = true;
				break contentLoop;
			}
		}
		if (!usesType) {
			return;
		}		
		
		Pattern pattern = factory.createPattern();
		pattern.setRccSymbol(getRCCSymbol());
		patterns.add(pattern);
	
		Rule patternRule = factory.createSimpleRule();
		NonTerminal patternNonTerminal = factory.createNonTerminal();
		patternNonTerminal.setName(nonTerminalName);
		patternRule.setLhs(patternNonTerminal);
		PatternTerminal patternTerminal = factory.createPatternTerminal();
		patternTerminal.setPattern(pattern);
		((SimpleRule)patternRule).getRhs().add(patternTerminal);
		binding = factory.createPrimitiveBinding();
		binding.setBindingId(nonTerminalName);
		patternRule.setValueBinding(binding);
		rules.add(patternRule);
	}
	
	/**
	 * Identifies this type descriptor based on the binding used in the primitive
	 * type grammar rule.
	 */
	public boolean isTypeDescriptorFor(ValueBinding binding) {		
		if (this.binding != null) {
			return this.binding.getBindingId().equals(binding.getBindingId());
		} else {
			return false; // this binding was never activated, i.e. used in a TSL syntax.
		}
	}
	
	/**
	 * Allows to add new rules to a RCC syntax. This might be necessary when
	 * additional lexer rules beyond the standard RCC tokens are needed. This
	 * must not be used to add implicit primitive type rules to the RCC syntax,
	 * because the RCC syntax is created from a TSL syntax that already contains
	 * these rules.
	 */
	public final void addRulesToARccSyntax(Syntax syntax, hub.sam.tef.rcc.syntax.Syntax rccSyntax) {
		// emtpy, this implementation is only for primitive type descriptors
		// that use standard RCC terminal tokens
		Iterator<EObject> it = syntax.eAllContents();
		boolean usesType = false;
		String nonTerminalName = getNonTerminalName();
		contentLoop: while(it.hasNext()) {
			EObject next = it.next();
			if (next instanceof NonTerminal && ((NonTerminal)next).getName().equals(
					nonTerminalName)) {
				usesType = true;
				break contentLoop;
			}
		}
		if (!usesType) {
			return;
		}
		for (hub.sam.tef.rcc.syntax.Rule rccRule: getAdditionalRCCRules()) {
			rccSyntax.addRule(rccRule);
		}
	}
	
	protected hub.sam.tef.rcc.syntax.Rule[] getAdditionalRCCRules() {
		return new hub.sam.tef.rcc.syntax.Rule[] {};
	}
	
	/**
	 * The primitive type rule should contain a primitive binding. This method
	 * can be used to give a custom semantics for this binding. It has not
	 * be used when the default primitive value semantics (toString()) is
	 * enough (return null).
	 */
	public IValuePrintSemantics getValuePrintSemantics() {
		return new IValuePrintSemantics() {
			@Override
			public boolean printValue(Object modelValue, ValueBinding binding, 
					PrettyPrintState state) throws ModelCreatingException {
				if (modelValue != null) {
					state.append(modelValue.toString());
					return true;
				} else {
					return false;
				}
			}			
		};
	}
	
	/**
	 * The primitive type rule should contain a primitive binding. This method
	 * can be used to give a custom semantics for this binding. It has not be
	 * used when the default primitive value semantics
	 * (parseTreeNode.getNodeText()) is enough (return null).
	 */
	public IValueCreationSemantics getValueCreationSemantics() {
		// empty, all the standard RCC terminal tokens and respective
		// primitive types work with the standard semantics.
		return null;
	}
	
	/**
	 * @return determines what is proposed when the user could enter a primitive
	 *         value.
	 */
	public IContentAssistSemantics getContentAssistSemantics() {
		return null;
	}
	
	/**
	 * The highlighting used to highlight literals of this primitive type.
	 * @return a rule or null.
	 */
	public IRule getHighlightRule() {
		// null for normal text without highlight
		return null;
	}
}
