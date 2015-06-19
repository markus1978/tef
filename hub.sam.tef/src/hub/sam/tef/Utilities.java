/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
 *                         Dirk Fahland
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */

package hub.sam.tef;

import hub.sam.tef.etsl.EtslPackage;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelChecker;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.modelcreating.Parser;
import hub.sam.tef.modelcreating.ParserSemantics;
import hub.sam.tef.modelcreating.ResolutionState;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.semantics.AbstractError;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.tsl.TslPackage;
import hub.sam.tef.tslsemantics.TslModelCreatingContext;
import hub.sam.tef.tslsemantics.TslSemanticsProvider;
import hub.sam.tef.util.ModelObjectPropertiesValueIterator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.framework.Bundle;

public class Utilities {
	
	private static Syntax fTslSyntax = null;
	private static Syntax fEtslSyntax = null;
	
	public static Syntax getTslSyntax() {
		if (fTslSyntax == null) {
			try {				
				fTslSyntax = loadSyntaxDescription(
						TEFPlugin.getDefault().getBundle(),
						"resources/models/tsl.tsl",
						new EPackage[] {TslPackage.eINSTANCE, EcorePackage.eINSTANCE});		
			} catch (TslException e) {
				Assert.isTrue(false, "Error load the syntax of TSL.");
			}
		}
		return fTslSyntax;
	}
	
	public static Syntax getEtslSyntax() {
		if (fEtslSyntax == null) {
			try {
				fEtslSyntax = loadSyntaxDescription(
						TEFPlugin.getDefault().getBundle(),
						"resources/models/etsl.tslt", 
						new EPackage[] { EtslPackage.eINSTANCE, 
						TslPackage.eINSTANCE, EcorePackage.eINSTANCE});
			} catch (TslException e) {
				Assert.isTrue(false, "Error load the syntax of ETSL. "+e);
			}
		}
		return fEtslSyntax;
	}
	
	private static EClass getClass(EClass eClass, EPackage[] metaModelPackages) throws TslException {			
		if (eClass == null) {
			throw new TslException("Element binding without or unresolveable meta-class.");
		}
		for (EPackage metaModelPackage: metaModelPackages) {
			// TODO the name might be inadequate to identify a class.
			EClass result = (EClass)metaModelPackage.getEClassifier(eClass.getName());
			if (result != null) {
				return result;	
			}			
		}
		throw new TslException("Unknown meta-class " + eClass.getName() + ".");
	}
	
	private static void replaceClassesWithoutMetaId(Iterator<EObject> it,
			EPackage[] metaModelPackages) throws TslException {
		while(it.hasNext()) {
			EObject next = it.next();
			if (next instanceof ElementBinding) {
				ElementBinding elementBinding = (ElementBinding)next;
				EClass eClass = elementBinding.getMetaclass();
				if (eClass == null) {
					throw new TslException("Element binding without class.");
				}								
				elementBinding.setMetaclass(getClass(eClass, metaModelPackages));							
			} else if (next instanceof PropertyBinding) {
				PropertyBinding propertyBinding = (PropertyBinding)next;
				EStructuralFeature feature = propertyBinding.getProperty();
				if (feature == null) {
					throw new TslException("Property binding without property.");
				}
				EClass eClass = getClass(feature.getEContainingClass(), metaModelPackages);		
				propertyBinding.setProperty(eClass.getEStructuralFeature(feature.getName()));
			}
		}
	}
	
	private static Syntax loadSyntaxDescriptionFromTSLFile(URL url,
			EPackage[] metaModelPackages) throws TslException {
		ResourceSet resourceSet = new ResourceSetImpl();
				
		URI exampleModelFile = URI.createURI(url.toExternalForm());		
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
		throw new TslException("Unexpected content in TSL model file.");
	}
	
