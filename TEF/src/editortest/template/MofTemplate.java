package editortest.template;

import editortest.model.MofMetaModelElementImpl;
import editortest.model.MofModel;

public class MofTemplate extends AbitraryTemplate {

	private final MofModel fMof;	
	
	public MofTemplate(final MofModel mof) {
		super();
		fMof = mof;
	}

	@Override
	public Template createElementTemplate() {		
		return new MofPackageTemplate(
				new MofMetaModelElementImpl(fMof.getMetaClass("Package"), 
						fMof.getFactory(), fMof));
	}		
}
