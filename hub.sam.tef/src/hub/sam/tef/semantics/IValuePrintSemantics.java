package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.tsl.ValueBinding;

/**
 * Values can be model-objects (element values) or other values (primitive
 * values). A value print semantics determines how pretty printing handles values 
 * of a specific type.
 */
public interface IValuePrintSemantics {
	/**
	 * This method returns a string used to pretty print the given value. Pretty
	 * printers use this method to create a string for model values. If this
	 * method return null, the pretty printer will use pretty printing to create
	 * the string (used for most model object values). A return is only required
	 * for primitive values, based on according primitive bindings.
	 * 
	 * @param modelValue
	 * @return a string representation for the value or null, if the string
	 *         should be created through normal pretty printing.
	 * @throws ModelCreatingException,
	 *             if anything unexpected happens.
	 */
	public String printValue(Object modelValue, ValueBinding binding)
			throws ModelCreatingException;
}
