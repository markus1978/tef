package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.UnresolvableReferenceError.UnresolveableReferenceErrorException;
import hub.sam.tef.tsl.ReferenceBinding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.Position;

/**
 * Resolution semantics based on an {@link IIdentificationScheme}. It used the
 * scheme to create global ids from an local identifier and compares it to all
 * the ids of all the objects that have a reasonable meta-type (the type of the
 * reference).
 */
public class IdSchemePropertyResolutionSemantics extends
		AbstractPropertySemantics implements IPropertyResolutionSemantics {
	
	private final IIdentificationScheme fIdScheme;	
	
	public IdSchemePropertyResolutionSemantics(IIdentificationScheme idScheme) {
		super();
		fIdScheme = idScheme;
	}

	/**
	 * Expects an {@link EObject} as actual. If the value is null, it takes the
	 * string represented by the parseTreeNode. If the value is not null, it has
	 * to contain a string. Tries to resolve the given value based on the
	 * property type, all the objects contained in the given context, and the
	 * named of these elements. If the referenced can be resolved, it simply
	 * sets or adds the resolved value to the {@link EStructuralFeature}
	 * represented by the binding, depending on its multiplicity, other wise an
	 * {@link UnresolvableReferenceError} is created and returned.
	 */
	public EObject resolve(ParseTreeNode parseTreeNode, Object actual,
			Object value, IModelCreatingContext context,
			ReferenceBinding binding) throws ModelCreatingException, 
					UnresolveableReferenceErrorException {
		if (!(actual instanceof EObject)) {
			throw new ModelCreatingException(
					"Atempt to set property value to a non object value");
		}
		if (value == null) {
			Position range = parseTreeNode.getPosition();
			int offset = range.getOffset();
			value = context.getText().substring(offset, offset + range.getLength());
		}
		/*
		if (!(value instanceof String)) {
			throw new ModelCreatingException(
					"Unacceptable property value: " + value.toString());
		}
		*/
		
		EObject resolution = null;
		try {
			resolution = resolve(fIdScheme,
					value, (EObject) actual, binding.getProperty()
							.getEType(), context.getAllContents());
		} catch (AmbiguousReferenceException ex) {
			context.addError(new ModelCheckError("Reference is ambiguous", (EObject)actual));				
		}
		if (resolution == null) {
			new UnresolvableReferenceError("Could not resolve " + value, parseTreeNode).throwIt();
			return null;
		} else {
			return resolution;				
		}									
	}
}
