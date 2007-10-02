package fri.patterns.interpreter.parsergenerator;

import java.util.List;
import java.util.Map;
import java.io.PrintStream;
import java.io.IOException;

/**
	A Lexer reads input bytes (InputStream) or characters (Reader), until
	one of its terminals is fulfilled. This happens when the Parser calls 
	<i>getNextToken()</i>. The terminals will be set by the Parser on init.
	<p>
	Usage:
	<pre>
	SyntaxSeparation separation = new SyntaxSeparation(new Syntax(myRules));
	LexerBuilder builder = new LexerBuilder(separation.getLexerSyntax(), separation.getIgnoredSymbols());
	Lexer lexer = builder.getLexer(inputStream);
	lexer.setTerminals(separation.getTokenSymbols());
	Token token;
	do	{
		token = lexer.getNextToken(null);
		System.err.println("token.symbol="+token.symbol+", text >"+token.text+"<");
	}
	while (token.symbol != null && Token.isEpsilon(token) == false);
	boolean error = token.symbol == null;
	</pre>

	@see fri.patterns.interpreter.parsergenerator.lexer.LexerImpl
	@author (c) 2000, Fritz Ritzberger
*/

public interface Lexer
{
	/**
		Set the input to be processed by the Lexer.
		@param text can be String, StringBuffer, File, InputStream, Reader.
	*/
	public void setInput(Object text) throws IOException;
	
	/**
		Tells the Lexer the terminals (tokens) to scan, called on init. Every terminal is a String
		that satisfies the facts defined in <i>Token.isTerminal()</i> (EPSILON or delimited by quotes).
		@param terminals List of String containing all terminals of the parser syntax.
	*/
	public void setTerminals(List terminals);

	/**
		Returns the next token from input. This is done trying to satisy the parser hints, or
		by using contained character consumers, which are obtained by the lexer strategy.
		@param tokenSymbols a Map that contains token symbols (in "key" field) expected by the Parser, can be null (slower).
		@return a Token with a terminal symbol and its instance text, or a Token with null symbol for error.
	*/
	public Token getNextToken(Map tokenSymbols) throws IOException;

	/** Reset the Lexer for another pass. */
	public void clear();




	/**
	 * A way to receive every parsing syntax Token the Lexer reads, even it is ignored.
	 * The implementer can install itself by calling <i>addTokenListener()</i>.
	 */
	public interface TokenListener
	{
		/**
		 * The implementer receives every token the lexer reads, even if it is ignored.
		 * @param token the Token that was successfully scanned from input.
		 * @param ignored true when this Token will be thrown away (not passed to Parser), else false.
		 */
		public void tokenReceived(Token token, boolean ignored);
	}
	
	/**
	 * Installs a TokenListener that wants to know about every read Token, even it is ignored.
	 * @param listener the Lexer.Listener implementation to install.
	 */
	public void addTokenListener(Lexer.TokenListener listener);

	/**
	 * Removes a TokenListener from this Lexer.
	 * @param listener the Lexer.Listener implementation to remove.
	 */
	public void removeTokenListener(Lexer.TokenListener listener);




	// debug methods
	
	/** Dump the current text and the scan position. */
	public void dump(PrintStream out);	

	/** Turn on and off debug mode. */
	public void setDebug(boolean debug);

}
