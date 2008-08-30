package hub.sam.tef.semantics;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.UnresolvableReferenceError.UnresolveableReferenceErrorException;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.Position;

/**
 * Resolution semantics based on an {@link IIdentificationScheme}. It used the
 * scheme to create global ids from an local identifier and compares it to all
 * the ids of all the objects that have a reasonable meta-type (the type of the
 * reference).
 */
public class IdSchemeElementReferenceResolutionSemantics extends
		AbstractPropertySemantics implements IElementReferenceResolutionSemantics {
	
	private final IIdentificationScheme fIdScheme;	
	
	public IdSchemeElementReferenceResolutionSemantics(IIdentificationScheme idScheme) {
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
			Object value, IModelCreatingContext context, EClassifier targetClassifier) throws ModelCreatingException, 
					UnresolveableReferenceErrorException {
		Object identifyingValue;
		
		if (!(actual instanceof EObject)) {
			throw new ModelCreatingException(
					"Attempt to resolve a non object value: "+actual);
		}
		if (value == null) {
			Position range = parseTreeNode.getPosition();
			int offset = range.getOffset();
			identifyingValue = context.getText().substring(offset, offset + range.getLength());
		} else if (value instanceof EObject) {
			identifyingValue = fIdScheme.getLocalIdentity((EObject)value, (EObject) actual);
		} else {
			throw new ModelCreatingException(
					"Unacceptable object value: " + value.toString());
		}
		
		if (!(identifyingValue instanceof String)) {
			throw new ModelCreatingException(
					"Unacceptable identifying value: " + identifyingValue.toString());
		}
		
		
		EObject resolution = null;
		try {
			resolution = resolve(fIdScheme,
					identifyingValue, (EObject) actual, targetClassifier, context.getAllContents());
		} catch (AmbiguousReferenceException ex) {
			context.addError(new ModelCheckError("Reference is ambiguous", (EObject)actual));				
		}
		if (resolution == null) {
			new UnresolvableReferenceError("Could not resolve " + identifyingValue, parseTreeNode).throwIt();
			return null;
		} else {
			return resolution;				
		}									
	}
}
