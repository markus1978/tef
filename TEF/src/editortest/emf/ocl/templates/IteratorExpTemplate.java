package editortest.emf.ocl.templates;

import java.util.Arrays;
import java.util.List;

import editortest.emf.model.EMFMetaModelElement;
import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ChoiceTemplate;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.OptionalTemplate;
import hub.sam.tef.templates.SequenceTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

public class IteratorExpTemplate extends ElementTemplate {

	public IteratorExpTemplate(Template template) {
		super(template, template.getModel().getMetaElement("IteratorExp"));	
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new OptionalTemplate<IModelElement>(this, "source") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new OclExpressionTemplate(this);
				}				
			},
			new TerminalTemplate(this, "->"),
			new TerminalTemplate(this, "forAll"), // TODO
			new TerminalTemplate(this, "("),
			new SequenceTemplate<IModelElement>(this, "iterator", ", ", false, true) {	
				@Override
				protected ValueTemplate createElementTemplate() {
					return new VariableTemplate(this);
				}			
			},
			new TerminalTemplate(this, "|"),
			new OptionalTemplate<IModelElement>(this, "body") {
				@Override
				protected ValueTemplate<IModelElement> createValueTemplate() {
					return new OclExpressionTemplate(this);
				}				
			},
			new TerminalTemplate(this, ")")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal(((EMFMetaModelElement)getMetaElement()).getEMFObject().getName() + " ...", null, 0)
		});
	}
}
