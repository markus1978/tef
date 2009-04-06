package hub.sam.tef.rcc.util;

import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.parsertables.AbstractParserTables;
import hub.sam.tef.rcc.parsertables.LALRParserTables;
import hub.sam.tef.rcc.parsertables.LRParserTables;
import hub.sam.tef.rcc.parsertables.SLRParserTables;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.rcc.syntax.SyntaxUtil;
import hub.sam.tef.rcc.syntax.builder.SyntaxBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
	@author (c) 2008, Dirk Fahland
*/

public abstract class SourceGenerator
{
	/**
		Generates a semantic skeleton implementation for a given syntax.
		@param input syntax the semantic is meant for
		@param className basename of class to generate, semantic will be named className+"Semantic.java"
		@param pkgName package-name of class to generate
		@param absoluteBaseDir the absolute base directory for the class files to be written
	*/
	public static void generateSemanticSkeleton(Syntax syntax, String className, String pkgName, String absoluteBaseDir)
		throws Exception
	{
		String fileName = className+"Semantic.java";

		String dirName;
		if (pkgName != null && pkgName.length() > 0) {
			dirName = "";
			if (absoluteBaseDir != null)
				dirName += absoluteBaseDir;
			dirName += pkgName.replace('.', File.separatorChar);
		} else {
			dirName = System.getProperty("user.dir");
		}

		File out = new File(dirName, fileName);
				
		if (out.exists()) {
			throw new IllegalStateException("Will not overwrite "+out.getAbsolutePath()+". Please check the file for implementation and remove it!");
		} else {
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
		@param absoluteBaseDir the absolute base directory for the class files to be written
	*/
	public static void generateSyntaxImpl(
		Syntax syntax,
		String className,
		String pkgName,
		List initialNonterminals,
		String absoluteBaseDir)
		throws IOException
	{
		String origClsName = className;
		className = className+"Syntax";
		
		String fileName;
		if (pkgName != null)
			fileName = pkgName+"."+className;
		else
			fileName = className;
		fileName = fileName.replace('.', File.separatorChar)+".java";

		// construct target file name and open handle
		if (!absoluteBaseDir.endsWith(File.separator))
			absoluteBaseDir += File.separator;
		
		Writer f = new BufferedWriter(new FileWriter(absoluteBaseDir+fileName));
		
		if (pkgName != null)
			fwrite("package "+pkgName+";\n\n", f);

		fwrite("/**\n", f);
		fwrite(" * DO NOT EDIT - Syntax generated from "+origClsName+".syntax\n", f);
		fwrite(" * at "+new Date()+"\n", f);
		fwrite(" * by hub.sam.tef.rcc.util.SourceGenerator.\n", f);
		fwrite(" */\n\n", f);

		fwrite("import hub.sam.tef.rcc.syntax.*;\n\n", f);
		fwrite("public final class "+className+" extends Syntax\n", f);	// class definition
		fwrite("{\n", f);
		
		fwrite("	/**\n",f);
		fwrite("	 * @generated\n",f);
		fwrite("	 */\n",f);
		fwrite("	private static final long serialVersionUID = "+ (-System.currentTimeMillis())+"L;\n\n",f);
		
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

	public static void printHelp () {
		System.err.println("SYNTAX: java "+SourceGenerator.class.getName()+" [-parserTable=<tableType>] [-baseDir=<baseDir>] file.syntax [file.syntax ...]");
		//                  0         1         2         3         4         5         6         7
		//                  01234567890123456789012345678901234567890123456789012345678901234567890123456789
		System.err.println(" parameters:");
		System.err.println(" <tableType> : semantic|LALR|SLR|LR"); 
		System.err.println("   Generates <tabletype>-ParserTable implementation(s) of passed grammar file(s)");
		System.err.println("   If no <tabletype> is given: Generates syntax implementation(s) of passed");
		System.err.println("	                           grammar file(s).");
		System.err.println(" <baseDir>");
		System.err.println("   Base directory of the syntax files. The relative path of the .syntax-files to");
		System.err.println("   the base directory will be interpreted as Java package name of the generated");
		System.err.println("   class file(s).");
		System.exit(1);
	}

	/** Source generator main. Writes syntax to stderr when launched with no arguments or -h. */
	public static void main(String [] args)	{
		if (args.length <= 0 || args[0].startsWith("-h"))	{
			printHelp();
		}
		else
		{
			String type = null;
			boolean semantic = false;
			String baseDir = null;
			
			java.util.List<File> files = new LinkedList<File>();
			java.util.List<String> fileNames = new LinkedList<String>();
			
			for (int i=0; i < args.length; i++) {
				if (args[i].indexOf("-parserTable=") == 0) {
					String optArg = args[i].substring(args[i].indexOf('=')+1);
					if (optArg.compareTo("LALR") == 0)
						type = optArg;
					else if (optArg.compareTo("SLR") == 0)
						type = optArg;
					else if (optArg.compareTo("LR") == 0)
						type = optArg;
						
					if (optArg.compareTo("semantics") == 0)
						semantic = true;
					continue;
				}
				
				if (args[i].indexOf("-baseDir=") == 0) {
					String optArg = args[i].substring(args[i].indexOf('=')+1);
					baseDir = optArg;
					continue;
				}
				
				// assume argument is a file name
				fileNames.add(args[i]);
			}

			String baseDirAbsolute = null;
			File f_base;
			if (baseDir != null)
			{
				 if (type != null) {
					 System.err.println("baseDir does not work with LALR/SLR/LR, SourceGenerator has to be called in the base directory of your project");
					 baseDirAbsolute = null;
				 } else {
					 f_base = new File(baseDir);	// base dir
					 baseDirAbsolute = f_base.getAbsolutePath();
				 }
			} else {
				f_base = new File(System.getProperty("user.dir"));
				baseDirAbsolute = f_base.getAbsolutePath();
			}
			System.err.println("absolute base dir: "+baseDirAbsolute);

			for (String fName : fileNames)
			{
				File f = new File(fName);					// try relative path name
				if (f.exists() == false || f.isFile() == false || f.canRead() == false) {
					System.err.println("ERROR: Can not open syntax specification: "+f+"\n");
					System.err.println("       Trying to concatenate file name base dir...");
					f = new File(baseDirAbsolute, fName);	// try absolute path
				}
				
				if (f.exists() == false || f.isFile() == false || f.canRead() == false)
					System.err.println("ERROR: Can not open syntax specification: "+f+"\n");
				else
					files.add(f.getAbsoluteFile());
			}

			for (File f : files) {
				/*
				if (f.getAbsolutePath().equals(f.getPath()) && baseDir == null)	{
					throw new IllegalArgumentException("File MUST have relative path or the -baseDir must be set (to make package name): "+f);
				}
				*/
				
				// make class name
				String clsName = f.getName();	
				int idx = clsName.indexOf(".");	// cut extension
				if (idx > 0)
					clsName = clsName.substring(0, idx);
				
				// make package name
				String pkgName = f.getParent(); // absolute directory of file	
				if (pkgName != null) {
					if (baseDirAbsolute != null
						&& !pkgName.startsWith(baseDirAbsolute))
					{
						throw new IllegalArgumentException("File "+f+" is not a file under the base directory "+baseDirAbsolute);
					}

					// strip absolute path from current file name
					pkgName = pkgName.substring(baseDirAbsolute.length()+1);
					// strip file separators and slashes
					boolean clean = false;
					while (!clean) {
						if (pkgName.startsWith(File.separator)) {
							pkgName = pkgName.substring(File.separator.length());
						} else if (pkgName.startsWith(".")) {
							pkgName = pkgName.substring(1);
						} else {
							clean = true;
						}
					};
					// strip file name, yields absolute directory-path to syntax file
					if (pkgName.endsWith(File.separator))
						pkgName = pkgName.substring(0, pkgName.length()-1);

					// turn remaining path into Java package name 
					pkgName = pkgName.replace(File.separatorChar, '.');
				}
				
				//System.err.println("package name: "+pkgName);
				//System.err.println("class name: "+clsName);
				
				try	{
					SyntaxBuilder builder = new SyntaxBuilder(f);
					if (semantic)	{
						Syntax syntax = builder.getParserSyntax();
						generateSemanticSkeleton(syntax, clsName, pkgName, baseDirAbsolute);
					}
					else if (type != null)
					{
						Syntax syntax = builder.getParserSyntax();
						AbstractParserTables pt = type.equals("SLR")
							? new SLRParserTables(syntax)
							: type.equals("LR")
								? new LRParserTables(syntax)
								: new LALRParserTables(syntax);
						generateParserTable(pt, clsName, pkgName);
					}
					else
					{
						Syntax syntax = builder.getSyntax();
						generateSyntaxImpl(syntax, clsName, pkgName, builder.getInitialNonterminals(), baseDirAbsolute);
					}
				}
				catch (Exception e)	{
					e.printStackTrace();
				}
			}
		}
	}
}
