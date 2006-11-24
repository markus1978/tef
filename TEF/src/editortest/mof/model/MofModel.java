package editortest.mof.model;

import hub.sam.mof.Repository;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.ICommandFactory;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;

import java.io.InputStream;

import cmof.Package;
import cmof.Property;
import cmof.UmlClass;
import cmof.cmofFactory;
import cmof.reflection.Extent;

public class MofModel implements IModel {
	
	public ICommandFactory getCommandFactory() {
		// TODO 
		return null;
	}

	private final Extent fExtent;
	private final cmofFactory fFactory;
	private final Package cmofPackage;
	
	public MofModel(InputStream input) {
		fExtent = Repository.getLocalRepository().createExtent("textExtent");
		
		cmofPackage = (Package)Repository.getLocalRepository().
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
		
		cmofPackage = (cmof.Package)Repository.getLocalRepository().
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
	
	public ICollection getOutermostComposites() {
		return new MofSetImpl(fExtent.outermostComposites());
	}
	
	private cmofFactory getFactory() {
		return fFactory;
	}
	
	public Extent getExtent() {
		return fExtent;
	}
	
	public Package getMetaModel() {
		return cmofPackage;
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
