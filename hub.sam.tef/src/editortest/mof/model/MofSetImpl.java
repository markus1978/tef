/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006 Markus Scheidgen
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
package editortest.mof.model;

import hub.sam.tef.models.ICollection;

import java.util.Iterator;

import cmof.common.ReflectiveCollection;

public class MofSetImpl<E> extends Mof implements ICollection<E> {

	private final ReflectiveCollection<E> fCollection;
	
	public MofSetImpl(final ReflectiveCollection<? extends E> collection) {
		super();
		fCollection = (ReflectiveCollection<E>)collection;
	}

	protected ReflectiveCollection<E> getCollection() {
		return fCollection;
	}
	
	public void add(E element) {
		fCollection.add(mofObjectFromObject(element));
	}
	
	class MyIterator implements Iterator {
		private final Iterator fBase;

		public MyIterator(final Iterator base) {
			super();
			fBase = base;
		}
		public boolean hasNext() {
			return fBase.hasNext();
		}
		public Object next() {
			Object result = fBase.next();
			return objectFromMofObject(result);
		}
		public void remove() {			
		}				
	}	

	public boolean contains(E object) {
		return fCollection.contains(mofObjectFromObject(object));
	}

	public Iterator<E> iterator() {
		return new MyIterator(fCollection.iterator());
	}

	public int size() {
		return fCollection.size();
	}	
	
	public boolean remove(E element) {
		return fCollection.remove(mofObjectFromObject(element));
	}

	
	public void replace(E oldElement, E newElement) {
		remove(oldElement);
		add(newElement);
	}
	 
}
