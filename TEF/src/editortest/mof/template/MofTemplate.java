package editortest.mof.template;

import editortest.model.ICollection;
import editortest.model.IModelElement;
import editortest.template.ModelBasedTemplate;
import editortest.template.Template;
import editortest.text.CompoundText;
import editortest.text.Document;
import editortest.text.Proposal;
import editortest.text.Text;

public class MofTemplate extends ModelBasedTemplate {

	private final Template fElementTemplate;
	
	public MofTemplate(Document document) {
		super(document);
		fElementTemplate = new MofPackageTemplate(this);
	}
	
	public Text createText(ICollection<IModelElement> set) {
		CompoundText result = new CompoundText();
		for(IModelElement element: set) {
			if (fElementTemplate.isTemplateFor(element)) {
				result.addText(fElementTemplate.createText(element));
			}
		}
		return result;
	}
		
	@Override
	public Text createText(IModelElement model) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IModelElement createModelFromProposal(Proposal proposal) {
		// TODO Auto-generated method stub
		return null;
	}

}
