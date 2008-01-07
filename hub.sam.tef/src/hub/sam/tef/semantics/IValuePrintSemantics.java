package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.tsl.ValueBinding;

/**
 * Values can be model-objects (element values) or other values (primitive
 * values). A value print semantics determines how pretty printing handles values 
 * of a specific type.
 */
public interface IValuePrintSemantics {
	
	/**
	 * This method pretty prints the given value. Pretty printers use this
	 * method to append strings for model values to a pretty print state.
	 * 
	 * @param modelValue
	 * @param binding
	 * @param state
	 *            the state that the value should be printed to.
	 * @return false if the value cannot be printed. Pretty printing will try to
	 *         print the value with other rules.
	 * @throws ModelCreatingException,
	 *             if anything unexpected happens.
	 */
	public boolean printValue(Object modelValue, ValueBinding binding, 
			PrettyPrintState state, PrettyPrinter printer)
			throws ModelCreatingException;
}
