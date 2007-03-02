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

import java.util.Arrays;
import java.util.List;

public class SymbolRule extends SyntaxRule {
	
	private final List<Object> fSymbols;	
	private final String fMetaModelElementName;
	private final String[] fProperties;
	
	public SymbolRule(Object symbol, Object[] symbols, String metaModelElementName, String[] properties) {
		super(symbol);
		fSymbols = Arrays.asList(symbols);
		fMetaModelElementName = metaModelElementName;
		fProperties = properties;
	}
	
	protected SymbolRule(Object symbol, Object[] symbols) {
		super(symbol);
		fSymbols = Arrays.asList(symbols);
		fMetaModelElementName = null;
		fProperties = null;
	}
	
	public List<Object> getSymbols() {
		return fSymbols;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}
		if (obj instanceof SymbolRule) {
			return ((SymbolRule)obj).fSymbols.equals(fSymbols);
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return fSymbols.hashCode() + super.hashCode();
	}
	
	@Override
	public String toString() {
		return getSymbol() + "->" + fSymbols;
	}
	
	public String getMetaModelElementName() {
		return fMetaModelElementName;
	}
	
	public String[] getProperties() {
		return fProperties;
	}
}
