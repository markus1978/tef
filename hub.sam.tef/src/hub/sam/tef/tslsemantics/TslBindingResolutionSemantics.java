/**
 * 
 */
package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.IPropertyCreationSemantics;
import hub.sam.tef.semantics.IPropertyResolutionSemantics;
import hub.sam.tef.semantics.UnresolvableReferenceError;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.ValueBinding;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class TslBindingResolutionSemantics extends
		AbstractPropertySemantics implements IPropertyResolutionSemantics,
		IPropertyCreationSemantics {

	private String metaModelPlatformURI = null;
	private Resource metaModel = null;
	private boolean initialised = false;

	private void initialise() {
		initialised = false;
		URI metaModelURI = URI.createPlatformResourceURI(
				metaModelPlatformURI, false);
		EPackage metaMetaModel = EcorePackage.eINSTANCE;
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(metaMetaModel.getNsURI(),
				metaMetaModel);
		this.metaModel = resourceSet.getResource(metaModelURI, true);
		initialised = true;
	}

	@Override
	public void addValue(ParseTreeNode parseTreeNode, Object actual,
			Object value, ModelCreatingContext context,
			CompositeBinding binding) throws ModelCreatingException {
		if (!(value.equals(this.metaModelPlatformURI))) {
			this.metaModelPlatformURI = (String) value;
			try {
				initialise();
			} catch (Throwable ex) {
				context.addError(new Error(parseTreeNode.getPosition(),
						"Cannot load the meta-model"));
			}
		}
	}
	
	private EClass findCorrespondingElementBinding(PropertyBinding propertyBinding,
			Rule owningRule, Syntax syntax, Collection<Rule> visitedRules) {
		if (visitedRules.contains(owningRule)) {
			return null;
		} else {
			visitedRules.add(owningRule);
		}
		ValueBinding valueBinding = owningRule.getValueBinding();
		if (valueBinding != null) {
			if (valueBinding instanceof ElementBinding) {
				EClass metaClass = ((ElementBinding)valueBinding).getMetaclass();
				if (metaClass == null) {
					// TODO error -> cannot forward reference ...
				}
				return metaClass;
			}
		}
		for (Rule nextOwningRule: syntax.getRulesForUsedNonTerminal(owningRule.getLhs())) {
			EClass metaClass = findCorrespondingElementBinding(propertyBinding, 
					nextOwningRule, syntax, visitedRules);
			if (metaClass != null) {
				return metaClass;
			}
		}
		return null;
	}

	@Override
	public UnresolvableReferenceError resolve(ParseTreeNode parseTreeNode,
			Object actual, Object value, ModelCreatingContext context,
			ReferenceBinding binding) throws ModelCreatingException {
		if (initialised) {			
			String id = parseTreeNode.getNodeText();				
			EObject resolution = null;			
			if (actual instanceof PropertyBinding) {
				EClass correspondingMetaClass = findCorrespondingElementBinding(
						(PropertyBinding)actual, 
						(Rule)((EObject)actual).eContainer().eContainer(), 
						(Syntax)context.getContents().get(0), new HashSet<Rule>());
				if (correspondingMetaClass == null) {
					return new UnresolvableReferenceError( 
							"Cannot resolve the meta-class for the given property",
							parseTreeNode);
				}
				for (EStructuralFeature feature: 
						correspondingMetaClass.getEAllStructuralFeatures()) {
					if (feature.getName().equals(id)) {
						resolution = feature;
					} 
				}
				if (resolution == null) {
					return new UnresolvableReferenceError(
							"Class " + correspondingMetaClass.getName() + 
							" does not contain a structural feature with the given name",
							parseTreeNode);
				}
			} else {							
				try {
					resolution = resolve("name", id, binding.getProperty()
							.getEType(), metaModel.getAllContents());
				} catch (AmbiguousReferenceException ex) {
					context.addError(new Error(parseTreeNode.getPosition(), 
							"Reference is ambiguous"));				
				}				
			}
			if (resolution != null) {
				setValue((EObject) actual, resolution, binding
						.getProperty());
				return null;
			} else {
				return new UnresolvableReferenceError(
						"Could not resolve " + id + ".", parseTreeNode);
			}			
		} else {
			return new UnresolvableReferenceError(
					"No meta-model set.", parseTreeNode);
		}
	}
}