package fri.patterns.interpreter.parsergenerator.builder;

import java.util.List;
import fri.util.TimeStopper;
import fri.patterns.interpreter.parsergenerator.Lexer;
import fri.patterns.interpreter.parsergenerator.syntax.*;
import fri.patterns.interpreter.parsergenerator.syntax.builder.SyntaxSeparation;
import fri.patterns.interpreter.parsergenerator.lexer.*;

/**
	Buffering Lexers. SerializedLexer will build the Lexer from scratch
	only the first time. Every following call will load the serialized Lexer
	from filesystem.
	<p>
	The time to build a lexer from scratch is equal to deserializing it
	in most cases. So a standalone lexer can be built without this class.
	When needed for a Parser, use the SerializedParser factory!
	<p>
	This factory will separate the passed syntax into parser and lexer syntax if
	token and ignored symbol Lists are null. So take care to use "token" and "ignored"
	rules within syntax to achieve the desired result!
	<p>
	Example (syntax input from a file):
	<pre>
	File ebnfFile = ...;
	Lexer lexer = new SerializedLexer().get(ebnfFile);
	</pre>
	or (syntax input from a Reader, must pass a filename):
	<pre>
	Reader ebnfReader = ...;
	Lexer lexer = new SerializedLexer().get(ebnfReader, "MyLexer.ser");
	</pre>
	
	@author (c) 2002, Fritz Ritzberger
*/

public class SerializedLexer extends SerializedObject
{
	private SyntaxSeparation separation;
	protected boolean PRODUCTION;	// setting this to false in constructor will prevent the Lexer from being serialized

	/** Create a Lexer factory that caches built Lexers. */
	public SerializedLexer()	{
		this(true);
	}
	
	/** Create a Lexer factory that caches built Lexers. @param production when false the Lexer will not be serialized. */
	public SerializedLexer(boolean production)	{
		this.PRODUCTION = production;
	}

	/**
		Builds the Lexer from scratch if not found in filesystem, else loads the serialized Lexer.
		@param syntaxInput the Lexer syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@return deserialized Lexer, or one built from scratch that gets written to filesystem.
	*/
	public Lexer get(Object syntaxInput)
		throws Exception
	{
		return get(syntaxInput, null);
	}

	/**
		Builds the Lexer from scratch if not found in filesystem, else loads the serialized Lexer.
		@param syntaxInput the Lexer syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@param baseName name of serialization file, can be null when syntaxInput is a File
		@return deserialized Lexer, or one built from scratch that gets written to filesystem.
	*/
	public Lexer get(Object syntaxInput, String baseName)
		throws Exception
	{
		return get(syntaxInput, baseName, null, null);
	}
	
	/**
		Builds the Lexer from scratch if not found in filesystem, else loads the serialized Lexer.
		@param syntaxInput the Lexer syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@param baseName name of serialization file, can be null when syntaxInput is a File
		@param tokenSymbols the token symbols when used by a prebuilt Parser
		@param ignoredSymbols the ignored symbols when used by a prebuilt Parser
		@return deserialized Lexer, or one built from scratch that gets written to filesystem.
	*/
	public Lexer get(Object syntaxInput, String baseName, List tokenSymbols, List ignoredSymbols)
		throws Exception
	{
		Lexer lexer = readLexer(syntaxInput, baseName);
		if (lexer == null)
			lexer = buildAndStoreLexer(syntaxInput, baseName, tokenSymbols, ignoredSymbols);
		return lexer;
	}

	private String ensureFileName(Object syntaxInput, String baseName)	{
		if (baseName == null)
			baseName = baseNameFromSyntax(syntaxInput);
		return baseName+"Lexer.ser";
	}

	/**
	 * Tries to read the lexer from a serialized file. One of the two arguments must be non-null.
	 * @param syntaxInput the lexer syntax input to retrieve a default name when it is a File
	 * @param baseName if baseName is "Xml", the file "XmlLexer.ser" will be read, can be null
	 */
	public Lexer readLexer(Object syntaxInput, String baseName)	{
		if (PRODUCTION)
			return (Lexer) read(ensureFileName(syntaxInput, baseName));
		return null;
	}

	/**
	 * Builds a lexer from passed syntax and stores it to a File (when PRODUCTION is true, this is default).
	 * @param syntaxInput the lexer syntax input
	 * @param baseName a file basename, if "Xml", the file "XmlLexer.ser" will be written
	 */
	public Lexer buildAndStoreLexer(Object syntaxInput, String baseName, List tokenSymbols, List ignoredSymbols)
		throws Exception
	{
		Syntax syntax = toSyntax(syntaxInput);
		
		if (tokenSymbols == null || ignoredSymbols == null)	{
			this.separation = newSyntaxSeparation(syntax);
			syntax = separation.getLexerSyntax();
			
			if (tokenSymbols == null)
				tokenSymbols = separation.getTokenSymbols();
			if (ignoredSymbols == null)
				ignoredSymbols = separation.getIgnoredSymbols();
		}
		// else: assume that syntaxInput is a prebuilt lexer Syntax and a list of ignored tokens
		
		TimeStopper ts = new TimeStopper();
		LexerBuilder builder = newLexerBuilder(syntax, ignoredSymbols);
		Lexer lexer = builder.getLexer();
		lexer.setTerminals(tokenSymbols);
		System.err.println("Lexer scratch construction took "+ts.getTimeMillis()+" millis");
		
		if (PRODUCTION)
			write(ensureFileName(syntaxInput, baseName), lexer);

		return lexer;
	}
	
	/** To be overridden when a modified SyntaxSeparation is needed. */
	protected SyntaxSeparation newSyntaxSeparation(Syntax syntax)
		throws SyntaxException
	{
		return new SyntaxSeparation(syntax);
	}
	
	/** To be overridden when a modified LexerBuilder is needed. */
	protected LexerBuilder newLexerBuilder(Syntax syntax, List ignoredSymbols)
		throws LexerException, SyntaxException
	{
		return new LexerBuilder(syntax, ignoredSymbols);
	}
	
	/**
		If the lexer was built from scratch, the SyntaxSeparation object returned
		will not be null and can be used to retrieve the parser syntax, else
		null is returned, as the separation is not available in serialized Lexer.
	*/
	public SyntaxSeparation getSyntaxSeparation()	{
		return separation;
	}



	/** Test main. Building serialized Lexer takes 330, building from scratch takes 130 millis. */
	public static void main(String [] args)	{
		try	{
			TimeStopper ts = new TimeStopper();
			Lexer lexer = new SerializedLexer().get(StandardLexerRules.lexerSyntax, "SyntaxBuilder");
			System.err.println("Lexer was built in "+ts.getTimeMillis()+" millis");
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

}
