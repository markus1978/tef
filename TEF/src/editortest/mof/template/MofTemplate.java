package editortest.mof.template;

import editortest.model.IModelElement;
import editortest.model.ICollection;
import editortest.mof.model.MofMetaModelElementImpl;
import editortest.mof.model.MofModel;
import editortest.template.ModelBasedTemplate;
import editortest.template.Template;
import editortest.text.CompoundText;
import editortest.text.Proposal;
import editortest.text.Text;
import editortest.text.TextEvent;

public class MofTemplate extends ModelBasedTemplate {

	private final MofModel fMof;	
	private final Template fElementTemplate;
	
	public MofTemplate(final MofModel mof) {
		super(mof);
		fMof = mof;
		fElementTemplate = new MofPackageTemplate(mof);
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
