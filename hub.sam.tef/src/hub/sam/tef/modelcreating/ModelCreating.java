/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */

package hub.sam.tef.modelcreating;

import hub.sam.tef.Utilities;
import hub.sam.tef.rcc.Token;
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
	 * Creates a model for a text based on a given syntax and static semantics.
	 * The syntax is given as a syntax file.
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
	public static EObject createModelFromText(final String text,
			final Bundle bundle, final String syntaxPath,
			final EPackage[] packages,
			final ISemanticsProvider semanticsProvider)
			throws ModelCreatingException, TslException {
		final Syntax syntax = Utilities.loadSyntaxDescription(bundle,
				syntaxPath, packages);
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
	public static EObject createModelFromText(final String text,
			final Syntax syntax, final EPackage[] packages,
			final ISemanticsProvider semanticsProvider)
			throws ModelCreatingException {

		final IModelCreatingContext context = new ModelCreatingContext(
				packages, semanticsProvider, new ResourceImpl(), text);
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
	public static EObject createModelFromText(
			final IModelCreatingContext context, final Syntax syntax)
			throws ModelCreatingException {
		final String text = context.getText();
		final ParserSemantics parserSemantics = new ParserSemantics(syntax);
		final Parser parser = new Parser(syntax);
		final boolean parseOk = parser.parse(text, parserSemantics);

		EObject creationResult = null;
		if (!parseOk) {
			final int lastOffset = parser.getLastOffset();
			if (lastOffset == -1) {
				context.addError(new Error(new Position(0, text.length()),
						"Parser error (position unknown)"));
			} else {
				final Token lastToken = parser.getLastToken();
				if (lastToken != null) {
					context.addError(new ParserError(lastToken));
				} else {
					context.addError(new ParserError(lastOffset));
				}
			}
		} else {
			final ParseTreeNode parseResult = parserSemantics.getResult();

			creationResult = (EObject) parseResult.createModel(context, null);
			context.addCreatedObject(creationResult);
			
	    parseResult.postCreate(context);

			final ResolutionState state = new ResolutionState(creationResult);
			parseResult.resolveModel(context, state);
			context.executeResolutions();
			
			parseResult.postResolve(context);

			new ModelChecker().checkModel(creationResult, context);
			parseResult.looseParents();
		}

		final Collection<AbstractError> errors = context.getErrors();
		if (errors.size() > 0) {
			throw new ModelCreatingException(errors.iterator().next()
					.getMessage());
		} else {
			return creationResult;
		}
	}
}
