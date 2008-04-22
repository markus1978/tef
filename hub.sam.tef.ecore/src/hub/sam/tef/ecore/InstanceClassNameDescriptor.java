package hub.sam.tef.ecore;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.tsl.ValueBinding;

public class InstanceClassNameDescriptor extends PrimitiveTypeDescriptor {
	
	private static final String nonTerminalName = "INSTANCE_CLASS_NAME"; 
	private static final String rccSymbol = "__INSTANCE_CLASS_NAME";
	private static final String list = "__INSTANCE_CLASS_NAME_List";
	private static final String arrayOpt = "__INSTANCE_CLASS_NAME_ArrayOpt";
	private static final String element = "__INSTANCE_CLASS_NAME_Element";

	@Override
	public String getNonTerminalName() {
		return nonTerminalName;
	}

	@Override
	public String getRCCSymbol() {
		return rccSymbol;
	}

	@Override
	protected Rule[] getAdditionalRCCRules() {
		return new Rule[] { 
				new Rule(new String[] {rccSymbol, list, arrayOpt}),
				new Rule(new String[] {list, element, "\".\"", list }),
				new Rule(new String[] {list, element}),
				new Rule(new String[] {element, "`identifier`", "\"$\"", "`identifier`"}),
				new Rule(new String[] {element, "`identifier`"}),
				new Rule(new String[] {arrayOpt, "\"[]\""}),
				new Rule(new String[] {arrayOpt})
		};
	}

	@Override
	public IValueCreationSemantics getValueCreationSemantics() {
		return fValueCreationSemantics;
	}
	
	private final IValueCreationSemantics fValueCreationSemantics = new IValueCreationSemantics() {
		public Object createValue(ParseTreeNode parseTreeNode,
				IModelCreatingContext context, ValueBinding binding)
				throws ModelCreatingException {
			return parseTreeNode.getNodeText();
		}		
	};

}
