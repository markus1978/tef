package hub.sam.tef.expressions.util;

import hub.sam.mof.Repository;
import hub.sam.mof.emf.EcoreGenerator;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cmof.Package;
import cmof.reflection.Extent;

public class GenerateEcoreModel {
	public static void main(String[] args) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File("models/expressions.ecore")
				.getAbsolutePath());

		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);		
		EcoreGenerator generator = new EcoreGenerator(resource);
		
		Extent extent = Repository.getLocalRepository().createExtent("myExtent");
		Repository.getLocalRepository().loadMagicDrawXmiIntoExtent(extent, (Package)Repository.getLocalRepository().getExtent(Repository.CMOF_EXTENT_NAME).query("Package:cmof"),
				"models/expressions.mdxml");
		
		List<Package> mofPackages = new Vector<Package>();
		mofPackages.add((Package)extent.query("Package:expressions"));				
		generator.generateEcorModel(mofPackages);

		// Save the contents of the resource to the file system.
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
		}
	}
}
