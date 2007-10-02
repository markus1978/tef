package fri.patterns.interpreter.parsergenerator.builder;

import java.io.File;
import java.lang.reflect.*;
import fri.patterns.interpreter.parsergenerator.parsertables.*;
import fri.patterns.interpreter.parsergenerator.syntax.Syntax;

/**
	This class is deprecated in favor of serialization.
	<p>
	CompiledTables buffers parser tables by generating source and compiling
	that source. This lasts very long at first time, but is faster than
	serialization for every subsequent call. The class will be posted in
	current directory (has no package). The source gets removed after successful
	compilation. The Sun compiler must be in package path, which is normally in
	<i>$JAVA_HOME/lib/tools.jar</i>.
	<p>
	Building compiled Java ParserTables takes 1600, building from scratch takes 6000 millis.
	CompiledTables seem to be slower than SerializedParser!
	<p>
	An alternative to compiled tables is generating the parser tables source
	with <i>SourceGenerator</i> and integrating that source into project sources.
	This avoids the dynamically created class in working directory and the neccessity
	to have javac in CLASSPATH at runtime.
	<pre>
		ParserTables tables = new CompiledTables().get(syntaxInput, "MyParserTables");
	</pre>
	
	@deprecated in favor of serialization
*/

public class CompiledTables
{
	/** The suffix for compiled ParserTables files. */
	public static final String CLASSFILE_SUFFIX = "ParserTables";
	private boolean DEVELOPMENT = false;	// setting this to true in constructor will prevent the tables from being compiled

	/** Creates a parser tables factory that uses compiled tables as buffer. */
	public CompiledTables()	{
		this(false);
	}
	
	/** Creates a parser tables factory that uses compiled tables as buffer. @param development when true tables will NOT be compiled. */
	public CompiledTables(boolean development)	{
		this.DEVELOPMENT = development;
	}


	/**
		Builds the ParserTables from scratch if not found as class in CLASSPATH, else loads that class.
		LALRParserTables.class wil be the type of created parser tables.
		@param syntaxInput the Parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@return ParserTables object, or object built from scratch that gets compiled into current directory.
	*/
	public AbstractParserTables get(Object syntaxInput)
		throws Exception
	{
		return get(syntaxInput, null);
	}

	/**
		Builds the ParserTables from scratch if not found as class in CLASSPATH, else loads that class.
		LALRParserTables.class wil be the type of created parser tables.
		@param syntaxInput the Parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@param className name of target class of ParserTables, without package path, without .java extension.
		@return ParserTables object, or object built from scratch that gets compiled into current directory.
	*/
	public AbstractParserTables get(Object syntaxInput, String className)
		throws Exception
	{
		return get(LALRParserTables.class, syntaxInput, className);
	}

	/**
		Builds the ParserTables from scratch if not found as class in CLASSPATH, else loads that class.
		LALRParserTables.class wil be the type of created parser tables.
		@param syntaxInput the Parser syntax as File, InputStream, List of Lists, String [][] or Syntax.
		@param className name of target class of ParserTables, without package path, without .java extension.
		@param parserType class of ParserTables to create, e.g. LALRParserTables.class
		@return ParserTables object, or object built from scratch that gets compiled into current directory.
	*/
	public AbstractParserTables get(Class parserType, Object syntaxInput, String className)
		throws Exception
	{
		if (className == null)
			className = SerializedObject.baseNameFromSyntax(syntaxInput);
		
		className = className+CLASSFILE_SUFFIX;
		
		AbstractParserTables parserTables = null;
		
		if (DEVELOPMENT == false)	{
			try	{
				Class cls = Class.forName(className);
				parserTables = AbstractParserTables.construct(cls, null);
			}
			catch (Exception e)	{	// class is not present
				System.err.println("Could not find compiled parser tables for classname "+className+" in "+System.getProperty("java.class.path")+" - trying scratch build: "+e.toString());
			}
		}
		
		if (parserTables == null)	{
			fri.util.TimeStopper ts = new fri.util.TimeStopper();

			Syntax grammar = SerializedObject.toSyntax(syntaxInput);
			parserTables = AbstractParserTables.construct(parserType, grammar);
			if (DEVELOPMENT == false)	{
				String javaFile = parserTables.toSourceFile(className);
				int ret = compile(javaFile);
				new File(javaFile).delete();	// source file no more needed
				System.err.println("ParserTables scratch compilation took "+ts.getTimeMillis()+" millis, return was "+ret);
			}
		}
		
		return parserTables;
	}


	/**
		Aufruf des Sun-Compilers. Dazu muss tools.jar im CLASSPATH sein!
		@return return-code von "new com.sun.tools.javac.Main().compile(javaFile)".
	*/
	protected int compile(String javaFile)	{
		try	{
			String javaCompiler = "com.sun.tools.javac.Main";
			System.err.println("compiling source: "+javaCompiler+" "+javaFile);

			Class cls = Class.forName(javaCompiler);
			Object compiler = cls.newInstance();
			Method method = cls.getMethod("compile", new Class[] { String[].class });
			String [] args =	new String [] {
					"-classpath",
					"."+System.getProperty("path.separator")+System.getProperty("java.class.path"),
					javaFile
			};
			Object o = method.invoke(compiler, new Object [] { args });
			int ret = ((Integer)o).intValue();

			System.err.println("javac returns "+ret);
			return ret;
		}
		catch (Exception e)	{
			e.printStackTrace();
			System.err.println("com.sun.tools.javac.Main() not present. Please put $JAVA_HOME/lib/tools.jar into CLASSPATH for quick loading next time.");
		}
		return -1;
	}



	/** Test main. Building compiled ParserTables takes 1600, building from scratch takes 6000 millis. */
	public static void main(String [] args)	{
		try	{
			File syntaxFile = new File("fri/patterns/interpreter/parsergenerator/syntax/builder/examples/SyntaxBuilder.syntax");
			Syntax syntax = new fri.patterns.interpreter.parsergenerator.syntax.builder.SyntaxBuilder(syntaxFile).getParserSyntax();
			fri.util.TimeStopper ts = new fri.util.TimeStopper();
			AbstractParserTables parserTables = new CompiledTables().get(syntax, "SyntaxBuilderParserTables");
			System.err.println("ParserTables were built in "+ts.getTimeMillis()+" millis");
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

}
