package editortest.mof.template;

import hub.sam.tef.views.CompoundText;
import hub.sam.tef.views.DocumentText;
import hub.sam.tef.views.FixText;
import hub.sam.tef.views.Text;
import editortest.model.ICollection;
import editortest.model.IModelElement;
import editortest.template.ElementTemplate;
import editortest.template.Template;

public class MofTemplate extends Template {

	private final ElementTemplate fElementTemplate;
	
	public MofTemplate(DocumentText document) {
		super(document);
		fElementTemplate = new MofPackageTemplate(this);
	}
	
	public Text createText(ICollection<IModelElement> set) {
		CompoundText result = new CompoundText();
		for(IModelElement element: set) {
			if (fElementTemplate.isTemplateFor(element)) {
				result.addText(fElementTemplate.createView(element));
				result.addText(new FixText("\n"));
			}
		}
		return result;
	}
}
