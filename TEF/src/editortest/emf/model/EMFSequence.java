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

	public void insert(int index, Object value) {
		fList.add(index, EMFModel.getEMFObjectForModel(value));
	}

	public void add(Object element) {
		fList.add(EMFModel.getEMFObjectForModel(element));
	}

	public boolean remove(Object element) {
		return fList.remove(EMFModel.getEMFObjectForModel(element));
	}

	public void replace(Object oldElement, Object newElement) {
		int index = fList.indexOf(EMFModel.getEMFObjectForModel(oldElement));
		if (index < 0) {
			// TODO
		}
		fList.set(index, EMFModel.getEMFObjectForModel(newElement));
	}

	public int size() {
		return fList.size();
	}

	protected EList getEMFObject() {
		return fList;
	}
}
