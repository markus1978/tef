package hub.sam.tef.expressions.templates;

import java.util.Collection;

import hub.sam.tef.annotations.CouldNotResolveIdentifierException;
import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.emf.EMFCompletions;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.ISequence;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.tdl.TDLElementTemplate;
import hub.sam.tef.tdl.delegators.TDLElementTemplateDlg;
import hub.sam.tef.tdl.delegators.TemplateFactory;
import hub.sam.tef.templates.Template;

public class MyFunctionWithIdentifierTemplate extends TDLElementTemplateDlg {

	public MyFunctionWithIdentifierTemplate(IDocumentModelProvider modelProvider, TDLElementTemplate tdlElementTemplate, TemplateFactory factory) {
		super(modelProvider, tdlElementTemplate, factory);
	}

	public MyFunctionWithIdentifierTemplate(Template template, TDLElementTemplate tdlElementTemplate, TemplateFactory factory) {
		super(template, tdlElementTemplate, factory);
	}
	
	@Override
	public IModelElement resolveIdentifier(IModel model, ASTElementNode node, IModelElement context, IModelElement topLevelElement, IMetaModelElement expectedType, String property) throws CouldNotResolveIdentifierException {
		String id = node.getContent();
		for (IModelElement function: (ISequence<IModelElement>)topLevelElement.getValue("functions")) {
			if (id.equals(function.getValue("name"))) {
				return function;
			}
		}
		throw new CouldNotResolveIdentifierException("The is no function with the name " + id);
	}	

	@Override
	protected String getAlternativeSymbol() {
		return "Function_id";
	}
}
