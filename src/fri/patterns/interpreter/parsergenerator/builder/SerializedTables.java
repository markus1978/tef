package fri.patterns.interpreter.parsergenerator.builder;

import java.io.File;
import fri.patterns.interpreter.parsergenerator.ParserTables;
import fri.patterns.interpreter.parsergenerator.parsertables.*;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;

/**
	Buffering ParserTables. SerializedParserTables will build the ParserTables from scratch
	only the first time. Every following call will load the serialized ParserTables
	from filesystem.
	<p>
	The time to build parser tables from scratch is less or equal to deserializing it
	for little syntaxes. Use it only for big tables (e.g. for Java syntax).
	<p>
	Mind that this factory accepts a parser syntax, NOT a syntax where parser and lexer rules were mixed!
	<p>
	Example (with syntax input from a file):
	<pre>
		File syntaxInput = ...;
		ParserTables tables = new SerializedTables().get(syntaxInput);
	</pre>
	or (syntax input from a Reader):
	<pre>
		Reader syntaxInput = ...;
		ParserTables tables = new SerializedTables().get(syntaxInput, "MyTables.ser");
	</pre>

	@author (c) 2000, Fritz Ritzberger
*/

public class SerializedTables extends SerializedObject
{
	private boolean PRODUCTION;	// setting this to false in constructor will prevent the ParserTables from being serialized

	/** Create a ParserTables factory that buffers created parser tables. */
	public SerializedTables()	{
		this(true);
	}
	
	/** Create a ParserTables factory that buffers tables once created. @param production when false the tables will not be buffered. */
	public SerializedTables(boolean production)	{
		this.PRODUCTION = production;
	}

	/**
		Creates parser tables for passed syntax input from scratch or loads serialized tables from filesystem.
		LALRParserTables.class wil be the type of created parser tables.
		@param syntaxInput the Parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@return deserialized ParserTables, or one built from scratch that gets written to filesystem.
	*/
	public AbstractParserTables get(Object syntaxInput)
		throws Exception
	{
		return get(syntaxInput, null);
	}

	/**
		Creates parser tables for passed syntax input from scratch or loads serialized tables from filesystem.
		LALRParserTables.class will be the type of created parser tables.
		@param syntaxInput the Parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@param baseName name of serialization file, can be null when syntaxInput is a File
		@return deserialized ParserTables, or one built from scratch that gets written to filesystem.
	*/
	public AbstractParserTables get(Object syntaxInput, String baseName)
		throws Exception
	{
		return get(null, syntaxInput, baseName);
	}

	/**
		Creates parser tables for passed syntax input from scratch or loads serialized tables from filesystem.
		@param parserType the ParserTables class, e.g. SLRParserTables.class.
		@param syntaxInput the Parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@param baseName name of serialization file, can be null when syntaxInput is a File
		@return deserialized ParserTables, or one built from scratch that gets written to filesystem.
	*/
	public AbstractParserTables get(Class parserType, Object syntaxInput, String baseName)
		throws Exception
	{
		AbstractParserTables parserTables = readParserTables(syntaxInput, baseName);
		if (parserTables == null)
			parserTables = buildAndStoreParserTables(parserType, null, syntaxInput, baseName);
		return parserTables;
	}
	
	private String ensureFileName(Object syntaxInput, String baseName)	{
		if (baseName == null)
			baseName = baseNameFromSyntax(syntaxInput);
		return baseName+"ParserTables.ser";
	}
	
	public AbstractParserTables readParserTables(Object syntaxInput, String baseName)	{
		if (PRODUCTION)
			return (AbstractParserTables) read(ensureFileName(syntaxInput, baseName));
		return null;
	}

	public AbstractParserTables buildAndStoreParserTables(Class parserType, Syntax parserSyntax, Object syntaxInput, String baseName)
		throws Exception
	{
		if (parserType == null)
			parserType = LALRParserTables.class;

		Syntax syntax = parserSyntax == null ? toSyntax(syntaxInput) : parserSyntax;

		fri.util.TimeStopper ts = new fri.util.TimeStopper();
		AbstractParserTables parserTables = AbstractParserTables.construct(parserType, syntax);
		System.err.println("ParserTables scratch construction took "+ts.getTimeMillis()+" millis");

		if (PRODUCTION)
			write(ensureFileName(syntaxInput, baseName), parserTables);
		
		return parserTables;
	}



	/** Test main. Building serialized ParserTables takes 170, building from scratch takes 59 millis !!! */
	public static void main(String [] args)	{
		try	{
			File syntaxFile = new File("fri/patterns/interpreter/parsergenerator/syntax/builder/examples/SyntaxBuilder.syntax");
			Syntax syntax = new fri.patterns.interpreter.parsergenerator.syntax.builder.SyntaxBuilder(syntaxFile).getParserSyntax();
			fri.util.TimeStopper ts = new fri.util.TimeStopper();
			ParserTables parserTables = new SerializedTables().get(syntax, "SyntaxBuilder");
			System.err.println("ParserTables were built in "+ts.getTimeMillis()+" millis");
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

}
