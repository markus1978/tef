/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
 *                         Dirk Fahland
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

package hub.sam.tef.semantics;

import hub.sam.tef.tsl.Binding;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.ElementReferenceBinding;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.ValueBinding;

/**
 * A semantics provider determines the semantics of a textual notation. While
 * its syntax is described separately in TSL, the semantics of the syntactical
 * constructs is defined in Java.
 * <p>
 * All the syntactical expressions means in TSL have a default semantics, but
 * for many (e.g. resolution of reference bindings) you might want to define a
 * custom, language specific, semantics.
 * <p>
 * There are different types of semantics for different meta-syntactical
 * constructs and other editor features:
 * <p>
 * <ul>
 * <li>Creation semantics for properties:
 * {@link this#getValueCreationSemanitcs()}</li>
 * <li>Creation semantics for values:
 * {@link this#getPropertyCreationSemantics(CompositeBinding)}</li>
 * <li>Reference semantics for properties</li>
 * <li>Print semantics for values</li>
 * <li>Model checking semantics for values</li>
 * <li><i>Content assist semantics for references</i></li>
 * <li><i>Semantic highlightings</i></li>
 * <li><i>...</i></li>
 * <li><i></i></li>
 * </ul>
 */
public interface ISemanticsProvider {

	public IValueCreationSemantics getValueCreationSemanitcs(ValueBinding binding);
	
	public IPropertyCreationSemantics getPropertyCreationSemantics(CompositeBinding binding);
	
	public IPropertyResolutionSemantics getPropertyResolutionSemantics(ReferenceBinding binding);
	
	public IElementReferenceResolutionSemantics getElementReferenceResolutionSemantics(ElementReferenceBinding binding);
	
	public IValuePrintSemantics getValuePrintSemantics(ValueBinding binding);
	
	public IDefaultValuePrintSemantics getDefaultValuePrintSemantics(PropertyBinding binding);
	
	public IValueCheckSemantics getValueCheckSemantics(ElementBinding binding);
	
	public IContentAssistSemantics getContentAssistSemantics(Binding binding);
}
