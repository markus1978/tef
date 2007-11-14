package hub.sam.tef;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.modelcreating.Parser;
import hub.sam.tef.modelcreating.ParserSemantics;
import hub.sam.tef.modelcreating.ResolutionState;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.SyntaxUsageException;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tslsemantics.TslSemanticsProvider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class Utilities {
	
	private static Syntax fTslSyntax = null;
	
	public static Syntax getTslSyntax() {
		//if (fTslSyntax == null) {
			fTslSyntax = createTslSytax();
		//}
		return fTslSyntax;
	}

	private static Syntax createTslSytax() {		
		return loadSyntaxDescription("/hub.sam.tef/resources/models/tsl.tsl",
				new EPackage[] {TslPackage.eINSTANCE, EcorePackage.eINSTANCE});			
	}
	
	private static EClass getClass(EClass eClass, EPackage[] metaModelPackages) {			
		if (eClass == null) {
			throw new SyntaxUsageException("Assert: Class may not be null.");
		}
		for (EPackage metaModelPackage: metaModelPackages) {
			EClass result = (EClass)metaModelPackage.getEClassifier(eClass.getName());
			if (result != null) {
				return result;	
			}			
		}
		throw new SyntaxUsageException("Unknown meta-class " + eClass.getName());
	}
	
	private static void replaceClassesWithoutMetaId(Iterator<EObject> it,
			EPackage[] metaModelPackages) {
		while(it.hasNext()) {
			EObject next = it.next();
			if (next instanceof ElementBinding) {
				ElementBinding elementBinding = (ElementBinding)next;
				EClass eClass = elementBinding.getMetaclass();
				if (eClass == null) {
					throw new SyntaxUsageException("Element binding without class.");
				}								
				elementBinding.setMetaclass(getClass(eClass, metaModelPackages));							
			} else if (next instanceof PropertyBinding) {
				PropertyBinding propertyBinding = (PropertyBinding)next;
				EStructuralFeature feature = propertyBinding.getProperty();
				if (feature == null) {
					throw new SyntaxUsageException("Property binding without property.");
				}
				EClass eClass = getClass(feature.getEContainingClass(), metaModelPackages);		
				propertyBinding.setProperty(eClass.getEStructuralFeature(feature.getName()));
			}
		}
	}
	
	private static Syntax loadSyntaxDescriptionFromTSLFile(String platformURI,
			EPackage[] metaModelPackages) {
		ResourceSet resourceSet = new ResourceSetImpl();
		
		URI exampleModelFile = URI.createPlatformResourceURI(
				platformURI, false);			
		EPackage tslMetaModel = TslPackage.eINSTANCE;	
		resourceSet.getPackageRegistry().put(tslMetaModel.getNsURI(), tslMetaModel);		
		Resource resource = resourceSet.getResource(exampleModelFile, true);
		
		// replace referenced "fake" classes and structural features with the
		// real elements
		replaceClassesWithoutMetaId(resource.getAllContents(), metaModelPackages);		
		for (EObject content: resource.getContents()) {
			if (content instanceof Syntax) {
				return (Syntax)content;
			}
		}	
		throw new RuntimeException("Unexpected content in TSL model file."); // TODO
	}
	
	private static Syntax loadSyntaxDescriptionFromTSLTFile(String platformURI,
			EPackage[] metaModelPackages) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = root.getFile(new Path(platformURI));
		
		String tslContent = null;
		
		try {
		    InputStream is = file.getContents();		
		    BufferedReader in = new BufferedReader(new InputStreamReader(is));
			StringBuffer buffer = new StringBuffer();
			String line = null;
			while ((line = in.readLine()) != null) {
			   buffer.append(line);
			}		
			tslContent = buffer.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		try {						
			Syntax syntax = Utilities.parseTsl(tslContent,
					new EPackage[] {TslPackage.eINSTANCE, EcorePackage.eINSTANCE} );
			replaceClassesWithoutMetaId(syntax.eAllContents(), metaModelPackages);
			return syntax;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Could not load TSL."); // TODO
		}
	}
	
	/**
	 * Loads the TSL at the given URI. The URI determines whether the indicated
	 * resource is interpreted as a .tsl or .tslt file.
	 * 
	 * @param platformURI
	 *            the URI indicating the resource containing a TSL description.
	 * @param metaModelPackages
	 *            the packages containing the meta-model that is referenced in
	 *            the TSL description.
	 * 
	 * @return the loaded syntax.
	 */
	public static Syntax loadSyntaxDescription(String platformURI,
			EPackage[] metaModelPackages) {
		
		Syntax result = null;
		if (platformURI.endsWith(".tsl")) {
			result =  loadSyntaxDescriptionFromTSLFile(platformURI, metaModelPackages);
		} else if (platformURI.endsWith(".tslt")) {
			result =  loadSyntaxDescriptionFromTSLTFile(platformURI, metaModelPackages);
		} else {
			throw new RuntimeException("No tsl file."); // TODO
		}
		
		// extend the syntax with implicit rules for primitive types		
		if (result != null) {
			for(PrimitiveTypeDescriptor primitiveTypeDescr: 
					PrimitiveTypeDescriptor.getRegisteredTypeDescriptors()) {
				primitiveTypeDescr.addRulesToATslSyntax(result);
			}
			
			// TODO checks for the TSL models, checks are currently only done during
			// model creation in the TSL text editor.
			return result;
		} else {
			throw new SyntaxUsageException("assert");
		}
	}
	
	public static Syntax parseTsl(String tslContent, EPackage[] packages) 
			throws ModelCreatingException {
		
		Parser parser = new Parser(getTslSyntax());
		ParserSemantics semantics = new ParserSemantics(getTslSyntax());
		boolean parseOk = false;
		try {
			parseOk = parser.parse(tslContent, semantics);
		} catch (ModelCreatingException e) {
			throw new SyntaxUsageException(e);
		}
		
		if (parseOk) {
			ParseTreeNode parseResult = semantics.getResult();
			EObject creationResult = null;
			try {				
				ModelCreatingContext modelCreationContext = new ModelCreatingContext(						
						new ResourceImpl(),
						packages, 
						new TslSemanticsProvider(),
						tslContent);				
				creationResult = (EObject)
						parseResult.createModel(modelCreationContext, null);
				modelCreationContext.addToResource(creationResult);
				
				ResolutionState state = new ResolutionState(creationResult);
				modelCreationContext.addToResource(EcorePackage.eINSTANCE);
				parseResult.resolveModel(modelCreationContext, state);
			} catch (ModelCreatingException e) {
				throw e;
			}
						
			if (creationResult instanceof Syntax) {
				return (Syntax)creationResult;
			} else {
				throw new ModelCreatingException("Unexpected content in tsl text");
			}
		} else {
			throw new ModelCreatingException("could not parse the tsl text");
		}
	}
}
