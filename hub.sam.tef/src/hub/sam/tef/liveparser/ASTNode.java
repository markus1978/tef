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

public class ASTNode {
	private final SyntaxRule fRule;
	
	public ASTNode(final SyntaxRule rule) {
		super();
		fRule = rule;
	}
	
	protected SyntaxRule getRule() {
		return fRule;
	}

	public Object getSymbol() {
		return fRule.getSymbol();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SymbolASTNode) {
			return getSymbol().equals(((SymbolASTNode)obj).getSymbol());
		} else {
			return getSymbol().equals(obj);
		}
	}

	@Override
	public int hashCode() {
		return getSymbol().hashCode();
	}	
}
