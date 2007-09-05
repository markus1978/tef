package hub.sam.tef.expressions.templates;

import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.emf.EMFCompletions;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.tdl.delegators.TDLElementTemplateDlg;
import hub.sam.tef.tdl.delegators.TemplateFactory;
import hub.sam.tef.tdl.model.TDLElementTemplate;
import hub.sam.tef.templates.Template;

import java.util.Collection;

public class MyFunctionCallTemplate extends TDLElementTemplateDlg {

	public MyFunctionCallTemplate(IDocumentModelProvider modelProvider, TDLElementTemplate tdlElementTemplate, TemplateFactory factory) {
		super(modelProvider, tdlElementTemplate, factory);
	}

	public MyFunctionCallTemplate(Template template, TDLElementTemplate tdlElementTemplate, TemplateFactory factory) {
		super(template, tdlElementTemplate, factory);	
	}
	
	@Override
	public String[] getPropertiesWithCompletion() {
		return new String[] { "function" };
	}

	@Override
	public Collection<TEFCompletionProposal> createPropertyCompletionProposals(String property, 
			ASTElementNode completionNode, CompletionContext context) {		
		return EMFCompletions.createProposals("Function", "name", context);
	}

}