	private static Syntax loadSyntaxDescriptionFromTSLTURL(
			URL url,
			EPackage[] metaModelPackages, 
			Syntax tslSyntax,
			Bundle bundle) throws TslException {						
		String tslContent = null;
		
		try {
		    InputStream is = url.openStream();		
		    BufferedReader in = new BufferedReader(new InputStreamReader(is));
			StringBuffer buffer = new StringBuffer();
			String line = null;
			while ((line = in.readLine()) != null) {
			   buffer.append(line);
			   buffer.append("\n");
			}		
			tslContent = buffer.toString();
		} catch (Exception e) {
			throw new TslException("Cannot read TSL file: " + e.getLocalizedMessage() + ".");
		}
		
		try {						
			Syntax syntax = Utilities.parseTsl(tslContent, 
					new EPackage[] { TslPackage.eINSTANCE, EcorePackage.eINSTANCE, 
									 EtslPackage.eINSTANCE}, 
					tslSyntax, 
					bundle );
			replaceClassesWithoutMetaId(syntax.eAllContents(), metaModelPackages);
			return syntax;
		} catch (Exception e) {
			throw new TslException("Could not understand TSL: " + e.getLocalizedMessage() + ".", e);
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
	public static Syntax loadSyntaxDescription(Bundle bundle, String pluginRelativePath,
			EPackage[] metaModelPackages) throws TslException {
		
		URL url = FileLocator.find(bundle, new Path(pluginRelativePath), null);
		
		Syntax result = null;
		if (pluginRelativePath.endsWith(".tsl")) {
			result =  loadSyntaxDescriptionFromTSLFile(url, metaModelPackages);
		} else if (pluginRelativePath.endsWith(".tslt")) {
			result =  loadSyntaxDescriptionFromTSLTURL(url, metaModelPackages,
					getTslSyntax(), bundle);
		} else if (pluginRelativePath.endsWith(".etslt")) {
			result =  loadSyntaxDescriptionFromTSLTURL(url, metaModelPackages,
					getEtslSyntax(), bundle);
		} else {
			throw new TslException("Given TSL file is not a TSL file.");
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
			throw new TslException("Given TSL does not contain a syntax.");
		}
	}
	
	private static Syntax parseTsl(String tslContent, 
			EPackage[] packages, 
			Syntax tslSyntax,
			Bundle bundle) 
			throws TslException {
		
		Parser parser = new Parser(tslSyntax);
		ParserSemantics semantics = new ParserSemantics(tslSyntax);
		boolean parseOk = false;
		try {
			parseOk = parser.parse(tslContent, semantics);
		} catch (ModelCreatingException e) {
			throw new TslException("Error understanding syntax: " + e.getLocalizedMessage() + ".");
		}
		
		if (parseOk) {
			ParseTreeNode parseResult = semantics.getResult();
			EObject creationResult = null;
			try {				
				IModelCreatingContext modelCreationContext = new TslModelCreatingContext(						
						packages, new TslSemanticsProvider(), new ResourceImpl(), tslContent, bundle);
				
				creationResult = (EObject)
						parseResult.createModel(modelCreationContext, null);
				modelCreationContext.addCreatedObject(creationResult);				
				ResolutionState state = new ResolutionState(creationResult, new ModelObjectPropertiesValueIterator(null));		
				
				parseResult.resolveModel(modelCreationContext, state);
				modelCreationContext.executeResolutions();
				new ModelChecker().checkModel(creationResult, modelCreationContext);
				
				Collection<AbstractError> errors = modelCreationContext.getErrors();
				if (errors.size() > 0) {
					for (AbstractError error: errors) {
						System.out.println(error.getMessage());
					}
					throw new TslException("TSL contains errors.");
				}
			} catch (ModelCreatingException e) {
				throw new TslException(e);
			}						
						
			if (creationResult instanceof Syntax) {
				return (Syntax)creationResult;
			} else {
				throw new TslException("Unexpected content in tsl text");
			}
		} else {
			throw new TslException("could not parse the tsl text");
		}
	}

	/**
	 * This utility function loads a package based on it NS_URI. Only packages
	 * registered with the platform can be loaded.
	 * 
	 * @param package_eNS_URI
	 *            is the URI.
	 * @return the package that the URI referred to.
	 */
	public static EObject loadPackage(String package_eNS_URI) {		        				
		ResourceSet resourceSet = new ResourceSetImpl();
	    resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());        
	    Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
	    List<URI> uris = new ArrayList<URI>();
	    
		URI location = ePackageNsURItoGenModelLocationMap.get(package_eNS_URI);
	    Resource theResource = resourceSet.getResource(location, true);
	    EcoreUtil.resolveAll(theResource);
	    
	    for (Resource resource : resourceSet.getResources())
	    {
	      for (TreeIterator<?> j = 
	             new EcoreUtil.ContentTreeIterator<Object>(resource.getContents())
	             {
	               private static final long serialVersionUID = 1L;
	
	               @Override
	               protected Iterator<? extends EObject> getEObjectChildren(EObject eObject)
	               {
	                 return 
	                   eObject instanceof EPackage ? 
	                     ((EPackage)eObject).getESubpackages().iterator() : 
	                       Collections.<EObject>emptyList().iterator();
	               }
	             };
	           j.hasNext(); )
	      {
	        Object content = j.next();
	        if (content instanceof EPackage)
	        {
	          EPackage ePackage = (EPackage)content;
	          if (package_eNS_URI.equals(ePackage.getNsURI()))
	          {
	            uris.add(resource.getURI());                
	           break;
	          }
	        }
	      }
	    }        
	                  
	    return resourceSet.getResource(uris.get(0), true).getContents().get(0);        
	}
}
