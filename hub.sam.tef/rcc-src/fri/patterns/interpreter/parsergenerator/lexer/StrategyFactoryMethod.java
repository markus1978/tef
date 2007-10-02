package fri.patterns.interpreter.parsergenerator.lexer;

/**
 * StrategyFactoryMethod creates a new Strategy object
 * for both ConsumerAlternatives and LexerImpl.
 * 
 * Created on 27.09.2005
 * @author Fritz Ritzberger
 */
public interface StrategyFactoryMethod
{
	/** Returns a new Strategy object for competing Consumers. */
	public Strategy newStrategy();
	
}
