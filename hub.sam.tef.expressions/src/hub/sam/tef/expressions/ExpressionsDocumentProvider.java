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
package hub.sam.tef.expressions;

import hub.sam.tef.emf.EMFTextDocumentProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.text.IDocument;

import expressions.ExpressionsFactory;
import expressions.ExpressionsPackage;

public class ExpressionsDocumentProvider extends EMFTextDocumentProvider {

	private final EPackage fPackage = ExpressionsPackage.eINSTANCE;
	private final EFactory fFactory = ExpressionsFactory.eINSTANCE;

	@Override
	protected Iterable<EFactory> getFactory() {
		Vector<EFactory> result = new Vector<EFactory>();
		result.add(fFactory);
		return result;
	}
	
	@Override
	protected Iterable<EPackage> getPackage() {
		Vector<EPackage> result = new Vector<EPackage>();
		result.add(fPackage);
		return result;
	}
	
	@Override
	public IDocument createEmptyDocument()  {
		return new ExpressionsDocument();		
	}
	
	@Override
	public EditingDomain getEditingDomain() {
		return getSharedEditingDomain();
	}
	
	private static AdapterFactoryEditingDomain sharedEditingDomain = null;

	private static ComposedAdapterFactory createAdaptorFactory() {
		List factories = new ArrayList();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		return new ComposedAdapterFactory(factories);
	}
	  
	public static AdapterFactoryEditingDomain getSharedEditingDomain() {
		if (sharedEditingDomain == null) {
			BasicCommandStack commandStack = new BasicCommandStack();	
			sharedEditingDomain = new AdapterFactoryEditingDomain(
					createAdaptorFactory(), commandStack, new HashMap());
		}
		return sharedEditingDomain;
	}
	
}
