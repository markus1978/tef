package hub.sam.tef.rcc.lexer.examples;

import hub.sam.tef.rcc.Lexer;
import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.lexer.LexerBuilder;
import hub.sam.tef.rcc.lexer.LexerException;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.rcc.syntax.builder.SyntaxSeparation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
	Sample for a Lexer built from blocks of StandardLexerRules.
	Removes comments from Java/C source.

	@author (c) 2002, Fritz Ritzberger
*/

public class CStyleCommentStrip
{
	private static Lexer lexer;
	
	static	{
		try	{
			String [][] rules = {
				{ Token.TOKEN, "others" },	// define what we want to receive
				{ Token.TOKEN, "`stringdef`" },	// need this rule, as string definitions could contain comments
				{ Token.IGNORED, "`cstylecomment`" },
				{ "others", "others", "other" },
				{ "others", "other" },
				{ "other", "`char`", Token.BUTNOT, "`cstylecomment`", Token.BUTNOT, "`stringdef`" },
			};
	
			Syntax syntax = new Syntax(rules);	// LexerBuilder makes unique
			SyntaxSeparation separation = new SyntaxSeparation(syntax);
			LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());
			lexer = builder.getLexer();
			//lexer.setDebug(true);	// dumps scanner consumer lists
			lexer.setTerminals(separation.getTokenSymbols());
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
	}
	
	
	/**
		Stripping C-style comments from an input reader and writing to output writer.
		Both in and out get closed when finished.
	*/
	public CStyleCommentStrip(Reader in, Writer out)
		throws LexerException, IOException
	{
		try	{
			lexer.setInput(in);

			Token t;
			do	{
				t = lexer.getNextToken(null);
				
				if (t.symbol == null)
					lexer.dump(System.err);
				else
				if (t.text != null)
					out.write(t.text.toString());
			}
			while (t.symbol != null && Token.isEpsilon(t) == false);
		}
		finally	{
			try	{ in.close(); } catch (Exception e)	{ e.printStackTrace(); }
			try	{ out.close(); } catch (Exception e)	{ e.printStackTrace(); }
		}
	}



	/** Example implementation: Stripping C-style comments from Java files, passed as arguments. */
	public static void main(String [] args)	{
		if (args.length <= 0)	{
			System.err.println("SYNTAX: java "+CStyleCommentStrip.class.getName()+" file.java [file.java ...]");
			System.err.println("	Strips // C-style /* comments */ from C/Java sources.");
		}
		else	{
			try	{
				for (int i = 0; i < args.length; i++)	{
					PrintWriter out = new PrintWriter(System.out);
					Reader in = new BufferedReader(new FileReader(args[i]));
					new CStyleCommentStrip(in, out);
				}
			}
			catch (Exception e)	{
				e.printStackTrace();
			}
		}
	}

}
