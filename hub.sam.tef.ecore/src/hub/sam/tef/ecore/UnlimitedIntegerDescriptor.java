package hub.sam.tef.ecore;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.semantics.IValuePrintSemantics;
import hub.sam.tef.tsl.ValueBinding;

public class UnlimitedIntegerDescriptor extends PrimitiveTypeDescriptor {
	
	private static final String nonTerminalName = "UNLIMITED_INTEGER"; 
	private static final String rccSymbol = "__UNLIMITED_INTEGER";

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
				new Rule(new String[] {rccSymbol, "\"*\""}),
				new Rule(new String[] {rccSymbol, "`integer`"})
		};
	}
	
	
	@Override
	public IValuePrintSemantics getValuePrintSemantics() {
		return fValuePrintSemantics;
	}

	@Override
	public IValueCreationSemantics getValueCreationSemantics() {
		return fValueCreationSemantics;
	}
	
	private final IValueCreationSemantics fValueCreationSemantics = new IValueCreationSemantics() {
		public Object createValue(ParseTreeNode parseTreeNode,
				IModelCreatingContext context, ValueBinding binding)
				throws ModelCreatingException {
			String textContent = parseTreeNode.getNodeText();
			if (textContent.equals("*")) {
				return -1;
			} else {
				return new Integer(textContent);
			}
		}		
	};
	
	private final IValuePrintSemantics fValuePrintSemantics = new IValuePrintSemantics() {
		public boolean printValue(Object modelValue, ValueBinding binding,
				PrettyPrintState state, PrettyPrinter printer)
				throws ModelCreatingException {
			if (((Integer)modelValue).intValue() == -1) {
				state.append("*");
				return true;
			} else {
				state.append(modelValue.toString());
				return true;
			}
		}		
	};

}
