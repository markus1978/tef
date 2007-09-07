package hub.sam.tef.emf;

import hub.sam.tef.completion.CompletionContext;
import hub.sam.tef.completion.ICompletionDisplayStringProvider;
import hub.sam.tef.completion.ICompletionFilter;
import hub.sam.tef.completion.TEFCompletionProposal;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;

import java.util.Collection;
import java.util.Vector;

public class EMFCompletions {
	
	public static Collection<TEFCompletionProposal> createProposals(String metaClassName, String idAttributeName,	CompletionContext context) {
		return createProposals(metaClassName, idAttributeName, context, null);
	}
	
	public static Collection<TEFCompletionProposal> createProposals(String metaClassName, String idAttributeName,	CompletionContext context,
			ICompletionFilter filter) {
		Collection<TEFCompletionProposal> result = new Vector<TEFCompletionProposal>();
		IModel model = context.getDocumentModelProvider().getModel();
		for (IModelElement metaClassInstance : model.getElements(model
				.getMetaElement(metaClassName))) {
			String name = (String) metaClassInstance.getValue(idAttributeName);
			if (name != null && name.startsWith(context.getIdentifierPrefix())) {
				if (filter == null || filter.accept(metaClassInstance)) {
					result.add(new TEFCompletionProposal(name, name.substring(
							context.getIdentifierPrefix().length(), name.length()),
							context.getCompletionOffset()));
				}
			}
		}
		return result;
	}
	
	/**
	 *  This operation apparently only look for elements in the document toplevel and below elements.
	 */
	@Deprecated
	public static Collection<TEFCompletionProposal> createProposals(String metaModelElement, CompletionContext context) {
		return createProposals(metaModelElement, context, null, null);
	}
	
	/**
	 *  This operation apparently only look for elements in the document toplevel and below elements.
	 */
	@Deprecated
	public static Collection<TEFCompletionProposal> createProposals(String metaModelElement, CompletionContext context,
			ICompletionFilter filter, ICompletionDisplayStringProvider provider) {
		String identifierPrefix = context.getIdentifierPrefix();
		Collection<TEFCompletionProposal> result = new Vector<TEFCompletionProposal>();
		Collection<IModelElement> validElements = getValidElements(context.getDocumentModelProvider().getModel(), 
				context.getDocumentModelProvider().getModel().getMetaElement(metaModelElement), 
				context.getDocumentModelProvider().getTopLevelElement());
		
		for (IModelElement possibleElement: validElements) {
			String name = null;
			if (provider == null) {
				name = (String)possibleElement.getValue("name");
			} else {
				name = provider.getDisplayString(possibleElement);
			}
			if (name != null && name.startsWith(identifierPrefix) && ! name.equals(identifierPrefix)) {
				if (filter == null || filter.accept(possibleElement)) { 
					result.add(new TEFCompletionProposal(name, 
							name.substring(identifierPrefix.length(), name.length()), context.getCompletionOffset()));
				}
			}
		}
		return result;
	}

	public static Collection<IModelElement> getValidElements(IModel model, IMetaModelElement metaModelElement, IModelElement topLevelElement) {
		Collection<IModelElement> result = new Vector<IModelElement>();
		for (Object o: model.getElementExceptEditedResource(metaModelElement)) {
			result.add((IModelElement)o);
		}
		collectValidElementsFromModel(topLevelElement, 	metaModelElement, result);
		return result;
	}
	
	private static void collectValidElementsFromModel(IModelElement element, IMetaModelElement metaModelElement, 
			Collection<IModelElement> values) {
		if (element != null) {
			if (element.getMetaElement().equals(metaModelElement)) {		
			values.add(element);
			}
			for (Object o: element.getComponents()) {
				collectValidElementsFromModel((IModelElement)o, metaModelElement, values);
			}
		}
	}
}
