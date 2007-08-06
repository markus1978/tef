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

import hub.sam.tef.TEFEMFTextEditor;
import hub.sam.tef.expressions.templates.MyFunctionCallTemplate;
import hub.sam.tef.expressions.templates.MyFunctionWithIdentifierTemplate;
import hub.sam.tef.expressions.templates.MyParameterAccessTemplate;
import hub.sam.tef.expressions.templates.MyParameterIdentifierTemplate;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.tdl.delegators.TemplateFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

import expressions.ExpressionsFactory;
import expressions.ExpressionsPackage;

public class ExpressionsEditor extends TEFEMFTextEditor {

	private final EPackage fPackage = ExpressionsPackage.eINSTANCE;
	private final EFactory fFactory = ExpressionsFactory.eINSTANCE;

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected AbstractLayoutManager getLayoutManager() {
		return new ExpressionLayout();
	}

	@Override
	protected String getMetaModelBundleResourcePath() {
		return "/models/expressions.ecore";
	}

	@Override
	protected Iterable<EPackage> getMetaModelPackages() {
		Collection<EPackage> result = new ArrayList<EPackage>();
		result.add(fPackage);
		return result;
	}

	@Override
	protected Iterable<EFactory> getModelFactories() {
		Collection<EFactory> result = new ArrayList<EFactory>();
		result.add(fFactory);
		return result;
	}

	@Override
	protected String getTemplateDefinitionBundleResourcePath() {
		return "/models/expressions.tdlt";
	}

	@Override
	protected void registerTemplateClasses(TemplateFactory factory) {
		factory.registerTemplateClass("FuncIdTpl", MyFunctionWithIdentifierTemplate.class);
		factory.registerTemplateClass("FuncCallTpl", MyFunctionCallTemplate.class);
		factory.registerTemplateClass("ParamAccessTpl", MyParameterAccessTemplate.class);
		factory.registerTemplateClass("ParamTpl", MyParameterIdentifierTemplate.class);
	}
	
	
}
