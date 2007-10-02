package fri.patterns.interpreter.parsergenerator.util;

import java.io.*;
import java.util.*;
import fri.patterns.interpreter.parsergenerator.Token;
import fri.patterns.interpreter.parsergenerator.parsertables.*;
import fri.patterns.interpreter.parsergenerator.syntax.*;
import fri.patterns.interpreter.parsergenerator.syntax.builder.SyntaxBuilder;

/**
	Java source generator. Following code generations are supported:
	<ul>
		<li>SemanticSkeleton, code base for a Semantic-implementation of big syntaxes.</li>
		<li>Turn ParserTables (built from a Syntax) into compileable Java-code (for faster loading).</li>
		<li>Turn a Syntax object into compileable Java code (for faster loading).</li>
	</ul>
	<pre>
	SYNTAX: java fri.patterns.interpreter.parsergenerator.util.SourceGenerator [semantic|LALR|SLR|LR] file.syntax [file.syntax ...]
			LALR|SLR|LR: Generates ParserTable implementation(s) of passed grammar file(s).
			       else: Generates Syntax implementation(s) of passed grammar file(s).
	CAUTION: Files MUST have relative pathes!
	</pre>

	@author (c) 2002, Fritz Ritzberger
*/

public abstract class SourceGenerator
{
	/**
		Generates a semantic skeleton implementation for a given syntax.
		@param input syntax the semantic is meant for
		@param className basename of class to generate, semantic will be named className+"Semantic.java"
		@param pkgName package-name of class to generate
	*/
	public static void generateSemanticSkeleton(Syntax syntax, String className, String pkgName)
		throws Exception
	{
		String fileName = className+"Semantic.java";

		String dirName = pkgName != null && pkgName.length() > 0
				? pkgName.replace('.', File.separatorChar)
				: System.getProperty("user.dir");

		File out = new File(dirName, fileName);
				
		if (out.exists())	{
			throw new IllegalStateException("Will not overwrite "+out.getAbsolutePath()+". Please check the file for implementation and remove it!");
		}
		else	{
			new File(dirName).mkdirs();	// ensure directory exists
			FileWriter fw = new FileWriter(out);
			new SemanticSkeletonGenerator(syntax, className, pkgName, fw);
			System.err.println("Wrote semantic skeleton to file: "+out);
		}
	}


	/**
		Generates Java code from parser tables. makes the output filename and calls <i>parserTables.toSourceFile()</i> then.
		@param parserTables ParserTables for which the source should stand
		@param className basename of class to generate
		@param pkgName name of package of class to generate, can be null
	*/
	public static void generateParserTable(AbstractParserTables parserTables, String className, String pkgName)
		throws Exception
	{
		String fullName = (pkgName != null ? pkgName+"." : "")+className;
		parserTables.toSourceFile(fullName);
	}


