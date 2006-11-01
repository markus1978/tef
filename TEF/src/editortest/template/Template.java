package editortest.template;

import java.util.List;
import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.FDIV;

import editortest.editor.TEFDocument;
import editortest.model.IModelElement;
import editortest.text.Document;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;

public abstract class Template {

	private final Document fDocument;
	
	public Template(Document document) {
		fDocument = document;
	}
	
	public Template(Template template) {
		fDocument = template.getDocument();
	}
	
	public Document getDocument() {
		return fDocument;
	}
	
	public List<Proposal> getProposals() {
		return new Vector<Proposal>();
	}
			
	public boolean isTemplateFor(Object model) {
		return true;
	}
	
	public abstract Text createText(IModelElement model);
	
	public abstract IModelElement createModelFromProposal(Proposal proposal);

}
