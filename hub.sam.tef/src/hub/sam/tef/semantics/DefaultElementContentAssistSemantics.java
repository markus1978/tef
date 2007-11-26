package hub.sam.tef.semantics;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.layout.BlockLayout;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.SimpleRule;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class DefaultElementContentAssistSemantics implements IContentAssistSemantics {
	private final ElementBinding fElementBinding;

	public DefaultElementContentAssistSemantics(
			ElementBinding elementBinding) {
		super();
		fElementBinding = elementBinding;
	}

	@Override
	public Collection<ContentAssistProposal> createProposals(
			ContentAssistContext context) {
		NonTerminal nonTerminal = ((SimpleRule)fElementBinding.eContainer()).getLhs();
		EClass eClass = fElementBinding.getMetaclass();
		try {
			EObject representative = instantiate(eClass, context);
			PrettyPrinter printer = new PrettyPrinter(context.getEditor().getSyntax(), 
					context.getEditor().getSemanticsProvider());
			printer.setLayout(new BlockLayout()); // TODO
			PrettyPrintState state = new PrettyPrintState(representative);
			printer.print(nonTerminal, state);
			String proposedString = state.getContent();
			System.out.print(proposedString);
		} catch(ModelCreatingException ex) {
			// TODO produce warning
			ex.printStackTrace();
		}
		return Collections.emptyList();
	}	
	
	/**
	 * Creates an instance of the given meta class. 
	 * 
	 * @param metaClass
	 *            is the meta class, a class with the same name must be
	 *            contained in on of the meta model packages in given context.
	 * @return the created model element.
	 * @throws ModelCreatingException,
	 *             if the meta class is not contained in the meta model packages
	 *             of this context.
	 */
	private EObject instantiate(EClass metaClass, ContentAssistContext context) throws ModelCreatingException {
		loop: for (EPackage ePackage: context.getEditor().getMetaModelPackages()) {
			EClassifier classifier = null;
			if ((classifier = ePackage.getEClassifier(metaClass.getName())) != null) {
				if (!(classifier instanceof EClass) || ((EClass)classifier).isAbstract()) {
					continue loop;
				}
				EObject result = ePackage.getEFactoryInstance().create(metaClass);				
				return result;
			}
		}
		throw new ModelCreatingException("Cannot instanitate " + metaClass.getName() + ".");
	}
}
