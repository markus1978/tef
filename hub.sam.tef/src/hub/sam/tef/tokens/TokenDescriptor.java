package hub.sam.tef.tokens;

import hub.sam.tef.TEFPlugin;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.semantics.IValuePrintSemantics;
import hub.sam.tef.tsl.Pattern;
import hub.sam.tef.tsl.TslFactory;
import hub.sam.tef.tsl.ValueBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
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
 * point hub.sam.tef.tokendescriptor.
 */
public abstract class TokenDescriptor {
	
	private static class RccStandardTokenDescriptor extends TokenDescriptor {

		private final String fRccSymbol;
		
		
		public RccStandardTokenDescriptor(String rccSymbol) {
			super();
			fRccSymbol = rccSymbol;
		}

		@Override
		protected hub.sam.tef.rcc.syntax.Rule[] getAdditionalRCCRules() {
			return new hub.sam.tef.rcc.syntax.Rule[] {};
		}
		
		@Override
		public String getRCCSymbol() {
			return fRccSymbol;
		}		
	}
	
	private static Collection<TokenDescriptor> fRegisteredTypeDescriptors = null;
	/**
	 * Retrieves all primitive type descriptors from eclipse's extension registry.
	 */
	public static Collection<TokenDescriptor> getRegisteredTokenDescriptors() {
		if (fRegisteredTypeDescriptors == null) {
			fRegisteredTypeDescriptors = new ArrayList<TokenDescriptor>();
			IExtensionRegistry reg = Platform.getExtensionRegistry();
			
			IConfigurationElement[] elements = reg.getConfigurationElementsFor(TEFPlugin.PLUGIN_ID, 
					"tokendescriptor");
			for (IConfigurationElement element: elements) {
				TokenDescriptor tokenDescriptor = null;
				try {
					if (element.getAttribute("class") != null) {
						tokenDescriptor = 
							(TokenDescriptor)element.createExecutableExtension("class");
					} else {
						String rccSymbol = element.getAttribute("rccsymbol");				
						tokenDescriptor = new RccStandardTokenDescriptor(rccSymbol);
					}
				} catch (Exception e) {
					TEFPlugin.getDefault().getLog().log(new Status(Status.ERROR, TEFPlugin.PLUGIN_ID,
							Status.ERROR, "could not instantiate a primitive type descriptor", e));
				}
				fRegisteredTypeDescriptors.add(tokenDescriptor);
			}
		}
		return fRegisteredTypeDescriptors;
	}
	
	/**
	 * Used to identify the type descriptor by its binding.
	 */
	private ValueBinding binding = null;

	/**
	 * @return the RCC symbol for the primitive type rule. This will be used as
	 *         the only RHS symbol in this rule.
	 */
	public abstract String getRCCSymbol();
	
	/**
	 * @return RCC pattern object to match against syntax definition
	 */
	public Pattern getRccPattern () {
		Pattern p = TslFactory.eINSTANCE.createPattern();
		p.setRccSymbol(this.getRCCSymbol());
		return p;
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
	 * add rules to ARcc syntax set
	 * 
	 * @param syntax current TEF parser syntax declaring the tokens to be used
	 * @param rccSyntax the RCC syntax structure storing the scanner and parser rules
	 */
	public void addRulesToARccSyntax(hub.sam.tef.rcc.syntax.Syntax rccSyntax) {
		/*
		EList<Pattern> declaredTokens = syntax.getPattern();
		
		System.err.println("this token: "+getRCCSymbol());
		for (Pattern token : declaredTokens) {
			// the token of this token descriptor is referenced in the syntax
			// description: add it to the rules
			System.err.println("declared token: "+token.getRccSymbol());
			if (token.getRccSymbol().equals(this.getRCCSymbol())) {*/
				for (hub.sam.tef.rcc.syntax.Rule rccRule: getAdditionalRCCRules()) {
					rccSyntax.addRule(rccRule);
				}
		/*	}
		}*/
	}
	
	/**
	 * @return	a set of RCC rules to be included in the scanner
	 */
	protected abstract hub.sam.tef.rcc.syntax.Rule[] getAdditionalRCCRules();
	
	/**
	 * The primitive type rule should contain a primitive binding. This method
	 * can be used to give a custom semantics for this binding. It has not
	 * be used when the default primitive value semantics (toString()) is
	 * enough (return null).
	 */
	public IValuePrintSemantics getValuePrintSemantics() {
		return new IValuePrintSemantics() {
			public boolean printValue(Object modelValue, ValueBinding binding, 
					PrettyPrintState state, PrettyPrinter printer) throws ModelCreatingException {
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
	 * @return an array of rules or null.
	 */
	public List<IRule> getHighlightRules() {
		// null for normal text without highlight
		return null;
	}
}
