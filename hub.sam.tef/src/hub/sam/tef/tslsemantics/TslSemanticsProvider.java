package hub.sam.tef.tslsemantics;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.etsl.EtslPackage;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.DefaultIdentificationScheme;
import hub.sam.tef.semantics.DefaultSemanticsProvider;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.IIdentificationScheme;
import hub.sam.tef.semantics.IPropertyCreationSemantics;
import hub.sam.tef.semantics.IPropertyResolutionSemantics;
import hub.sam.tef.semantics.IValueCheckSemantics;
import hub.sam.tef.semantics.IdAttributeIdentificationScheme;
import hub.sam.tef.semantics.UnresolvableReferenceError;
import hub.sam.tef.semantics.UnresolvableReferenceError.UnresolveableReferenceErrorException;
import hub.sam.tef.tsl.Binding;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.TslPackage;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Position;

public class TslSemanticsProvider extends DefaultSemanticsProvider {
	
	private final IPropertyResolutionSemantics patternReferenceSemantics = new TslPatternTerminalPatternResolutionSemantics();
	private final Object metaModelReferenceSemantics = new TslBindingResolutionSemantics();
	private final IValueCheckSemantics fValueCheckSemantics = new TslCheckSemanitcs();
	
	public TslSemanticsProvider() {
		super(DefaultIdentificationScheme.INSTANCE);
	}

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
		} else if (binding instanceof CompositeBinding && 
				((CompositeBinding)binding).getProperty().eContainer() == EtslPackage.eINSTANCE.getRhsPart() &&
				((CompositeBinding)binding).getProperty().getFeatureID() == EtslPackage.RHS_PART__SYMBOL) {
			return new TslNonTerminalRhsPartContentAssist();
		} else if ((binding instanceof CompositeBinding && 
				((CompositeBinding)binding).getProperty().eContainer() == TslPackage.eINSTANCE.getSyntax() &&
				((CompositeBinding)binding).getProperty().getFeatureID() == TslPackage.SYNTAX__START)) {
			return new TslNonTerminalRhsPartContentAssist();
		} else if ((binding instanceof CompositeBinding && 
				((CompositeBinding)binding).getProperty().eContainer() == TslPackage.eINSTANCE.getWhiteSpace() &&
				((CompositeBinding)binding).getProperty().getFeatureID() == TslPackage.WHITE_SPACE__ROLE)) {
			return new TslWhiteSpaceContentAssist();
		} else if ("TslMetaModelReferenceBinding".equals(binding.getBindingId())) {				
			return new TslPropertyContentAssist();		
		} else {
			return super.getContentAssistSemantics(binding);
		}
	}
	
	private static class TslWhiteSpaceContentAssist implements IContentAssistSemantics {
		public Collection<ContentAssistProposal> createProposals(
				ContentAssistContext context) {
			return ContentAssistProposal.createProposals(
					new String[] { 	"empty", "space", "blockstart", "blockend", "statement", "indent" }, 
					context, null, null, 
					ContentAssistProposal.REFERENCE);			
		}		
	}

	private static class TslPatternTerminalPatternResolutionSemantics extends
			AbstractPropertySemantics implements IPropertyResolutionSemantics {
		
		private final IIdentificationScheme fIdScheme = new IdAttributeIdentificationScheme(
				"rccSymbol");
		
		@SuppressWarnings("unchecked")
		public EObject resolve(ParseTreeNode parseTreeNode,
				Object actual, Object value, IModelCreatingContext context,
				ReferenceBinding binding) throws ModelCreatingException, UnresolveableReferenceErrorException {
			Position range = parseTreeNode.getPosition();
			String id = context.getText().substring(range.getOffset() + 1,
					range.getOffset() + range.getLength() - 1);
			EObject resolution = null;
			try {
				resolution = resolve(fIdScheme, id, null, binding.getProperty()
						.getEType(), (Iterator)context.getResource().getAllContents());
			} catch (AmbiguousReferenceException ex) {
				context.addError(new Error(parseTreeNode.getPosition(), "Reference is ambiguous"));				
			}
			if (resolution != null) {
				return resolution;
			} else {
				new UnresolvableReferenceError("Could not resolve " + id + ".", parseTreeNode).throwIt();
				return null;
			}
		}
	}
}

