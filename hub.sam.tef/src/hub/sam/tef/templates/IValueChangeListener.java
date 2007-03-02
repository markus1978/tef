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
package hub.sam.tef.templates;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.liveparser.SymbolASTNode;

/**
 * This listner is used to react on changes in values. ValueTemplates create
 * views that represent values, only the ValueTemplate knows how the value
 * changes when the view is given events. But the ValueTemplate does not know
 * what to do with the model when the value change. Therefore, the corresponding
 * PropertyTemplate gives an instance of this interface when the value view is
 * created. This ValueTemplate uses this instance to propagate a change in the
 * value to the PropertyTemplate.
 */
public interface IValueChangeListener<ModelType> {
	void valueChanges(ModelType newValue);
	void newValue(Proposal proposal, ValueTemplate<ModelType> template);
	void removeValue();
	void valueChanges(SymbolASTNode node);
}
