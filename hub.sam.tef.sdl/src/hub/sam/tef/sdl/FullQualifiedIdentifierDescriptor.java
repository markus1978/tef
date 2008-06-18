package hub.sam.tef.sdl;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.tsl.ValueBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * An SDL full qualifier identifier looks like:
 * 
 * < PACKAGE packageName / AGENT TYPE agentTypeName / AGENT agentName > name
 * 
 * Its EBNF grammar is
 * 
 * Identifier -> Qualifier IDENTIFIER
 * Qualifier -> "<" PathItem ( "/" PathItem ) * ">"
 * PathItm -> ScopeUnitKind IDENTIFIER
 * ScopeUnitKind -> "PACKAGE" | "AGENT" "TYPE" | ...
 * 
 * Its BNF grammar is
 * 
 * Identifier -> Qualifier IDENTIFIER
 * Qualifier -> "<" PathItemList ">"
 * PathItemList -> PathItem
 * PathItemList -> PathItem "/" PathItemList
 * PathItm -> ScopeUnitKind IDENTIFIER
 * ScopeUnitKind -> "PACKAGE"
 * ScopeUnitKind -> "AGENT" "TYPE" 
 * ...
 *
 */
public class FullQualifiedIdentifierDescriptor extends PrimitiveTypeDescriptor {
		
	private static final String identifier = "FULL_IDENTIFIER";
	private static final String rccSymbol = "__FULL_IDENTIFIER";
	private static final String qualifier = "__FULL_IDENTIFIER_qualifier";
	private static final String pathItemList = "__FULL_IDENTIFIER_pathItemList";
	private static final String pathItem = "__FULL_IDENTIFIER_pathItem";
	private static final String scopeUnitKind = "__FULL_IDENTIFIER_scopeUnitKind";
	
	private static final String[][] scopeUnitKinds = { { "\"PACKAGE\"" }, { "\"AGENT\"", "\"TYPE\"" } };
	
	@Override
	public String getNonTerminalName() {
		return identifier;
	}

	@Override
	public String getRCCSymbol() {
		return rccSymbol;
	}

	@Override
	protected Rule[] getAdditionalRCCRules() {
		Rule[] baseRules = new Rule[] {				
				new Rule(new String[] { rccSymbol, qualifier, "IDENTIFIER" }),
				new Rule(new String[] { qualifier, "\"<\"", pathItemList, "\">\"" }),
				new Rule(new String[] { pathItemList, pathItem }),
				new Rule(new String[] { pathItemList, pathItem, "\"/\"", pathItemList}),
				new Rule(new String[] { pathItem, scopeUnitKind, "IDENTIFIER" })				
		};
		List<Rule> scopeUnitKindRules = new ArrayList<Rule>();
		for (String[] aScopeUnitKind: scopeUnitKinds) {
			scopeUnitKindRules.add(new Rule(addArrays(
					new String[] { scopeUnitKind }, aScopeUnitKind)));					
		}
		return addArrays(baseRules, scopeUnitKindRules.toArray(new Rule[] {}));
	}
	
	private static <T> T[] addArrays(T[] a1, T[] a2) {
		List<T> result = new ArrayList<T>(a1.length + a2.length);
		for(T e: a1) {
			result.add(e);
		}
		for(T e: a2) {
			result.add(e);
		}
		return result.toArray(a1);
	}

	@Override
	public IValueCreationSemantics getValueCreationSemantics() {
		return fValueCreationSemantics;
	}
	
	private final IValueCreationSemantics fValueCreationSemantics = new IValueCreationSemantics() {
		public Object createValue(ParseTreeNode parseTreeNode,
				IModelCreatingContext context, ValueBinding binding)
				throws ModelCreatingException {
			// TODO
			return parseTreeNode.getNodeText();
		}		
	};
}
