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
package hub.sam.tef.liveparser;

import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * A Tree that represent a parsed string based on the used
 * rules.
 */
public class SymbolASTNode extends ASTNode {

	private final List<ASTNode> fChildren = new Vector<ASTNode>();	
	
	@Override
	protected SymbolRule getRule() {
		return (SymbolRule)super.getRule();
	}

	public SymbolASTNode(final SymbolRule symbolRule) {
		super(symbolRule);		
	}

	public void addChildren(ASTNode child) {
		fChildren.add(child);
	}
	
	public Iterable<ASTNode> getChildren() {
		List<ASTNode> copy = new Vector<ASTNode>(fChildren.size());
		for (int i = fChildren.size() - 1; i >= 0; i--) {
			copy.add(fChildren.get(i));
		}
		return copy;
	}
	
	public Object getSymbol() {
		return getRule().getSymbol();
	}
	
	public void createModelElements(IModel model, IModelElement owner, String property) {
		model.getCommandFactory().createChild(owner, model.getMetaElement(
				getRule().getMetaModelElementName()), property).execute();
		IModelElement element = (IModelElement)owner.getValue(property);

		int i = 0;
		for (ASTNode child: getChildren()) {
			String childProperty = getRule().getProperties()[i++];
			if (childProperty != null) {
				if (child instanceof SymbolASTNode) {		
					((SymbolASTNode)child).createModelElements(model, element, childProperty);																			
				} else {				
					model.getCommandFactory().set(element, childProperty, ((TerminalASTNode)child).getValue()).execute();
				}
			}
		}
	}
}
