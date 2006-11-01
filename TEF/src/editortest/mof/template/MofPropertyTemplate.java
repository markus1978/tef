package editortest.mof.template;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import editortest.model.IMetaModelElement;
import editortest.model.IModel;
import editortest.model.IModelElement;
import editortest.mof.model.MofModel;
import editortest.mof.model.MofModelElementImpl;
import editortest.template.ElementTemplate;
import editortest.template.IReferenceProposalStrategy;
import editortest.template.IdentifierTemplate;
import editortest.template.ReferenceTemplate;
import editortest.template.Template;
import editortest.template.TerminalTemplate;
import editortest.text.Proposal;

public class MofPropertyTemplate extends ElementTemplate {
	
	class ProposalCompare implements Comparator<Proposal> {
		public int compare(Proposal o1, Proposal o2) {
			if (o1.getGroup() > o2.getGroup()) {
				return 1;
			} else if (o1.getGroup() == o2.getGroup()) {
				return o1.getContextDisplayString().compareTo(o2.getContextDisplayString());
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
	
	public MofPropertyTemplate(Template template, IModel model) {
		super(template, model, model.getMetaElement("Property"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new MofIndentationTemplate(this),
				new ReferenceTemplate(this, getModel(), "type", 
						getMetaElement(), 
						getModel().getMetaElement("Type"),
						new MyReferenceProposalStrategy()),
				new TerminalTemplate(this, " "),
				new IdentifierTemplate(this, getModel(), "name", getMetaElement()),
				new TerminalTemplate(this, ";\n")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("property... ", null, 0)
		});
	}
}
