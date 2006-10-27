package editortest.model;

import hub.sam.mof.mofinstancemodel.MofClassSemantics;

import java.util.Arrays;
import java.util.List;

import uk.ac.kent.cs.kmf.xmi.XMIFile.Model;

import cmof.UmlClass;
import cmof.cmofFactory;
import cmof.reflection.Factory;
import editortest.template.Template;
import editortest.widgets.Proposal;

public class MofMetaModelElementImpl implements IMetaModelElement {

	private final UmlClass fClass;
	private final Factory fFactory;
	private final MofModel fModel;

	public MofMetaModelElementImpl(UmlClass class1, Factory factory, MofModel model) {
		super();
		fClass = class1;
		fFactory = factory;
		fModel = model;
	}

	public IModelElement createElement() {
		return new MofModelElementImpl(fFactory.create(fClass));
	}

	public void deleteElement(IModelElement element) {
		// TODO Auto-generated method stub		
	}

	public String[] getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Proposal> getProposals(IModelElement element, String property) {
		// TODO Auto-generated method stub
		return null;
	}

	public IMetaModelElement getType(String typeName) {
		return new MofMetaModelElementImpl(fModel.getMetaClass(typeName),
				fFactory, fModel);
	}

	public boolean isMetaModelFor(IModelElement e) {
		if (e instanceof MofModelElementImpl) {
			return ((MofModelElementImpl)e).getMofObject().getMetaClass().equals(fClass);
		} else {
			return false;
		}
	}

	public Iterable<IModelElement> getInstances() {
		return new MofSetImpl(fModel.getExtent().objectsOfType(fClass, true));		
	}		
}
