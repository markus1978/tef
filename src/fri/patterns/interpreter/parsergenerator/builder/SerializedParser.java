package fri.patterns.interpreter.parsergenerator.builder;

import java.io.File;
import fri.patterns.interpreter.parsergenerator.*;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;

/**
	This class is definitely the shortest way to construct a Parser (with Lexer) for a Syntax.
	It uses all serialization utils in this package to quickly build a parsing environment.
	This factory accepts a syntax where parser and lexer rules were mixed.
	<p>
	Example (syntax input from a file):
	<pre>
	File ebnfFile = new File("MySyntax.syntax");
	Parser parser = new SerializedParser().get(ebnfFile);
	</pre>
	or (syntax input from a Reader, must pass a filename):
	<pre>
	Reader ebnfReader = new InputStreamReader(MySyntaxSemantic.class.getResourceAsStream("MySyntax.syntax"));
	Parser parser = new SerializedParser().get(ebnfReader, "MySyntax");
	</pre>
	
	@author (c) 2002, Fritz Ritzberger
*/

public class SerializedParser extends SerializedObject
{
	/** The suffix for serialized Parser files. */
	public static final String PARSERFILE_SUFFIX = "Parser.ser";
	protected boolean PRODUCTION;	// setting this to false in constructor will prevent the parsing environment from being serialized

	/** Create a Parser factory that caches built Lexers. */
	public SerializedParser()	{
		this(true);
	}
	
	/** Create a Parser factory that caches built Lexers. @param production when false the Parser will not be serialized. */
	public SerializedParser(boolean production)	{
		this.PRODUCTION = production;
	}

	/**
		Builds the Parser from scratch if not found its parts in filesystem, else loads all serialized parts.
		@param syntaxInput the mixed lexer/parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@return Parser, built from scratch or loaded from filesystem.
	*/
	public Parser get(Object syntaxInput)
		throws Exception
	{
		return get(null, syntaxInput);
	}

	/**
		Builds the Parser from scratch if not found its parts in filesystem, else loads all serialized parts.
		@param syntaxInput the mixed lexer/parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@param baseName basename for serialization, can be null
		@return Parser, built from scratch or loaded from filesystem.
	*/
	public Parser get(Object syntaxInput, String baseName)
		throws Exception
	{
		return get(null, syntaxInput, baseName);
	}

	/**
		Builds the Parser from scratch if not found its parts in filesystem, else loads all serialized parts.
		@param parserType the class of ParserTables to create for the syntax (LALRParserTables.class is default).
		@param syntaxInput the mixed lexer/parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@return Parser, built from scratch or loaded from filesystem.
	*/
	public Parser get(Class parserType, Object syntaxInput)
		throws Exception
	{
		return get(parserType, syntaxInput, null);
	}

	/**
		Builds the parsing environment from scratch if not found its parts in filesystem, else loads all serialized parts.
		@param parserType the class of ParserTables to create for the syntax (LALRParserTables.class is default).
		@param syntaxInput the mixed lexer/parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@param baseName basename for serialization, can be null
		@return Parser, built from scratch or loaded from filesystem.
	*/
	public Parser get(Class parserType, Object syntaxInput, String baseName)
		throws Exception
	{
		fri.util.TimeStopper ts = new fri.util.TimeStopper();
		
		Parser parser = PRODUCTION ? (Parser) read(ensureFileName(syntaxInput, baseName)) : null;
		if (parser == null)	{
			SerializedLexer lexerFactory = newSerializedLexer();
			lexerFactory.PRODUCTION = false;	// do not store this lexer, it will be stored with parser
			Lexer lexer = lexerFactory.buildAndStoreLexer(syntaxInput, baseName, null, null);	// null: forces syntax separation
			Syntax parserSyntax = lexerFactory.getSyntaxSeparation().getParserSyntax();
			SerializedTables tablesFactory = new SerializedTables(false);	// do not store this tables, it will be stored with parser
			ParserTables tables = tablesFactory.buildAndStoreParserTables(parserType, parserSyntax, syntaxInput, baseName);
			parser = new Parser(tables);
			parser.setLexer(lexer);
			
			if (PRODUCTION)
				write(ensureFileName(syntaxInput, baseName), parser);
		}

		System.err.println("Parser construction took "+ts.getTimeMillis()+" millis");
		return parser;
	}

	/** To be overridden when a modified SerializedLexer is needed. */
	protected SerializedLexer newSerializedLexer()
		throws Exception
	{
		return new SerializedLexer(false);
	}
	
	private String ensureFileName(Object syntaxInput, String baseName)	{
		if (baseName == null)
			baseName = baseNameFromSyntax(syntaxInput);
		return baseName+PARSERFILE_SUFFIX;
	}



	/** Test main. Building serialized Java Parser takes 740, building from scratch takes 4000 millis. */
	public static void main(String [] args)	{
		try	{
			File ebnfFile = new File("fri/patterns/interpreter/parsergenerator/syntax/builder/examples/SyntaxBuilder.syntax");
			File fileToParse = new File("fri/patterns/interpreter/parsergenerator/syntax/builder/examples/SimpleSyntax.syntax");

			fri.util.TimeStopper ts = new fri.util.TimeStopper();
			SerializedParser parserBuilder = new SerializedParser();
			Parser parser = parserBuilder.get(null, ebnfFile, "SyntaxBuilder");
			Lexer lexer = parser.getLexer();
			System.err.println("Parser was built in "+ts.getTimeMillis()+" millis");
			lexer.setDebug(true);

			lexer.setInput(fileToParse);
			boolean ok = parser.parse(lexer);
			System.err.println("Parsing result is "+ok);
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

}
