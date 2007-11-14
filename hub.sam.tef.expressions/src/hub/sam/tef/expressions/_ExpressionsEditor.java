package hub.sam.tef.expressions;

import hub.sam.tef.contentassist.CompletionContext;
import hub.sam.tef.contentassist.CompletionProposal;
import hub.sam.tef.editor.TextEditor;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.DefaultContentAssistSemantics;
import hub.sam.tef.semantics.DefaultSemanitcsProvider;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import expressions.ExpressionsPackage;
import expressions.Function;
import expressions.provider.ExpressionsItemProviderAdapterFactory;

public class _ExpressionsEditor extends TextEditor {

	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { ExpressionsPackage.eINSTANCE };
	}

	@Override
	public String getPlatformURIOfSyntax() {
		return "/hub.sam.tef.expressions/models/expressions.tslt";
	}	

	@Override
	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new ExpressionsItemProviderAdapterFactory() };
	}

	@Override
	public ISemanticsProvider createSemanticsProvider() {
		return new DefaultSemanitcsProvider() {
			@Override
			public IContentAssistSemantics getContentAssistSemantics(
					final ReferenceBinding binding) {
				if (binding.getProperty().getName().equals("function")) {
					return new DefaultContentAssistSemantics() {
						@Override
						public Rule getRule() {
							return (Rule)binding.eContainer().eContainer();
						}

						@Override
						public String[] getRulePrefix() {
							return new String[] {};
						}

						@SuppressWarnings("unchecked")
						@Override
						public Collection<CompletionProposal> createProposals(
								ParseTreeNode completionNode,
								CompletionContext context) {
							Collection<String> result = new ArrayList<String>();
							Iterator<EObject> it = context.getAllContents();
							if (it == null) {
								return Collections.EMPTY_LIST;
							}
							while(it.hasNext()) {
								EObject next = it.next();
								if (next instanceof Function) {
									result.add(((Function)next).getName());
								}
							}
							return CompletionProposal.createProposals(
									result, context, null);
						}						
					};
				} else {
					return super.getContentAssistSemantics(binding);
				}
			}			
		};
	}

	
}
