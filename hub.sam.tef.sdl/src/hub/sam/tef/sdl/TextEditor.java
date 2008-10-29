package hub.sam.tef.sdl;

import java.util.ArrayList;
import java.util.List;

import hub.sam.sdl.ConcreteSyntaxSdlIdentifier;
import hub.sam.sdl.ConcreteSyntaxSdlPathItem;
import hub.sam.sdl.ConcreteSyntaxSdlQualifier;
import hub.sam.sdl.ConcreteSyntaxSdlScopeUnitKind;
import hub.sam.sdl.CoreAbstractionsNamespacesNamedElement;
import hub.sam.sdl.EmfSdlFactory;
import hub.sam.sdl.EmfSdlPackage;
import hub.sam.sdl.SdlAgentKind;
import hub.sam.sdl.SdlAgentType;
import hub.sam.sdl.SdlPackage;
import hub.sam.sdl.provider.EmfSdlItemProviderAdapterFactory;
import hub.sam.tef.semantics.IIdentificationScheme;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

public class TextEditor extends hub.sam.tef.editor.text.TextEditor {

	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { EmfSdlPackage.eINSTANCE };
	}

	@Override
	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected String getSyntaxPath() {
		return "/resources/sdl.etslt";
	}

	@Override
	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new EmfSdlItemProviderAdapterFactory() };
	}

	@Override
	protected IIdentificationScheme createIdentificationScheme() {
		return new SDLIdentificationScheme();
	}

	private static class SDLIdentificationScheme implements IIdentificationScheme {
		
		private ConcreteSyntaxSdlIdentifier[] createIdentifiers(String name, EObject context) {
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
			return result.toArray(new ConcreteSyntaxSdlIdentifier[] {});
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
		public Object[] getGlobalIdentities(Object identifier, EObject context) {
			if (identifier instanceof String) {				
				return createIdentifiers((String)identifier, context);
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
				return null;				
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
}