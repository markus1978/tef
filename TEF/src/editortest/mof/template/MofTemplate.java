package editortest.mof.template;

import editortest.model.ICollection;
import editortest.model.IModelElement;
import editortest.template.ElementTemplate;
import editortest.template.Template;
import editortest.text.CompoundText;
import editortest.text.Document;
import editortest.text.FixText;
import editortest.text.Text;

public class MofTemplate extends Template {

	private final ElementTemplate fElementTemplate;
	
	public MofTemplate(Document document) {
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
