package editortest.mof.template;

import editortest.model.IModelElement;
import editortest.mof.model.MofMetaModelElementImpl;
import editortest.mof.model.MofModel;
import editortest.template.AbitraryTemplate;
import editortest.template.Template;

public class MofTemplate extends AbitraryTemplate {

	private final MofModel fMof;	
	
	public MofTemplate(final MofModel mof) {
		super();
		fMof = mof;
	}

	@Override
	public Template<IModelElement> createElementTemplate() {		
		return new MofPackageTemplate(
				new MofMetaModelElementImpl(fMof.getMetaClass("Package"), 
						fMof.getFactory(), fMof));
	}		
}
