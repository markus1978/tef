package editortest.emf.ecoretemplates;

import java.util.Arrays;
import java.util.List;

import editortest.controller.Proposal;
import editortest.emf.model.EMFMetaModelElement;
import editortest.model.IMetaModelElement;
import editortest.model.IModelElement;
import editortest.template.ElementTemplate;
import editortest.template.SequenceTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.template.ValueTemplate;
import editortest.template.whitespaces.LayoutElementTemplate;
import editortest.template.whitespaces.LayoutManager;
import editortest.view.DocumentText;

public abstract class EModelElementTemplate extends ElementTemplate {

	public EModelElementTemplate(DocumentText document, IMetaModelElement metaModel) {
		super(document, metaModel);
	}

	public EModelElementTemplate(Template template, IMetaModelElement metaModel) {
		super(template, metaModel);
	}

	protected Template[] getAnnotationTemplates() {
		return new Template[] {
			new LayoutElementTemplate(this, LayoutManager.INDENT),
			new TerminalTemplate(this, "annotations"),
			new LayoutElementTemplate(this, LayoutManager.BEGIN_BLOCK, ": [\n"),
			new SequenceTemplate<IModelElement>(this, "eAnnotations", "\n", true) {
				@Override
				protected ValueTemplate<IModelElement> createElementTemplate() {
					return new EAnnotationTemplate(this);
				}
			},
			new LayoutElementTemplate(this, LayoutManager.END_BLOCK, "]\n")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
		});
	}
}
