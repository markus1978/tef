package editortest.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.jdom.JDOMException;

import cmof.Package;
import cmof.Property;
import cmof.UmlClass;
import cmof.cmofFactory;
import cmof.reflection.Extent;
import hub.sam.mof.Repository;
import hub.sam.mof.instancemodel.MetaModelException;
import hub.sam.mof.xmi.XmiException;

public class MofModel {
	
	private final Extent fExtent;
	private final cmofFactory fFactory;
	
	public MofModel(InputStream input) {
		fExtent = Repository.getLocalRepository().createExtent("textExtent");
		
		cmof.Package cmofPackage = (cmof.Package)Repository.getLocalRepository().
						getExtent(Repository.CMOF_EXTENT_NAME).query("Package:cmof");
		fFactory = (cmofFactory)Repository.getLocalRepository().createFactory(fExtent, cmofPackage);
		try {
			Repository.getLocalRepository().loadXmiIntoExtent(fExtent, cmofPackage, input);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public MofModel() {
		fExtent = Repository.getLocalRepository().createExtent("textExtent");
		
		cmof.Package cmofPackage = (cmof.Package)Repository.getLocalRepository().
						getExtent(Repository.CMOF_EXTENT_NAME).query("Package:cmof");
		fFactory = (cmofFactory)Repository.getLocalRepository().createFactory(fExtent, cmofPackage);
		
		Package aPackage = fFactory.createPackage();
		aPackage.setName("APackage");
		UmlClass aClass = fFactory.createUmlClass();
		aClass.setPackage(aPackage);
		aClass.setName("EineKlasseNamensBernt");
		Property aProperty = fFactory.createProperty();
		aProperty.setName("selfReference");
		aProperty.setType(aClass);
		aClass.getOwnedAttribute().add(aProperty);		
	}	
	
	public Set getElements() {
		return new MofSetImpl(fExtent.outermostComposites());
	}
	
	public cmofFactory getFactory() {
		return fFactory;
	}
	
	public Extent getExtent() {
		return fExtent;
	}
	
	public UmlClass getMetaClass(String name) {
		UmlClass result = (UmlClass)Repository.getLocalRepository().getExtent(Repository.CMOF_EXTENT_NAME).
				query("Package:cmof/Class:" + name);
		if (result == null) {
			throw new RuntimeException("assert");
		}
		return result;
	}
}