	/**
		Generates a Java implementation from the passed Syntax object.
		@param syntax Syntax to convert to Java code.
		@param className basename of class to generate
		@param pkgName name of package of class to generate
	*/
	public static void generateSyntaxImpl(
		Syntax syntax,
		String className,
		String pkgName,
		List initialNonterminals)
		throws IOException
	{
		String origClsName = className;
		className = className+"Syntax";
		String fileName = (pkgName != null ? pkgName+"."+className : className);
		fileName = fileName.replace('.', File.separatorChar)+".java";
		Writer f = new BufferedWriter(new FileWriter(fileName));
		
		if (pkgName != null)
			fwrite("package "+pkgName+";\n\n", f);

		fwrite("/**\n", f);
		fwrite(" * DO NOT EDIT - Syntax generated from "+origClsName+".syntax\n", f);
		fwrite(" * at "+new Date()+"\n", f);
		fwrite(" * by fri.patterns.interpreter.parsergenerator.util.SourceGenerator.\n", f);
		fwrite(" */\n\n", f);

		fwrite("import fri.patterns.interpreter.parsergenerator.syntax.*;\n\n", f);
		fwrite("public final class "+className+" extends Syntax\n", f);	// class definition
		fwrite("{\n", f);
		
		for (int i = 0; i < initialNonterminals.size(); i++)	// define String constants for every nonterminal
			fwrite("	public static final String "+initialNonterminals.get(i)+" = \""+initialNonterminals.get(i)+"\";\n", f);
		fwrite("\n", f);
		
		fwrite("	public "+className+"()	{\n", f);	// constructor
		fwrite("		super("+syntax.size()+");\n\n", f);
		fwrite("		Rule rule;\n", f);

		for (int i = 0; i < syntax.size(); i++)	{
			Rule rule = syntax.getRule(i);
			String nt = rule.getNonterminal();
			if (initialNonterminals.indexOf(nt) < 0)	// have not been defined as String constant
				nt = "\""+nt+"\"";
			fwrite("\n		rule = new Rule("+nt+", "+rule.rightSize()+");	// "+i+"\n", f);
			
			for (int j = 0; j < rule.rightSize(); j++)	{
				String rightSymbol = rule.getRightSymbol(j);
				if (Token.isTerminal(rightSymbol))
					fwrite("		rule.addRightSymbol(\""+SyntaxUtil.maskQuoteAndBackslash(rightSymbol)+"\");\n", f);
				else
					if (initialNonterminals.indexOf(rightSymbol) >= 0)	// have been defined as String constants
						fwrite("		rule.addRightSymbol("+rightSymbol+");\n", f);
					else
						fwrite("		rule.addRightSymbol(\""+rightSymbol+"\");\n", f);
			}
			fwrite("		addRule(rule);\n", f);
		}
		fwrite("	}\n", f);
		fwrite("}\n", f);

		f.close();
		System.err.println("Generated Syntax source file: "+fileName);
	}

	private static void fwrite(String line, Writer f)
		throws IOException
	{
		f.write(line, 0, line.length());
	}



	private SourceGenerator()	{}	// do not instantiate



	/** Source generator main. Writes syntax to stderr when launched with no arguments or -h. */
	public static void main(String [] args)	{
		if (args.length <= 0 || args[0].startsWith("-h"))	{
			System.err.println("SYNTAX: java "+SourceGenerator.class.getName()+" [semantic|LALR|SLR|LR] file.syntax [file.syntax ...]");
			System.err.println("	LALR|SLR|LR: Generates ParserTable implementation(s) of passed grammar file(s).");
			System.err.println("	else: Generates syntax implementation(s) of passed grammar file(s).");
			System.err.println("	CAUTION: Files MUST have relative pathes!");
			System.exit(1);
		}
		else	{
			String type = args[0].equals("SLR") || args[0].equals("LR") || args[0].equals("LALR") ? args[0] : null;
			boolean semantic = args[0].equals("semantic");
			int i = (type != null || semantic) ? 1 : 0;
			
			for (; i < args.length; i++)	{
				File f = new File(args[i]);
				
				if (f.exists() == false || f.isFile() == false || f.canRead() == false)	{
					System.err.println("ERROR: Can not open syntax specification: "+f);
				}
				else	{
					if (f.getAbsolutePath().equals(f.getPath()))	{
						throw new IllegalArgumentException("File MUST have relative path (to make package name): "+f);
					}
					
					String clsName = f.getName();	// make class name
					int idx = clsName.indexOf(".");	// cut extension
					if (idx > 0)
						clsName = clsName.substring(0, idx);
					
					String pkgName = f.getParent();	// make package name
					if (pkgName != null)	{
						if (pkgName.endsWith(File.separator))
							pkgName = pkgName.substring(0, pkgName.length() - 1);
						pkgName = pkgName.replace(File.separatorChar, '.');
					}
					
					try	{
						SyntaxBuilder builder = new SyntaxBuilder(new File(args[i]));
						if (semantic)	{
							Syntax syntax = builder.getParserSyntax();
							generateSemanticSkeleton(syntax, clsName, pkgName);
						}
						else
						if (type != null)	{
							Syntax syntax = builder.getParserSyntax();
							AbstractParserTables pt = type.equals("SLR")
								? new SLRParserTables(syntax)
								: type.equals("LR")
									? new LRParserTables(syntax)
									: new LALRParserTables(syntax);
							generateParserTable(pt, clsName, pkgName);
						}
						else	{
							Syntax syntax = builder.getSyntax();
							generateSyntaxImpl(syntax, clsName, pkgName, builder.getInitialNonterminals());
						}
					}
					catch (Exception e)	{
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
