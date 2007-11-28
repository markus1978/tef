package hub.sam.tef.expressions;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.DefaultSemanitcsProvider;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.IPropertyResolutionSemantics;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.semantics.UnresolvableReferenceError;
import hub.sam.tef.tsl.ReferenceBinding;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

import expressions.ExpressionsPackage;
import expressions.Function;
import expressions.FunctionCall;
import expressions.provider.ExpressionsItemProviderAdapterFactory;

public class ExpressionsEditorDelegate {
	
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { ExpressionsPackage.eINSTANCE };
	}
	
	public String getSyntaxPath() {
		return "models/expressions.etslt";
	}	

	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}

	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new ExpressionsItemProviderAdapterFactory() };
	}

	public ISemanticsProvider createSemanticsProvider() {
		return new DefaultSemanitcsProvider() {
			private FunctionResolutionSemantics fFunctionResolutionSemantics = new FunctionResolutionSemantics();
			private ParameterResolutionSemantics fParameterResolutionSemantics = new ParameterResolutionSemantics();

			@Override
			public IPropertyResolutionSemantics getPropertyResolutionSemantics(
					ReferenceBinding binding) {
				if (binding.getProperty().getName().equals("function")) {
					return fFunctionResolutionSemantics;
				} else if (binding.getProperty().getName().equals("parameter")){
					return fParameterResolutionSemantics;
				} else {
					return super.getPropertyResolutionSemantics(binding);
				}
			}	
			
		};
	}
	
	private static class FunctionResolutionSemantics extends AbstractPropertySemantics implements
			IPropertyResolutionSemantics {
		@SuppressWarnings("unchecked")
		@Override
		public UnresolvableReferenceError resolve(ParseTreeNode parseTreeNode,
				Object actual, Object value, ModelCreatingContext context,
				ReferenceBinding binding) throws ModelCreatingException {			
			List<EObject> resolution = resolveAll("name", parseTreeNode.getNodeText(), 
						ExpressionsPackage.eINSTANCE.getFunction(), 
						(Iterator)context.getAllContents());
			if (resolution.size() == 0) {
				return new UnresolvableReferenceError("There is no function with that name.", parseTreeNode);
			}
			int numberOfArguments = ((FunctionCall)actual).getArguments().size();
			EObject resolutionWithRightNumberOfParameter = null;
			for (EObject function: resolution) {
				if (((Function)function).getParameters().size() == numberOfArguments) {
					if (resolutionWithRightNumberOfParameter == null) {
						resolutionWithRightNumberOfParameter = function;
					} else {
						context.addError(new Error(parseTreeNode.getPosition(),
								"This function call is ambiguous"));
					}
				}
			}
			if (resolutionWithRightNumberOfParameter != null) {
				setValue((EObject)actual, resolutionWithRightNumberOfParameter, 
						binding.getProperty());
				return null;
			} else {
				return new UnresolvableReferenceError(
						"There is no function with that name and that numbers of parameters.", 
						parseTreeNode);
			}
		}		
	}
	
	private static class ParameterResolutionSemantics extends AbstractPropertySemantics implements
	IPropertyResolutionSemantics {
		@SuppressWarnings("unchecked")
		@Override
		public UnresolvableReferenceError resolve(ParseTreeNode parseTreeNode,
				Object actual, Object value, ModelCreatingContext context,
				ReferenceBinding binding) throws ModelCreatingException {			
			List<EObject> resolution = resolveAll("name", parseTreeNode.getNodeText(), 
						ExpressionsPackage.eINSTANCE.getParameter(), 
						(Iterator)context.getAllContents());
			if (resolution.size() == 0) {
				return new UnresolvableReferenceError("There is no parameter with that name.", parseTreeNode);
			}
			EObject function = (EObject)actual;
			while (!(function instanceof Function)) {
				function = function.eContainer();
			}
			
			EObject resolutionForRightFunction = null;
			for (EObject parameter: resolution) {
				if (parameter.eContainer() == function) {
					if (resolutionForRightFunction == null) {
						resolutionForRightFunction = parameter;
					} else {
						context.addError(new Error(parseTreeNode.getPosition(),
								"This parameter access is ambiguous"));
					}
				}
			}
			if (resolutionForRightFunction != null) {
				setValue((EObject)actual, resolutionForRightFunction, 
						binding.getProperty());
				return null;
			} else {
				return new UnresolvableReferenceError(
						"There is no parameter with that name in this function.", 
						parseTreeNode);
			}
		}		
	}
}
