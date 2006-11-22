package editortest.emf.editor;

import editortest.editor.TEFDocument;
import editortest.emf.ecoretemplates.EPackageTemplate;
import editortest.emf.model.EMFModelElement;
import editortest.model.ICollection;
import editortest.model.IModelElement;
import editortest.view.DocumentText;
import editortest.view.FixText;

public class EcoreDocument extends TEFDocument {

	@Override
	public DocumentText createDocument() {
		DocumentText result = new DocumentText(this);
		ICollection<IModelElement> outermostComposites = getModel().getOutermostComposites();
		IModelElement topLevelPackage = null;
		for (IModelElement o: outermostComposites) {
			if (o.getMetaElement().equals(getModel().getMetaElement("EPackage"))) {
				topLevelPackage = o;
				result.addText(new EPackageTemplate(result).createView(topLevelPackage));
				result.addText(new FixText("\n"));
			}
		}
		if (topLevelPackage == null) {
			topLevelPackage = getModel().createElement(getModel().getMetaElement("EPackage"));
			getModel().getOutermostComposites().add(topLevelPackage);
			result.addText(new EPackageTemplate(result).createView(topLevelPackage));
		}		
		return result;
	}

	
}
