package editortest.mof.template;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import editortest.model.IMetaModelElement;
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
				return o1.getFDisplayProposal().compareTo(o2.getFDisplayProposal());
			} else {
				return -1;
			}
		}		
	}

	class MyReferenceProposalStrategy implements IReferenceProposalStrategy {
		public List<Proposal> getProposals(IMetaModelElement type) {
			List<Proposal> result = new Vector<Proposal>();
			for (IModelElement instance: type.getInstances()) {
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
	
	public MofPropertyTemplate(IMetaModelElement metaModel) {
		super(metaModel);
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
				new TerminalTemplate("        "),
				new ReferenceTemplate("type", 
						getMetaModel(), 
						getMetaModel().getType("Type"),
						new MyReferenceProposalStrategy()),
				new TerminalTemplate(" "),
				new IdentifierTemplate("name", getMetaModel()),
				new TerminalTemplate(";\n")
		};
	}
	
	@Override
	public List<Proposal> getProposals() {
		return Arrays.asList(new Proposal[] { 
				new Proposal("property... ", "<borken-ref> <unnamed> {\n}\n")
		});
	}
}
