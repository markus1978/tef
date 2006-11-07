package editortest.mof.model;

import hub.sam.mof.mofinstancemodel.MofClassSemantics;

import java.util.Arrays;
import java.util.List;

import uk.ac.kent.cs.kmf.xmi.XMIFile.Model;

import cmof.UmlClass;
import cmof.cmofFactory;
import cmof.reflection.Factory;
import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.template.Template;
import editortest.text.visitors.Proposal;

public class MofMetaModelElementImpl implements IMetaModelElement {

	private final UmlClass fClass;

	public MofMetaModelElementImpl(UmlClass theClass) {
		super();
		fClass = theClass;
	}

	public boolean isMetaModelFor(IModelElement e) {
		if (e instanceof MofModelElementImpl) {
			return ((MofModelElementImpl)e).getMofObject().getMetaClass().equals(fClass);
		} else {
			return false;
		}
	}

	protected UmlClass getMofElement() {
		return fClass;
	}
}
