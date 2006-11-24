package editortest.emf.editor;

import hub.sam.tef.TEFDocument;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.FixText;
import editortest.emf.ecoretemplates.EPackageTemplate;
import editortest.emf.model.EMFModelElement;

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
