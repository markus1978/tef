/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2006-2008 Markus Scheidgen
 *                         Dirk Fahland
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

import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.rcc.Lexer;
import hub.sam.tef.rcc.ParserTables;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.lexer.LexerBuilder;
import hub.sam.tef.rcc.lexer.LexerException;
import hub.sam.tef.rcc.lexer.LexerImpl;
import hub.sam.tef.rcc.parsertables.LALRParserTables;
import hub.sam.tef.rcc.parsertables.ParserBuildException;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.rcc.syntax.SyntaxException;
import hub.sam.tef.rcc.syntax.builder.SyntaxSeparation;
import hub.sam.tef.tokens.TokenDescriptor;
import hub.sam.tef.tsl.TslException;
import hub.sam.tef.util.EObjectHelper;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Provides an interface to a RCC parser instance based on a tsl syntax. A
 * parser instance is used during the model creating process. The parser
 * instance can be reused for multiple texts for the same syntax (TODO).
 */
public class Parser {

	private final hub.sam.tef.tsl.Syntax fSyntax;
	private hub.sam.tef.rcc.Parser fParser = null;
	private ParserTables fParserTables = null;
	private Syntax fRccSyntax = null;
	private int lastOffset = -1;
	private Lexer lexer;
	private LastTokenListener lastTokenListener;

	public Parser(final hub.sam.tef.tsl.Syntax syntax) {
		super();
		fSyntax = syntax;
	}

	/**
	 * Creates the RCC parser instance, if it does not already exist, parser is
	 * extended with rules from extension points if these are used in the syntax
	 * definition
	 * 
	 * @throws SyntaxException
	 * @throws ParserBuildException
	 * @throws LexerException
	 * 
	 * @author Markus Scheidgen
	 * @author Dirk Fahland
	 */
	public void setup() throws SyntaxException, ParserBuildException,
			LexerException, TslException {
		Syntax rccSyntax = null;
		if (fRccSyntax == null) {
			fRccSyntax = fSyntax.getRccSyntax();

			// load user-defined tokens, if declared in the syntax
			for (final TokenDescriptor token : TokenDescriptor
					.getRegisteredTokenDescriptors()) {
				if (EObjectHelper.contains(fSyntax.getPattern(), token
						.getRccPattern())) {
					token.addRulesToARccSyntax(fRccSyntax);
				}
			}

			for (final PrimitiveTypeDescriptor primitiveTypeDescriptor : PrimitiveTypeDescriptor
					.getRegisteredTypeDescriptors()) {
				primitiveTypeDescriptor.addRulesToARccSyntax(fSyntax,
						fRccSyntax);
			}
		}
		rccSyntax = Syntax.copy(fRccSyntax);

		// TODO debug output
		// System.out.println(syntax.toString());

		final SyntaxSeparation separation = new SyntaxSeparation(rccSyntax);

		final LexerBuilder builder = new LexerBuilder(separation
				.getLexerSyntax(), separation.getIgnoredSymbols()); // build a
		lexer = builder.getLexer();

		if (fParserTables == null) {
			fParserTables = new LALRParserTables(separation.getParserSyntax());
		}

		fParser = createRccParser(fParserTables);
		fParser.setLexer(lexer);
		lastTokenListener = new LastTokenListener();
		lexer.addTokenListener(lastTokenListener);

		// fParser.setPrintStream(System.out);

		// this allows to catch any parser output, like error messages, etc.
		fParser.setPrintStream(new PrintStream(new OutputStream() {
			@Override
			public void write(final int b) throws IOException {
				// ignore
				// TODO extract reasonable error message from parser output
			}
		}));
	}

	/**
	 * Call-back method to allow subclasses work with customise RCC parsers.
	 */
	protected hub.sam.tef.rcc.Parser createRccParser(
			final ParserTables parserTables) {
		return new hub.sam.tef.rcc.Parser(parserTables);
	}

	/**
	 * @return the currently used RCC parser.
	 */
	public hub.sam.tef.rcc.Parser getRccParser() throws SyntaxException,
			ParserBuildException, LexerException, TslException {
		setup();
		return fParser;
	}

	/**
	 * Parses the given input (content) with the given semantics.
	 * 
	 * @param content
	 *            the input as string.
	 * @param semantic
	 *            is the semantic used during parsing. This semantics is
	 *            notified for each reduction.
	 * @return true, if the document could be parsed.
	 * @throws ModelCreatingException
	 *             , if the parser could not be created (bad syntax, lexer,
	 *             etc.).
	 */
	public final boolean parse(final String content,
			final ParserSemantics semantic) throws ModelCreatingException {
		try {
			setup();
		} catch (final SyntaxException e) {
			throw new ModelCreatingException(e);
		} catch (final ParserBuildException e) {
			throw new ModelCreatingException(e);
		} catch (final LexerException e) {
			throw new ModelCreatingException(e);
		} catch (final TslException e) {
			throw new ModelCreatingException(e);
		}
		semantic.setText(content);
		boolean ok = false;
		try {
			fParser.getLexer().setInput(content);
			ok = fParser.parse(semantic);
			lastOffset = ((LexerImpl) fParser.getLexer()).getOffset();
			return ok;
		} catch (final Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			fParser = null;
		}
	}

	/**
	 * Returns the last {@link Token} that has been used by the {@link Lexer}
	 * and hasn't been ignored.
	 * 
	 * @return {@link Token}
	 */
	public Token getLastToken() {
		return lastTokenListener.lastToken;
	}

	/**
	 * No matter whether the last parse attempt failed or not, this method
	 * returns the offset of the last character read from the input during the
	 * last parse.
	 */
	public final int getLastOffset() {
		return lastOffset;
	}

	/**
	 * Uses the syntax as string representation for the parser.
	 */
	@Override
	public final String toString() {
		return fSyntax.toString();
	}

	/**
	 * Saves the last token that hasn't been ignored. Used for error messages
	 * for example.
	 * 
	 * @author Fabian Fritz
	 * 
	 */
	class LastTokenListener implements Lexer.TokenListener {
		protected Token lastToken;

		/**
		 * Stores token if it hasn't been ignored.
		 */
		public void tokenReceived(final Token token, final boolean ignored) {
			if (!ignored) {
				lastToken = token;
			}
		}
	}
}