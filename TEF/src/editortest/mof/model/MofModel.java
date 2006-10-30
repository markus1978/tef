package editortest.mof.model;

import hub.sam.mof.Repository;

import java.io.InputStream;

import cmof.Package;
import cmof.Property;
import cmof.UmlClass;
import cmof.cmofFactory;
import cmof.reflection.Extent;
import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.model.Set;

public class MofModel implements IModel {
	
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
	
	public Set getOutermostComposites() {
		return new MofSetImpl(fExtent.outermostComposites());
	}
	
	private cmofFactory getFactory() {
		return fFactory;
	}
	
	private Extent getExtent() {
		return fExtent;
	}
	
	public IMetaModelElement getMetaElement(String name) {
		UmlClass result = (UmlClass)Repository.getLocalRepository().getExtent(Repository.CMOF_EXTENT_NAME).
				query("Package:cmof/Class:" + name);
		if (result == null) {
			throw new RuntimeException("assert");
		}
		return new MofMetaModelElementImpl(result);
	}

	public IModelElement createElement(IMetaModelElement metaElement) {
		return new MofModelElementImpl(getFactory().create(
				((MofMetaModelElementImpl)metaElement).getMofElement()));
	}

	public Iterable<IModelElement> getElements(IMetaModelElement metaElement) {
		return new MofSetImpl(getExtent().objectsOfType(
				((MofMetaModelElementImpl)metaElement).getMofElement(), 
				true));
	}		
}
