package hub.sam.tef.documents;

import org.eclipse.jface.text.Position;

import hub.sam.tef.annotations.IAnnotationModelProvider;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;

/**
 * An interface that allows implementing clients to provide all components of a TEF document model.
 * A TEF document model consist of the document text as a string, a tree representation of this text,
 * the acutal EMF model of the document, and the annotation model.
 */
public interface IDocumentModelProvider {
	
	public IModel getModel();
	
	public IAnnotationModelProvider getAnnotationModelProvider();
	
	public IModelElement getTopLevelElement();
	
	public String getText();
	
	public void addModelElementOccurence(IModelElement element, Position occurence);
	
	public void resetModelElementOccurences();
}
