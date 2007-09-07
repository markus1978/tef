package $packageName$;

import hub.sam.tef.TEFEMFTextEditor;
import $packageName$.templates.MyFunctionCallTemplate;
import $packageName$.templates.MyFunctionWithIdentifierTemplate;
import $packageName$.templates.MyParameterAccessTemplate;
import $packageName$.templates.MyParameterIdentifierTemplate;
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

public class $editorClass$ extends TEFEMFTextEditor {

	private final EPackage fPackage = ExpressionsPackage.eINSTANCE;
	private final EFactory fFactory = ExpressionsFactory.eINSTANCE;

	@Override
	protected Bundle getBundle() {
		return $activatorClass$.getDefault().getBundle();
	}

	@Override
	protected AbstractLayoutManager getLayoutManager() {
		return new ExpressionLayout();
	}

	@Override
	protected String getMetaModelBundleResourcePath() {
		return "/resources/expressions.ecore";
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
		return "/resources/expressions.tdlt";
	}

	@Override
	protected void registerTemplateClasses(TemplateFactory factory) {
		factory.registerTemplateClass("FuncIdTpl", MyFunctionWithIdentifierTemplate.class);
		factory.registerTemplateClass("FuncCallTpl", MyFunctionCallTemplate.class);
		factory.registerTemplateClass("ParamAccessTpl", MyParameterAccessTemplate.class);
		factory.registerTemplateClass("ParamTpl", MyParameterIdentifierTemplate.class);
	}	
}

