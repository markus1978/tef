package hub.sam.tef.expressions;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.DefaultIdentificationScheme;
import hub.sam.tef.semantics.DefaultSemanticsProvider;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.IPropertyResolutionSemantics;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.semantics.UnresolvableReferenceError;
import hub.sam.tef.semantics.UnresolvableReferenceError.UnresolveableReferenceErrorException;
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
	
	public static ISemanticsProvider createExpressionsSemanticsProvider() {
		return new DefaultSemanticsProvider(DefaultIdentificationScheme.INSTANCE) {
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

	public ISemanticsProvider createSemanticsProvider() {
		return createExpressionsSemanticsProvider();
	}
	
	private static class FunctionResolutionSemantics extends AbstractPropertySemantics implements
			IPropertyResolutionSemantics {
		@SuppressWarnings("unchecked")
		public EObject resolve(ParseTreeNode parseTreeNode,
				Object actual, Object value, IModelCreatingContext context,
				ReferenceBinding binding) throws ModelCreatingException, UnresolveableReferenceErrorException {			
			List<EObject> resolution = resolveAll(
					DefaultIdentificationScheme.INSTANCE, parseTreeNode
							.getNodeText(), null, ExpressionsPackage.eINSTANCE
							.getFunction(), (Iterator) context.getResource()
							.getAllContents());
			if (resolution.size() == 0) {
				new UnresolvableReferenceError("There is no function with that name.", parseTreeNode).throwIt();
				return null;
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
				return resolutionWithRightNumberOfParameter;				
			} else {
				new UnresolvableReferenceError(
						"There is no function with that name and that numbers of parameters.", 
						parseTreeNode).throwIt();
				return null;
			}
		}		
	}
	
	private static class ParameterResolutionSemantics extends AbstractPropertySemantics implements
	IPropertyResolutionSemantics {
		@SuppressWarnings("unchecked")
		public EObject resolve(ParseTreeNode parseTreeNode,
				Object actual, Object value, IModelCreatingContext context,
				ReferenceBinding binding) throws ModelCreatingException, UnresolveableReferenceErrorException {			
			List<EObject> resolution = resolveAll(
					DefaultIdentificationScheme.INSTANCE, parseTreeNode
							.getNodeText(), null, ExpressionsPackage.eINSTANCE
							.getParameter(), (Iterator) context.getResource()
							.getAllContents());
			if (resolution.size() == 0) {
				new UnresolvableReferenceError("There is no parameter with that name.", parseTreeNode).throwIt();
				return null;
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
				return resolutionForRightFunction;
			} else {
				new UnresolvableReferenceError(
						"There is no parameter with that name in this function.", 
						parseTreeNode).throwIt();
				return null;
			}
		}		
	}
}
