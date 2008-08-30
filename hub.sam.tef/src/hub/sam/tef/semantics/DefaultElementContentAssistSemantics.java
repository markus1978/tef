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

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.SimpleRule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class DefaultElementContentAssistSemantics implements IContentAssistSemantics {
	private final ElementBinding fElementBinding;

	public DefaultElementContentAssistSemantics(
			ElementBinding elementBinding) {
		super();
		fElementBinding = elementBinding;
	}

	public Collection<ContentAssistProposal> createProposals(
			ContentAssistContext context) {
		List<String> result = new ArrayList<String>();
		NonTerminal nonTerminal = ((SimpleRule)fElementBinding.eContainer()).getLhs();
		EClass eClass = fElementBinding.getMetaclass();
		if (eClass.isAbstract()) {
			return Collections.emptyList(); // TODO
		}
		try {
			EObject representative = instantiate(eClass, context);
			PrettyPrinter printer = context.getEditor().createPrettyPrinter();
			printer.setLayout(new BlockLayout()); // TODO
			PrettyPrintState state = new PrettyPrintState(representative);
			printer.print(nonTerminal, state);			
			result.add(state.toString());
		} catch(ModelCreatingException ex) {
			// TODO produce warning
			ex.printStackTrace();
		} catch(Throwable ex) {
			// TODO produce warning
			System.out.println("unexpected error: " + ex.getLocalizedMessage());
		}
		return ContentAssistProposal.createProposals(
				result, context, 
				null, ContentAssistProposal.ELEMENT_IMAGE, ContentAssistProposal.ELEMENT);		
	}	
	
	/**
	 * Creates an instance of the given meta class. 
	 * 
	 * @param metaClass
	 *            is the meta class, a class with the same name must be
	 *            contained in on of the meta model packages in given context.
	 * @return the created model element.
	 * @throws ModelCreatingException,
	 *             if the meta class is not contained in the meta model packages
	 *             of this context.
	 */
	private EObject instantiate(EClass metaClass, ContentAssistContext context) throws ModelCreatingException {
		loop: for (EPackage ePackage: context.getEditor().getMetaModelPackages()) {
			EClassifier classifier = null;
			if ((classifier = ePackage.getEClassifier(metaClass.getName())) != null) {
				if (!(classifier instanceof EClass) || ((EClass)classifier).isAbstract()) {
					continue loop;
				}
				EObject result = ePackage.getEFactoryInstance().create(metaClass);				
				return result;
			}
		}
		throw new ModelCreatingException("Cannot instanitate " + metaClass.getName() + ".");
	}
}
