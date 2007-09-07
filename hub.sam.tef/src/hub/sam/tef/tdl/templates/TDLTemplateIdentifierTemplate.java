package hub.sam.tef.tdl.templates;

import hub.sam.tef.annotations.CouldNotResolveIdentifierException;
import hub.sam.tef.models.ICollection;
import hub.sam.tef.models.IMetaModelElement;
import hub.sam.tef.models.IModel;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.templates.ElementTemplate;
import hub.sam.tef.templates.SingleValueTemplate;
import hub.sam.tef.templates.Template;
import hub.sam.tef.templates.ValueTemplate;
import hub.sam.tef.templates.primitives.IdentifierTemplate;

public class TDLTemplateIdentifierTemplate extends ElementTemplate {
	
	public TDLTemplateIdentifierTemplate(Template template) {
		super(template, template.getModel().getMetaElement("TDLTemplate"));
	}

	@Override
	public Template[] createTemplates() {
		return new Template[] {
			new SingleValueTemplate<String>(this, "name") {
				@Override
				protected ValueTemplate<String> createValueTemplate() {
					return new IdentifierTemplate(this);
				}			
			}
		};
	}

	@Override
	protected String getAlternativeSymbol() {
		return "TDLTemplate_identifier";
	}
	

	@Override
	public IModelElement resolveIdentifier(IModel model, ASTElementNode node, IModelElement context, IModelElement topLevelElement, IMetaModelElement expectedType, String property) throws CouldNotResolveIdentifierException {		
		String name = node.getNode("name").getContent();			
		for(IModelElement template: (ICollection<IModelElement>)topLevelElement.getValue("templates")) {
			if (name != null && name.equals(template.getValue("name"))) {
				return template;
			}
		}
		throw new CouldNotResolveIdentifierException("There is no template with the name " + name);		
	}	
}
