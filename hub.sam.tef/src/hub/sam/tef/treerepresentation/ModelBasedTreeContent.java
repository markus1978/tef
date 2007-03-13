package hub.sam.tef.treerepresentation;

import hub.sam.tef.models.IModelElement;
import hub.sam.tef.parse.ISyntaxProvider;
import hub.sam.tef.templates.Template;

import java.util.List;
import java.util.Vector;

public class ModelBasedTreeContent extends TreeContents {

	private final List<Object> fContents = new Vector<Object>();
	private final Template fTemplate;
	private final IModelElement fModel;
	
	public ModelBasedTreeContent(final Template template, final IModelElement model) {
		super();
		fTemplate = template;
		fModel = model;
	}

	@Override
	public IModelElement getModel() {
		return fModel;
	}

	@Override
	public Template getTemplate() {
		return fTemplate;
	}
	
	public void addContent(Object content) {
		fContents.add(content);
	}

	@Override
	public String getContent() {
		StringBuffer result = new StringBuffer();
		for (Object content: fContents) {
			if (content instanceof TreeContents) {
				result.append(((TreeContents)content).getContent());
			} else {
				result.append(content.toString());
			}
		}
		return result.toString();
	}	
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(fTemplate.getAdapter(ISyntaxProvider.class).getNonTerminal() + " ");
		return result.toString();
	}
	
}
