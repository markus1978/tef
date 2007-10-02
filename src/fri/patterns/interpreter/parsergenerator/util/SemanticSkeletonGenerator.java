package fri.patterns.interpreter.parsergenerator.util;

import java.util.*;
import java.io.*;
import fri.patterns.interpreter.parsergenerator.syntax.*;

/**
	This class can be called using SourceGenerator by commandline.
	<p>
	Generates Java code that contains empty method bodies for the
	implementation of a given Syntax. For every rule there will
	be a method with the name of the nonterminal on the left side
	and one argument for each symbol on the right side. All arguments
	are of type Object.
	The created implementation derives <i>ReflectSemantic</i>.
	<pre>
		File in = new File("MySyntax.grammar);
		String basename = "MySemantic";
		Writer out = new FileWriter(basename+".java");
		new SemanticSkeletonGenerator(in, basename, "my.pkg.name", out);
		// the Java source "my/pkg/name/MySemantic.java" will be generated
	</pre>
	
	@see fri.patterns.interpreter.parsergenerator.semantics.ReflectSemantic
	@see fri.patterns.interpreter.parsergenerator.util.SourceGenerator
	@author (c) 2002, Fritz Ritzberger
*/

public class SemanticSkeletonGenerator
{
	private static Hashtable keyWords;
	private BufferedWriter bw;
	
	/**
		Reads the passed Syntax and turns it into a semantic skeleton implementation.
		The passed Write will be closed.
		@param syntax Syntax the semantc is meant for
		@param className basname of the class to generate (without package)
		@param pkgName name of package, can be null
		@param skeletonOutput Writer where Java source should be written to
	*/
	public SemanticSkeletonGenerator(Syntax syntax, String className, String pkgName, Writer skeletonOutput)
		throws Exception
	{
		if (skeletonOutput instanceof BufferedWriter)
			bw = (BufferedWriter)skeletonOutput;
		else
			bw = new BufferedWriter(skeletonOutput);
		
		// start of java file
		if (pkgName != null && pkgName.length() > 0)	{
			writeLine("package "+pkgName+";");
			writeLine();
		}
		writeLine("/** ");
		writeLine(" * IMPLEMENT ME: Semantic skeleton will not be overwritten, generated");
		writeLine(" * at "+new Date()+"\n");
		writeLine(" * by fri.patterns.interpreter.parsergenerator.util.SemanticSkeletonGenerator.");
		writeLine(" */");
		writeLine();
		writeLine("import fri.patterns.interpreter.parsergenerator.semantics.ReflectSemantic;");
		writeLine();
		writeLine("public class "+className+" extends ReflectSemantic");
		writeLine("{");
		
		Map methods = new Hashtable();
		
		// output default method bodies
		for (int i = 0; i < syntax.size(); i++)	{
			Rule rule = syntax.getRule(i);

			String nonterminal = rule.getNonterminal();
			
			// check if methodname candidate is a Java keyword - refuse when it is
			checkMethodNameAgainstKeywords(nonterminal);	// throws IllegalArgumentException
			
			// check if already used, argument types are always Object
			int countArgs = rule.rightSize();
			String signature = nonterminal+"("+countArgs+")";
			boolean alreadyHaveMethod = false;

			write("\t");
			
			if (methods.get(signature) != null)	{
				alreadyHaveMethod = true;
				// already have this method, make comment
				write("//");
			}
			
			// open method and argument list
			write("public Object "+nonterminal+"(");	// must be public to be found by reflection

			List args = new ArrayList(countArgs);

			for (int j = 0; j < rule.rightSize(); j++)	{
				String s = rule.getRightSymbol(j);

				if (j > 1 || s != null && s.trim().length() > 0)
					write((j == 1 ? "" : ", ")+"Object "+getValidParamName(s, args, j));
			}
			// close argument list
			writeLine(")");

			if (alreadyHaveMethod == false)	{
				writeLine("\t{");
				
				write("\t\tSystem.err.println(\""+nonterminal+" (");
				for (int j = 0; j < args.size(); j++)	{
					write((j == 0 ? "" : ", ")+"'\"+"+args.get(j)+"+\"'");
				}
				writeLine(")\");");
				
				writeLine("\t\treturn \""+signature+"\";");	// return name of method
				writeLine("\t}");

				methods.put(signature, signature);
			}

			writeLine();
		}

		// end of java file
		writeLine();
		writeLine("}");
		writeLine();
		
		bw.close();
	}



	private void writeLine()
		throws IOException
	{
		bw.newLine();
	}

	private void writeLine(String line)
		throws IOException
	{
		bw.write(line, 0, line.length());
		writeLine();
	}

	private void write(String s)
		throws IOException
	{
		bw.write(s, 0, s.length());
	}
	

	// Make a compileable parameter name from syntax symbol.
	// Returns words for standard symbols.
	private String getValidParamName(String symbol, List argsUntilNow, int position)	{
		String s = SymbolToName.makeIdentifier(symbol, true);

		if (argsUntilNow.indexOf(s) >= 0)
			s = s+position;
		
		argsUntilNow.add(s);
		
		return s;
	}

	// Check against Java key words.
	private void checkMethodNameAgainstKeywords(String method)	{
		if (keyWords == null)	{
			keyWords = new Hashtable();
			keyWords.put("boolean", "");
			keyWords.put("byte", "");
			keyWords.put("short", "");
			keyWords.put("int", "");
			keyWords.put("long", "");
			keyWords.put("char", "");
			keyWords.put("float", "");
			keyWords.put("double", "");
			keyWords.put("abstract", "");
			keyWords.put("break", "");
			keyWords.put("case", "");
			keyWords.put("catch", "");
			keyWords.put("class", "");
			keyWords.put("const", "");
			keyWords.put("continue", "");
			keyWords.put("default", "");
			keyWords.put("do", "");
			keyWords.put("else", "");
			keyWords.put("extends", "");
			keyWords.put("false", "");
			keyWords.put("final", "");
			keyWords.put("finally", "");
			keyWords.put("for", "");
			keyWords.put("goto", "");
			keyWords.put("if", "");
			keyWords.put("implements", "");
			keyWords.put("import", "");
			keyWords.put("instanceof", "");
			keyWords.put("interface", "");
			keyWords.put("native", "");
			keyWords.put("new", "");
			keyWords.put("null", "");
			keyWords.put("package", "");
			keyWords.put("public", "");
			keyWords.put("protected", "");
			keyWords.put("private", "");
			keyWords.put("return", "");
			keyWords.put("static", "");
			keyWords.put("strictfp", "");
			keyWords.put("super", "");
			keyWords.put("switch", "");
			keyWords.put("synchronized", "");
			keyWords.put("this", "");
			keyWords.put("throw", "");
			keyWords.put("throws", "");
			keyWords.put("transient", "");
			keyWords.put("true", "");
			keyWords.put("try", "");
			keyWords.put("volatile", "");
			keyWords.put("void", "");
			keyWords.put("while", "");
		}
		
		if (keyWords.get(method) != null)
			throw new IllegalArgumentException("Nonterminal \""+method+"\" is a Java keyword and can not be used as methodname with AbstractSemantic!");
	}

}
