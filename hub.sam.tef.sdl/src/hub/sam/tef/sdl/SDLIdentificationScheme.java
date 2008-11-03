package hub.sam.tef.sdl;

import hub.sam.sdl.ConcreteSyntaxSdlIdentifier;
import hub.sam.sdl.ConcreteSyntaxSdlPathItem;
import hub.sam.sdl.ConcreteSyntaxSdlQualifier;
import hub.sam.sdl.ConcreteSyntaxSdlScopeUnitKind;
import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAgentKind;
import hub.sam.sdl.SdlAgentType;
import hub.sam.sdl.SdlDataType;
import hub.sam.sdl.SdlPackage;
import hub.sam.tef.semantics.IIdentificationScheme;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

public class SDLIdentificationScheme implements IIdentificationScheme {
			
	private List<ConcreteSyntaxSdlIdentifier> createIdentifiers(String name, EObject context) {
		ConcreteSyntaxSdlIdentifier longest = createIdentifier(name, context);
		List<ConcreteSyntaxSdlIdentifier> result = new ArrayList<ConcreteSyntaxSdlIdentifier>();
		result.add(longest);
		for(int i = longest.getQualifier().getPathItem().size() - 1; i > 0; i--) {
			ConcreteSyntaxSdlIdentifier shorter = EmfSdlFactory.eINSTANCE.createConcreteSyntaxSdlIdentifier();
			shorter.setName(name);
			ConcreteSyntaxSdlQualifier qualifier = EmfSdlFactory.eINSTANCE.createConcreteSyntaxSdlQualifier();
			shorter.setQualifier(qualifier);
			for(int ii=0; ii < i; ii++) {
				ConcreteSyntaxSdlPathItem pathItem = EmfSdlFactory.eINSTANCE.createConcreteSyntaxSdlPathItem();
				pathItem.setName(longest.getQualifier().getPathItem().get(ii).getName());
				pathItem.setKind(longest.getQualifier().getPathItem().get(ii).getKind());
				qualifier.getPathItem().add(pathItem);
			}
			result.add(shorter);
		}
		return result;
	}
	
	private ConcreteSyntaxSdlIdentifier createIdentifier(String name, EObject context) {
		ConcreteSyntaxSdlIdentifier fullIdentifier = EmfSdlFactory.eINSTANCE.createConcreteSyntaxSdlIdentifier();
		fullIdentifier.setName(name);
		fullIdentifier.setQualifier(createQualifier(context));
		return fullIdentifier;
	}
	
	private ConcreteSyntaxSdlQualifier createQualifier(EObject context) {
		ConcreteSyntaxSdlQualifier result = EmfSdlFactory.eINSTANCE.createConcreteSyntaxSdlQualifier();
		loop: while (context != null) {
			ConcreteSyntaxSdlScopeUnitKind kind = null;
			if (context instanceof SdlPackage) {
				kind = ConcreteSyntaxSdlScopeUnitKind.PACKAGE;
			} else if (context instanceof SdlAgentType) {
				if (((SdlAgentType) context).getKind() == SdlAgentKind.SYSTEM) {
					kind = ConcreteSyntaxSdlScopeUnitKind.SYSTEM_TYPE;
				} else if (((SdlAgentType) context).getKind() == SdlAgentKind.BLOCK) {
					kind = ConcreteSyntaxSdlScopeUnitKind.BLOCK_TYPE;
				} else if (((SdlAgentType) context).getKind() == SdlAgentKind.PROCESS) {
					kind = ConcreteSyntaxSdlScopeUnitKind.PROCESS_TYPE;
				} else {
					Assert.isTrue(false, "unreachable");
				}
			} else if (context instanceof SdlDataType) {
				
			} else {
				context = context.eContainer();
				continue loop;
			}
			ConcreteSyntaxSdlPathItem pathItem = EmfSdlFactory.eINSTANCE.createConcreteSyntaxSdlPathItem();
			pathItem.setName(getSimpleIdentity(context));
			pathItem.setKind(kind);
			result.getPathItem().add(0, pathItem);
			context = context.eContainer();
		}
		return result;
	}

	/*
	 * bug: identifier is a string no matter it is a FullIdentifier or IDENTIFIER
	 */
	public Object[] getGlobalIdentities(Object identifier, EObject context,
			EClassifier type) {
		if (identifier instanceof String) {
			List<ConcreteSyntaxSdlIdentifier> allIdentifiers = createIdentifiers((String)identifier, context); 
			if (!(type instanceof EClass)) {
				return allIdentifiers.toArray();
			}
			if (type.equals(EmfSdlPackage.eINSTANCE.getSdlGate())) {	
				// you also see all gates of agent types contained in the
				// context agent type
				while(context != null && !(context instanceof SdlAgentType)) {
					context = context.eContainer();
				}
				if (context != null) {
					for(SdlAgentType agentTypeInContext: 
							((SdlAgentType)context).getOwnedAgentType()) {
						allIdentifiers.addAll(createIdentifiers((String)identifier, agentTypeInContext));
					}
				}
			} 	
			if (EmfSdlPackage.eINSTANCE.getSdlOperation().isSuperTypeOf((EClass)type)) {
				// you also see all operators in contained data types
				while(context != null && !(context instanceof SdlAgentType)) {
					context = context.eContainer();
				}
				if (context != null) {
					for(Object dataTypeInAgent: 
							((SdlAgentType)context).getOwnedType()) {
						if (dataTypeInAgent instanceof SdlDataType) {
							allIdentifiers.addAll(createIdentifiers((String)identifier, 
									(SdlDataType)dataTypeInAgent));
						}
					}
				}
			}
			if (EmfSdlPackage.eINSTANCE.getEvaluationLiteral().isSuperTypeOf((EClass)type)) {
				// you also see all literals in contained data types
				while(context != null && !(context instanceof SdlAgentType)) {
					context = context.eContainer();
				}
				if (context != null) {
					for(Object dataTypeInAgent: 
							((SdlAgentType)context).getOwnedType()) {
						if (dataTypeInAgent instanceof SdlDataType) {
							allIdentifiers.addAll(createIdentifiers((String)identifier, 
									(SdlDataType)dataTypeInAgent));
						}
					}
				}
			}
			return allIdentifiers.toArray();
		} else if (identifier instanceof ConcreteSyntaxSdlIdentifier) {
			return new Object[] { identifier };
		} else {
			return new Object[] { identifier };	// TODO, throw error?
		}			
	}

	public Object getIdentitiy(EObject object) {
		if (EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamedElement().
				isSuperTypeOf(object.eClass())) {
			String name = ((CoreAbstractionsNamespacesNamedElement)object).getName();
			return createIdentifier(name, object.eContainer());
		} else {				
			return "--NONAME--";				
		}
	}
	
	private String getSimpleIdentity(EObject object) {
		if (EmfSdlPackage.eINSTANCE.getCoreAbstractionsNamespacesNamedElement().
				isSuperTypeOf(object.eClass())) {
			return ((CoreAbstractionsNamespacesNamedElement)object).getName();
		} else {
			return null;				
		}
	}

	public String getLocalIdentity(EObject object, EObject context) {			
		return getSimpleIdentity(object);
	}
	
}