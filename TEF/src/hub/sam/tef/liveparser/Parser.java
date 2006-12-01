package hub.sam.tef.liveparser;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

/**
 * A simple shift reduce parser. Works on a set of rules. Supports two actions
 * to modify the parser: shift and reduced. After parsing is completed, this
 * parser provides the used derivation.
 * 
 * @author scheidge
 * 
 */
public class Parser {

	private final Collection<SyntaxRule> fRules;
	private final Object fStartSymbol;
	private java.util.Stack<Object> theStack = new java.util.Stack<Object>();

	/**
	 * @param rules A set of SyntaxRules for this parser.
	 * @param startSymbol The start symbols.
	 */
	public Parser(final Collection<SyntaxRule> rules, Object startSymbol) {
		super();
		fRules = rules;
		fStartSymbol = startSymbol;
	}
	
	/**
	 * @return The current head of the parser
	 */
	public Object getHead() {
		return (theStack.size() == 0) ? null : theStack.peek();
	}
	
	/**
	 * @param symbols A list of symbols
	 * @return True if this list of symbols lays top on the stack.
	 */
	public boolean isPrefix(List<Object> symbols) {
		if (theStack.size() < symbols.size()) {
			return false;
		} else {
			return theStack.subList(0, symbols.size()).equals(symbols);
			
		}
	}

	/**
	 * @return All rules that are compatible with the first symbols or
	 *         terminals on this stack.
	 */
	public Collection<SyntaxRule> possibilities() {
		Collection<SyntaxRule> result = new Vector<SyntaxRule>();
		Object head = getHead();
		if (head == null) {
			return fRules;
		} else if (head instanceof IToken) {
			for (SyntaxRule rule: fRules) {
				if (rule instanceof TokenRule) {
					if (head.equals(((TokenRule)rule).getToken())) {
						result.add(rule);
					}
				}
			}			
		} else {
			for (SyntaxRule rule: fRules) {
				if (rule instanceof SymbolRule) {
					if (cuts(theStack, ((SymbolRule)rule).getSymbols()) != -1) {
						result.add(rule);
					}
				}
			}
		}
		return result;
	}
	
