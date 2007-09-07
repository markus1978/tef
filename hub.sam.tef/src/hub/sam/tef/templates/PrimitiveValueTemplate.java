package hub.sam.tef.templates;

import hub.sam.tef.annotations.ISemanticProvider;
import hub.sam.tef.annotations.SemanticsContext;
import hub.sam.tef.models.IModelElement;
import hub.sam.tef.models.IType;
import hub.sam.tef.reconciliation.syntax.AbstractLayoutManager;
import hub.sam.tef.reconciliation.treerepresentation.ASTElementNode;
import hub.sam.tef.reconciliation.treerepresentation.ASTNode;
import hub.sam.tef.reconciliation.treerepresentation.IASTProvider;
import hub.sam.tef.reconciliation.treerepresentation.PrimitiveTreeRepresentation;

public abstract class PrimitiveValueTemplate<ModelType> extends ValueTemplate<ModelType> {

	public PrimitiveValueTemplate(Template template, IType type) {
		super(template, type);
	}
		
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (IASTProvider.class == adapter) {
			return (T) new TreeRepresentationProvider();
		} else {
			return super.getAdapter(adapter);
		}
	}
	
	protected abstract Object getObjectValueFromStringValue(String value);

	class TreeRepresentationProvider implements IASTProvider {
		public ASTNode createTreeRepresentation(IModelElement owner, String property, Object model, boolean isComposite, AbstractLayoutManager layout) {
			return new PrimitiveTreeRepresentation((model == null) ? "unknown" : model);
		}

		public Object createCompositeModel(IModelElement owner, String property, ASTNode tree, boolean isComposite) {
			getModel().getCommandFactory().set(owner, property, 
					getObjectValueFromStringValue(((PrimitiveTreeRepresentation)tree).getContent())).execute();
			return null;
		}

		public Object createReferenceModel(IModelElement owner, String property, ASTNode tree, boolean isComposite, SemanticsContext context) {		
			return null;
		}	
		
	}
}
