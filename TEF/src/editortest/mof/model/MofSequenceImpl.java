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

import hub.sam.tef.models.ISequence;
import cmof.common.ReflectiveCollection;
import cmof.common.ReflectiveSequence;

public class MofSequenceImpl<E> extends MofSetImpl<E> implements ISequence<E> {	
	
	public MofSequenceImpl(ReflectiveCollection<? extends E> collection) {
		super(collection); 
	}
	
	protected ReflectiveSequence<E> getSequence() {
		return (ReflectiveSequence<E>)getCollection();
	}

	public void insert(int index, E value) {
		getSequence().add(index, mofObjectFromObject(value));
	}		
}
