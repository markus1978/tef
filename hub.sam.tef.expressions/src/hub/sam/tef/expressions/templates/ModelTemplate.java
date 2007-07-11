package hub.sam.tef.expressions.templates;

import hub.sam.tef.documents.IDocumentModelProvider;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;

public class ModelTemplate extends ElementTemplate {

	public ModelTemplate(IDocumentModelProvider modelProvider) {
		super(modelProvider, modelProvider.getModel().getMetaElement("Model"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new SequenceTemplate<IModelElement>(this, "functions", null, false) {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new FunctionTemplate(this);
					}
				}
		};
	}
}
