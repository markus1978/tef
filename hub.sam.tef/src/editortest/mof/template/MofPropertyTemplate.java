package editortest.mof.template;

import hub.sam.tef.controllers.Proposal;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.IReferenceProposalStrategy;
import hub.sam.tef.templates.ReferenceTemplate;
import hub.sam.tef.templates.SetTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.StringTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.TerminalTemplate;
import hub.sam.tef.templates.ValueTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import editortest.mof.model.MofModelElementImpl;

public class MofPropertyTemplate extends MofNamedElementTemplate {
	
	class ProposalCompare implements Comparator<Proposal> {
		public int compare(Proposal o1, Proposal o2) {
			if (o1.getGroup() > o2.getGroup()) {
				return 1;
			} else if (o1.getGroup() == o2.getGroup()) {
				String displayString1 = o1.getContextDisplayString();
				String displayString2 = o2.getContextDisplayString();
				if (displayString1 == null && displayString2 != null) {
					return 1;
				} else if (displayString2 == null && displayString1 != null) {
					return -1;
				} else if (displayString1 != null && displayString2 != null) {
					return displayString1.compareTo(displayString2);
				} else {
					return 0;
				}
			} else {
				return -1;
			}
		}		
	}

	class MyReferenceProposalStrategy implements IReferenceProposalStrategy {
		public List<Proposal> getProposals(IMetaModelElement type) {
			List<Proposal> result = new Vector<Proposal>();
			for (IModelElement instance: getModel().getElements(type)) {
				MofModelElementImpl mofInstance = (MofModelElementImpl)instance;
				if (mofInstance.getMofObject() instanceof cmof.DataType) {
					result.add(new Proposal((String)mofInstance.getValue("name"),
							(String)mofInstance.getValue("name"), 1));
				} else if (mofInstance.getMofObject() instanceof cmof.UmlClass){
					result.add(new Proposal((String)mofInstance.getValue("name"),
							(String)mofInstance.getValue("name"), 0));
				}
			}
			Collections.sort(result, new ProposalCompare());
			return result;
		}	
	}
	
	public MofPropertyTemplate(Template template) {
		super(template, template.getModel().getMetaElement("Property"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(this),
				new SingleValueTemplate<IModelElement>(this, "type") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new ReferenceTemplate(this,  getModel().getMetaElement("Type"), new MyReferenceProposalStrategy()) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new MofIdentifierTemplate(this);
							}							
						};
					}					
				},				
				new TerminalTemplate(this, " "),
				new SingleValueTemplate<String>(this, "name") {
					@Override
					protected ValueTemplate<String> createValueTemplate() {
						return new StringTemplate(this);
					}					
				},
				new TerminalTemplate(this, " opposite: "),
				new SingleValueTemplate<IModelElement>(this, "opposite") {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new ReferenceTemplate(this,  getModel().getMetaElement("Property"), null) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new MofIdentifierTemplate(this);
							}							
						};
					}					
				},				
				new TerminalTemplate(this, ", subsets {"),
				new SetTemplate<IModelElement>(this, "subsettedProperty", ", ", false) {
					@Override
					protected ValueTemplate<IModelElement> createValueTemplate() {
						return new ReferenceTemplate(this, getModel().getMetaElement("Property"), null) {
							@Override
							protected ElementTemplate getElementTemplate() {
								return new MofIdentifierTemplate(this);
							}							
						};
					}					
				},
				new TerminalTemplate(this, "};")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("property... ", null, 0)
		});
	}
}
