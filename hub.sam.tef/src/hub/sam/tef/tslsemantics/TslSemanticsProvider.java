package hub.sam.tef.tslsemantics;

import hub.sam.tef.modelcreating.ModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.DefaultSemanitcsProvider;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.IPropertyCreationSemantics;
import hub.sam.tef.semantics.IPropertyResolutionSemantics;
import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.semantics.UnresolvableReferenceError;
import hub.sam.tef.tsl.Binding;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.TslPackage;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Position;

public class TslSemanticsProvider extends DefaultSemanitcsProvider {
	
	private final IPropertyResolutionSemantics patternReferenceSemantics = new TslPatternTerminalPatternResolutionSemantics();
	private final Object metaModelReferenceSemantics = new TslBindingResolutionSemantics();
	private final IValueCheckSemantics fValueCheckSemantics = new TslCheckSemanitcs();

	@Override
	public IValueCheckSemantics getValueCheckSemantics(ElementBinding binding) {
		return fValueCheckSemantics;
	}

	@Override
	public IPropertyCreationSemantics getPropertyCreationSemantics(
			CompositeBinding binding) {
		if (binding.getProperty().getName().equals("metaModelPlatformURI")) {
			return (IPropertyCreationSemantics) metaModelReferenceSemantics;
		} else {
			return super.getPropertyCreationSemantics(binding);
		}
	}

	@Override
	public IPropertyResolutionSemantics getPropertyResolutionSemantics(
			ReferenceBinding binding) {
		String bindingId = binding.getBindingId();
		if ("TslPatternTerminalPatternBinding".equals(bindingId)) {
			return patternReferenceSemantics;
		} else if ("TslMetaModelReferenceBinding".equals(bindingId)) {
			return (IPropertyResolutionSemantics) metaModelReferenceSemantics;
		} else {
			return super.getPropertyResolutionSemantics(binding);
		}
	}

	@Override
	public IContentAssistSemantics getContentAssistSemantics(Binding binding) {
		if (binding instanceof CompositeBinding && 
				((CompositeBinding)binding).getProperty().eContainer() == TslPackage.eINSTANCE.getSimpleRule() &&
				((CompositeBinding)binding).getProperty().getFeatureID() == TslPackage.SIMPLE_RULE__RHS) {
			return new TslNonTerminalRhsPartContentAssist();			 
		} else if ((binding instanceof CompositeBinding && 
				((CompositeBinding)binding).getProperty().eContainer() == TslPackage.eINSTANCE.getSyntax() &&
				((CompositeBinding)binding).getProperty().getFeatureID() == TslPackage.SYNTAX__START)) {
			return new TslNonTerminalRhsPartContentAssist();
		} else {
			return super.getContentAssistSemantics(binding);
		}
	}



	private static class TslPatternTerminalPatternResolutionSemantics extends
			AbstractPropertySemantics implements IPropertyResolutionSemantics {
		@SuppressWarnings("unchecked")
		@Override
		public UnresolvableReferenceError resolve(ParseTreeNode parseTreeNode,
				Object actual, Object value, ModelCreatingContext context,
				ReferenceBinding binding) throws ModelCreatingException {
			Position range = parseTreeNode.getPosition();
			String id = context.getText().substring(range.getOffset() + 1,
					range.getOffset() + range.getLength() - 1);
			EObject resolution = null;
			try {
				resolution = resolve("rccSymbol", id, binding.getProperty()
						.getEType(), (Iterator)context.getAllContents());
			} catch (AmbiguousReferenceException ex) {
				context.addError(new Error(parseTreeNode.getPosition(), "Reference is ambiguous"));				
			}
			if (resolution != null) {
				setValue((EObject) actual, resolution, binding.getProperty());
				return null;
			} else {
				return new UnresolvableReferenceError("Could not resolve " + id + ".", parseTreeNode);
			}
		}
	}
}