	private Collection<SyntaxRule> reducable() {
		Collection<SyntaxRule> result = new Vector<SyntaxRule>();
		Object head = getHead();
		if (head == null) {
			return result;
		} else if (head instanceof IToken) {
			for (SyntaxRule rule: fRules) {
				if (rule instanceof TokenRule) {
					if (head.equals(((TokenRule)rule).getToken())) {
						result.add(rule);
					}
				}
			}			
		} else {
			for (SyntaxRule rule: fRules) {
				if (rule instanceof SymbolRule) {
					int cut = cuts(theStack, ((SymbolRule)rule).getSymbols());
					if (cut + 1== ((SymbolRule)rule).getSymbols().size()) {
						result.add(rule);
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * @param suffix
	 *            A list, the end of this list is compared to the beginning of
	 *            the next list.
	 * @param prefix
	 *            A list, its beginning is compaired to the end of the other
	 *            list.
	 * @return The index of the prefix argument until which the beginning of
	 *         prefix fits the end of suffix. Returns -1 if the lists doesnt
	 *         match at all.
	 */
	private final static int cuts(List<Object> suffix, List<Object> prefix) {
		int size = (suffix.size() > prefix.size())? prefix.size() : suffix.size();
		int result = -1;
		for (int i = 0; i < size; i++) {
			if (suffix.subList(suffix.size() - i - 1, suffix.size()).equals(prefix.subList(0, i + 1))) {
				result = i;
			}
		}
		return result;
	}
	
	/**
	 * @return All left most terminals that can be produced with possible rules
	 *         and the actual stack already consumed.
	 */
	public Collection<IToken> allPossibleTokens() throws ParseException {
		Collection<IToken> result = new Vector<IToken>();
		Object head = getHead();
		if (head == null) {
			result.addAll(allPossibleTokens(fStartSymbol, new HashSet<Object>()));
		} else if (head instanceof IToken) {
			// empty
		} else {
			for (SyntaxRule rule: fRules) {
				if (rule instanceof SymbolRule) {
					List<Object> symbols = ((SymbolRule)rule).getSymbols();
					int length = cuts(theStack, symbols) + 1;
					if (length > 0) {
						if (symbols.size() > length) {
							Object nextSymbol = symbols.get(length);
							result.addAll(allPossibleTokens(nextSymbol, new HashSet<Object>()));
						} else {
							// reducable
							throw new ParseException("shift reduce conflict");
						}
					}
				}
			}			
		}
		return result;
	}	
	
	private Collection<IToken> allPossibleTokens(Object symbol, Collection<Object> visitedSymbols) {
		Collection<IToken> result = new HashSet<IToken>();
		for (SyntaxRule rule: fRules) { // TODO MultiMap performance
			if (rule.getSymbol().equals(symbol)) {
				if (rule instanceof TokenRule) {				
					result.add(((TokenRule)rule).getToken());
				} else {
					if (!visitedSymbols.contains(rule.getSymbol())) {
						visitedSymbols.add(rule.getSymbol());
						result.addAll(allPossibleTokens(((SymbolRule)rule).getSymbols().get(0), visitedSymbols));
						visitedSymbols.remove(rule.getSymbol());
					}				
				}
			}
		}
		return result;
	}	
	
	/**
	 * Reduces using a given rule. Replaces the top symbols on the stack, must
	 * be the rhs of the given rule, with the lhs of this rule.
	 * 
	 * @param rule
	 *            The to reduce.
	 */
	public void reduce(SyntaxRule rule) {
		if (! possibilities().contains(rule)) {
			throw new RuntimeException("assert");
		}
		if (rule instanceof TokenRule) {
			theStack.pop();			
		} else {
			for (int i = 0; i < ((SymbolRule)rule).getSymbols().size(); i++) {
				theStack.pop();				
			}			
		}
		theStack.push(rule.getSymbol());
	}
	
	/**
	 * Shifts the given token onto the stack, provided that the given token is a
	 * possible token for the current stack configuration.
	 * 
	 * @param token
	 *            The token to shift.
	 */
	public void shift(IToken token) throws ParseException {
		if (! allPossibleTokens().contains(token)) {
			throw new RuntimeException("assert");
		}		
		theStack.push(token);
	}
	
	/**
	 * Trys to reduce the stack with the parser rules. Will only do one reduction.
	 * 
	 * @return True if it could do a reduction.
	 */
	public boolean reduce() throws ParseException {
		Collection<SyntaxRule> reducable = reducable();
		if (reducable.size() > 1) {
			throw new ParseException("reduce reduce conflict");
		} else if (reducable.size() == 1) {
			reduce(reducable.iterator().next());
			return true;
		}
		return false;
	}
	
	/**
	 * Tries to parse the given token. Throws exception if the token cant be
	 * parsed.
	 * 
	 * @param token
	 *            The token to be parsed.
	 */
	public void parse(IToken token) throws ParseException {
		while(reduce());
		if (allPossibleTokens().contains(token)) {
			shift(token);
		} else {
			throw new ParseException("parse error");
		}
		while(reduce());
	}
	
	/**
	 * Parses using a given Scanner.
	 * 
	 * @param scanner
	 *            The scanner, string already set.
	 * @return True if the string could be parsed. This does not mean that the
	 *         parser {@link #finished()}.
	 */
	public boolean parser(Scanner scanner) {
		try {
			IToken next = scanner.next();
			do {
				parse(next);
				next = scanner.next();
			} while (next != null);
		} catch (ParseException ex) {
			System.out.println("cannot be parsed");
			return false;
		}
		return true;
	}
	
	/**
	 * @return True if only the start symbol lays on the stack.
	 */
	public boolean finished() {
		return theStack.size() == 1 && theStack.peek().equals(fStartSymbol);
	}
	
	/**
	 * Can only be called when the parser is {@link #finished()}.
	 * 
	 * @return A derivation used to do the parsing.
	 */
	public Derivation getDerivation() {
		return null;
	}
}
