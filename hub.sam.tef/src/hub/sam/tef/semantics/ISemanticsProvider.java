package hub.sam.tef.semantics;

import hub.sam.tef.tsl.Binding;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.ValueBinding;

/**
 * A semantics provider determines the semantics of a textual notation. While
 * its syntax is described separately in TSL, the semantics of the syntactical
 * constructs is defined in Java.
 * <p>
 * All the syntactical expressions means in TSL have a default semantics, but
 * for many (e.g. resolution of reference bindings) you might want to define a
 * custom, language specific, semantics.
 * <p>
 * There are different types of semantics for different meta-syntactical
 * constructs and other editor features:
 * <p>
 * <ul>
 * <li>Creation semantics for properties:
 * {@link this#getValueCreationSemanitcs()}</li>
 * <li>Creation semantics for values:
 * {@link this#getPropertyCreationSemantics(CompositeBinding)}</li>
 * <li>Reference semantics for properties</li>
 * <li>Print semantics for values</li>
 * <li>Model checking semantics for values</li>
 * <li><i>Content assist semantics for references</i></li>
 * <li><i>Semantic highlightings</i></li>
 * <li><i>...</i></li>
 * <li><i></i></li>
 * </ul>
 */
public interface ISemanticsProvider {

	public IValueCreationSemantics getValueCreationSemanitcs(ValueBinding binding);
	
	public IPropertyCreationSemantics getPropertyCreationSemantics(CompositeBinding binding);
	
	public IPropertyResolutionSemantics getPropertyResolutionSemantics(ReferenceBinding binding);
	
	public IValuePrintSemantics getValuePrintSemantics(ValueBinding binding);
	
	public IValueCheckSemantics getValueCheckSemantics(ElementBinding binding);
	
	public IContentAssistSemantics getContentAssistSemantics(Binding binding);
}
