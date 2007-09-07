package $packageName$.templates;

import hub.sam.tef.annotations.CouldNotResolveIdentifierException;
import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.emf.model.EMFModelElement;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.tdl.delegators.TDLElementTemplateDlg;
import hub.sam.tef.tdl.delegators.TemplateFactory;
import hub.sam.tef.tdl.model.TDLElementTemplate;
import hub.sam.tef.templates.Template;

import org.eclipse.emf.ecore.EObject;

import expressions.Function;
import expressions.Parameter;

public class MyParameterIdentifierTemplate extends TDLElementTemplateDlg {

	public MyParameterIdentifierTemplate(IDocumentModelProvider modelProvider, TDLElementTemplate tdlElementTemplate, TemplateFactory factory) {
		super(modelProvider, tdlElementTemplate, factory);
	}

	public MyParameterIdentifierTemplate(Template template, TDLElementTemplate tdlElementTemplate, TemplateFactory factory) {
		super(template, tdlElementTemplate, factory);
	}
	
	@Override
	public IModelElement resolveIdentifier(IModel model, ASTElementNode node, IModelElement context, IModelElement topLevelElement, IMetaModelElement expectedType, String property) throws CouldNotResolveIdentifierException {
		String id = node.getContent();
		EObject contextAsEMF = ((EMFModelElement)context).getEMFObject();
		while (!(contextAsEMF instanceof Function)) {
			contextAsEMF = contextAsEMF.eContainer();
		}
		
		for (Object parameter: ((Function)contextAsEMF).getParameters()) {
			if (id.equals(((Parameter)parameter).getName())) {
				return new EMFModelElement((EObject)parameter);
			}
		}
		throw new CouldNotResolveIdentifierException("The is no parameter with the name " + id + " in function " + ((Function)contextAsEMF).getName());
	}
}
