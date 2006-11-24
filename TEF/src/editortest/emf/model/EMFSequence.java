package editortest.emf.model;

import hub.sam.tef.models.ISequence;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;


public class EMFSequence implements ISequence {

	private final EList fList;
	
	public EMFSequence(final EList list) {
		super();
		fList = list;
	}

	public Iterator iterator() {
		return new Iterator() {
			final Iterator fBase = fList.iterator();
			public boolean hasNext() {
				return fBase.hasNext();
			}
			public Object next() {
				return EMFModel.getModelForEMFObject(fBase.next());
			}
			public void remove() {
				// emtpy
			}			
		};
	}

	public int size() {
		return fList.size();
	}

	public EList getEMFObject() {
		return fList;
	}
}
