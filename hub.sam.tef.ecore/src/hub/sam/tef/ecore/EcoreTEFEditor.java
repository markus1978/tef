package hub.sam.tef.ecore;

import hub.sam.tef.TEFEMFTextEditor;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.syntax.ExpressionLayout;
import hub.sam.tef.tdl.delegators.TemplateFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.osgi.framework.Bundle;

public class EcoreTEFEditor extends TEFEMFTextEditor {

	private final EPackage fPackage = EcorePackage.eINSTANCE;
	private final EFactory fFactory = EcoreFactory.eINSTANCE;

	@Override
	protected Bundle getBundle() {
		return hub.sam.tef.ecore.EcoreTEFEditorPlugin.getDefault().getBundle();
	}

	@Override
	protected AbstractLayoutManager getLayoutManager() {
		return new ExpressionLayout();
	}

	@Override
	protected String getMetaModelBundleResourcePath() {
		// irrelevant
		return null;
	}
	
	@Override
	protected URI getMetaModelResource() {
		return URI.createURI(org.eclipse.emf.ecore.plugin.EcorePlugin.getPlugin().getBundle().
				getEntry("/model/Ecore.ecore").toString());		
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
		return "/resources/ecore.tdlt";
	}

	@Override
	protected void registerTemplateClasses(TemplateFactory factory) {
		
	}	
}

