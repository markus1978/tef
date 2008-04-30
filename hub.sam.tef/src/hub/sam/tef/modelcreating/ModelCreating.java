package hub.sam.tef.modelcreating;

import hub.sam.tef.Utilities;
import hub.sam.tef.semantics.AbstractError;
import hub.sam.tef.semantics.Error;
import hub.sam.tef.semantics.ISemanticsProvider;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslException;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.jface.text.Position;
import org.osgi.framework.Bundle;

public class ModelCreating {
	
	/**
	 * Creates a model for a text based on a given syntax and static semantics. The
	 * syntax is given as a syntax file.
	 * 
	 * @param text
	 *            is the text that the model is to be created from.
	 * @param bundle
	 *            is the bundle that contains the syntax file.
	 * @param syntaxPath
	 *            is a bundle relative path to the syntax file.
	 * @param packages
	 *            are the meta-model packages that the syntax maps to.
	 * @param semanticsProvider
	 *            is the static semantics of the notation. Use null for a
	 *            default semantics.
	 * @return the root element of the created model.
	 * @throws ModelCreatingException
	 *             if anything goes wrong creating the model.
	 * @throws TslException
	 *             if anything goes wrong reading the syntax.
	 */
	public static EObject createModelFromText(String text, 
			Bundle bundle, String syntaxPath, EPackage[] packages,
			ISemanticsProvider semanticsProvider)
			throws ModelCreatingException, TslException {
		Syntax syntax = Utilities.loadSyntaxDescription(
				bundle,
				syntaxPath, 
				packages);
		return createModelFromText(text, syntax, packages, semanticsProvider);
	}
	
	/**
	 * Creates a model for a text based on a given syntax and static semantics.
	 * 
	 * @param text
	 *            is the text that the model is to be created from.
	 * @param syntax
	 *            is the syntax for the text.
	 * @param packages
	 *            are the meta-model packages that the syntax maps to.
	 * @param semanticsProvider
	 *            is the static semantics of the notation. Use null for a
	 *            default semantics.
	 * @return the root element of the created model.
	 * @throws ModelCreatingException
	 *             if anything goes wrong.
	 */
	public static EObject createModelFromText(String text, Syntax syntax, 
			EPackage[] packages, ISemanticsProvider semanticsProvider)
			throws ModelCreatingException {
		
		IModelCreatingContext context = new ModelCreatingContext(packages, 
				semanticsProvider, new ResourceImpl(), text);
		return createModelFromText(context, syntax);
	}

	/**
	 * Creates a model for a text based on a given syntax and creating context
	 * 
	 * @param context
	 *            is the model creating context that determines the text, the
	 *            semantics, and meta-model packages. See
	 *            {@link IModelCreatingContext} for more details.
	 * 
	 * @param syntax
	 *            is the syntax for the text.
	 * 
	 * @return the root element of the created model.
	 * @throws ModelCreatingException
	 *             if anything goes wrong.
	 */
	public static EObject createModelFromText(IModelCreatingContext context, Syntax syntax) 
			throws ModelCreatingException {		
		String text = context.getText();
		ParserSemantics parserSemantics = new ParserSemantics(syntax);
		Parser parser = new Parser(syntax);
		boolean parseOk = parser.parse(text, parserSemantics);
		
		EObject creationResult = null;
		if (!parseOk) {			
			int lastOffset = parser.getLastOffset();
			if (lastOffset == -1) {
				context.addError(new Error(
						new Position(0, text.length()), "unexpected parser error"));
			} else {
				context.addError(new ParserError(lastOffset));
			}
		} else {				
			ParseTreeNode parseResult = parserSemantics.getResult();
			
			creationResult = (EObject)parseResult.createModel(context, null);
			context.addCreatedObject(creationResult);					
			
			ResolutionState state = new ResolutionState(creationResult);
			parseResult.resolveModel(context, state);
			context.executeResolutions();
			
			new ModelChecker().checkModel(creationResult, context);
		}
		
		Collection<AbstractError> errors = context.getErrors();
		if (errors.size() > 0) {
			throw new ModelCreatingException(errors.iterator().next().getMessage());
		} else {
			return creationResult;
		}
	}
}
