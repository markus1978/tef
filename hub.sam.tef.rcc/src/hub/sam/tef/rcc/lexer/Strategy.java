package hub.sam.tef.rcc.lexer;

import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.generalutil.collections.AggregatingHashtable;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
	Strategy is the way how alternative concurrent character consumers are applied to input.
	It is used by <i>LexerImpl</i> and <i>ConsumerAlternatives</i>.
	There are consumers that have a fixed start character and others that have not.
	Consumers have different length of fixed start sequences.
	Some consumers have a fixed length to scan, others (with repeatable rules) have not.
	Consumers differ in their character sets, some having many possible characters,
	others lesser, some sets might overlap those of other consumers.
	Last but not least the Parser gives hints about currently expected tokens.
	<p />
	Following is the strategy implemented here:
	<ul>
		<li>Divide consumers in two groups: those with fixed start character and those without.</li>
		<li>Sort both consumers groups by
			<ol>
				<li>by the variance of their start character (which may be a set), the less the better</li>
				<li>their start sequence length (ends before first repeatable character), the longer the better</li>
				<li>by their fixed start length (ends before first character set), the longer the better.</li>
			</ol>
			Sorting is done by <i>Consumer implements Comparable</i>
			</li>
		<li>The lookahead character chooses consumers with fixed start character.</li>
		<li>If one matches, overlapping consumers without fixed start character are tried, when one scans longer, it wins.</li>
		<li>If none matches, consumers without fixed start character are tried, by sort order.</li>
		<li>If one matches, overlapping consumers without fixed start character are tried, when one scans longer, it wins.</li>
	</ul>
	
	@author Fritz Ritzberger
*/

public class Strategy implements
	Serializable
{
	private boolean inited;
	private AggregatingHashtable itemsWithStartChar = new AggregatingHashtable();
	private List itemsWithoutStartChar = new ArrayList();
	private AggregatingHashtable competitiveGroups = new AggregatingHashtable();
	private boolean competeForLongestInput = true;


	public void setCompeteForLongestInput(boolean competeForLongestInput)	{
		this.competeForLongestInput = competeForLongestInput;
	}

	/** Adds a Consumer to list of possible consumers. This consumer will read input to be ignored by the parser. */
	public void addIgnoringConsumer(String symbol, Consumer cc)	{
		addConsumer(symbol, cc);
	}
	
	/** Adds a Consumer to list of possible consumers producing valid tokens. */
	public void addTokenConsumer(String symbol, Consumer cc)	{
		addConsumer(symbol, cc);
	}

	/** Returns true if the passed terminal is already in list. */
	public boolean hasTerminal(String terminal)	{
		for (Enumeration e = new ItemEnumerator(); e.hasMoreElements(); )
			if (((Item) e.nextElement()).getSymbol().equals(terminal))
				return true;
		return false;
	}

	private void addConsumer(String symbol, Consumer cc)	{
		Item item = new Item(symbol, cc);
		Character c = item.consumer.getStartCharacter();
		if (c != null)
			itemsWithStartChar.put(c, item);
		else
			itemsWithoutStartChar.add(item);
	}

	/** Liefert die Items, die dem uebergebenen Start-Zeichen entsprechen wuerden. */
	private List getItemsWithStartCharacter(int c)	{
		init();
		return (List) itemsWithStartChar.get(new Character((char)c));
	}

	/** Liefert die Items, die kein bestimmtes Start-Zeichen definieren. */
	private List getItemsWithoutStartCharacter()	{
		init();
		return itemsWithoutStartChar;
	}


	// separate consumers with or without fixed start character, build hashtable for start characters
	private void init()	{
		if (inited == false)	{
			inited = true;
			// sort items with start character
			for (Iterator it = itemsWithStartChar.entrySet().iterator(); it.hasNext(); )	{
				Map.Entry entry = (Map.Entry) it.next();
				Collections.sort((List) entry.getValue());
			}
			// sort items without start character
			Collections.sort(itemsWithoutStartChar);
		}
	}

	private List initCompetitors(Item candidate)	{
		List competitors = (List) competitiveGroups.get(candidate);
		if (competitors != null)	// already inited
			if (competitors.get(0) instanceof Item)	// valid competitor list
				return competitors;
			else	// was dummy object
				return null;
			
		for (Enumeration e = new ItemEnumerator(); e.hasMoreElements(); )	{	// search a competitor among all items
			Item item = (Item) e.nextElement();
			if (item != candidate && item.consumer.overlaps(candidate.consumer))	{
				//System.err.println("Found competitive consumers: candidate = "+candidate.consumer+", competitor = "+item.consumer);
				competitiveGroups.put(candidate, item);
			}
		}
		
		competitors = (List) competitiveGroups.get(candidate);
		if (competitors == null)	// no competitors were found, mark candidate with dummy object
			competitiveGroups.put(candidate, new Byte((byte)0));
		
		return competitors;
	}



	/**
		Liefert null wenn kein consumer den input lesen kann, sonst den laengstmoeglichen gescannten Text.
		@param input the input to read from
		@param lookahead the first byte or character from input
		@param expectedTokenSymbols expected token symbols (in key enumeration), can be null
	*/
	public Item consume(InputText input, int lookahead, Map expectedTokenSymbols)
		throws IOException
	{
		// try all scan-items by sort order, indexed ones first
		List [] allItems = new List [] { getItemsWithStartCharacter(lookahead), getItemsWithoutStartCharacter() };
		
		for (int j = 0; j < allItems.length; j++)	{
			List items = allItems[j];
			
			if (items != null)	{
				for (int i = 0; i < items.size(); i++)	{
					Item item = (Item) items.get(i);
					
					if (expectedTokenSymbols == null || expectedTokenSymbols.get(item.getSymbol()) != null)	{
						int startMark = input.getMark();	// save start position for concurrent consumers
						ResultTree result = item.consume(input);
						
						if (result != null)	{	// consumer succeeded
							if (competeForLongestInput)	{
								List competitors = initCompetitors(item);
								if (competitors != null)	{
									int bestMark = input.getMark();
									input.setMark(startMark);
									item = checkCompetitiveGroups(result, item, input, competitors, bestMark, expectedTokenSymbols);	// returns item that scans longest
								}
							}
							return item;
						}
					}
				}	// end for all items
			}	// end if item != null
		}	// end for both item groups
		
		/* my version
		if (expectedTokenSymbols != null) { // when this was a run with hints,
			Item result = consume(input, lookahead, null);	// now try without hints
			if (result == null) {
				// consume at least one character (part of error recovery)
				input.read();
			}
		}
			
		return null;
		*/
		
		if (expectedTokenSymbols != null) { // when this was a run with hints,
			return consume(input, lookahead, null);	// now try without hints
		}
		return null;
	}


	// loop competitive group of passed Item (if existent), return given Item or an Item that scans longer
	private Item checkCompetitiveGroups(ResultTree result, Item item, InputText input, List competitors, int bestMark, Map expectedTokenSymbols)
		throws IOException
	{
		int max = bestMark - input.getMark();
		
		for (int i = 0; i < competitors.size(); i++)	{
			Item competitor = (Item) competitors.get(i);
			
			// let take part only if no expected symbols or is in expected symbols
			if (expectedTokenSymbols != null && expectedTokenSymbols.get(competitor.getSymbol()) == null)
				continue;

			int mark = input.getMark();	// memorize current input mark

			ResultTree r = competitor.consume(input);	// consume
			int len = input.getMark() - mark;
			
			if (r != null && len > max)	{	// scanned longer
				bestMark = input.getMark();
				max = len;
				item = competitor;
			}
			
			input.setMark(mark);	// reset for next candidate
		}

		input.setMark(bestMark);	// set mark forward to best scan result
		
		return item;
	}


	/** Returns a human readable representation of the lists and maps within this strategy. */
	public String toString()	{
		init();
		StringBuffer sb = new StringBuffer();
		sb.append("  Indexed list is: "+itemsWithStartChar.size()+"\n");
		for (Iterator it = itemsWithStartChar.entrySet().iterator(); it.hasNext(); )	{
			Map.Entry entry = (Map.Entry) it.next();
			sb.append("    "+entry.getKey()+"	->	"+entry.getValue()+"\n");
		}
		sb.append("  Sorted unindexed list is: "+itemsWithoutStartChar.size()+"\n");
		for (int i = 0; i < itemsWithoutStartChar.size(); i++)	{
			sb.append("    "+itemsWithoutStartChar.get(i)+"\n");
		}
		return sb.toString();
	}



	/**
		The List item wrapper for toplevel consumers. Items can be sorted by their relevance.
		They encapsulate a consumer, its token symbol and the consumed lexer result.
	*/
	public static class Item implements
		Comparable,
		Serializable
	{
		private String symbol;
		private Consumer consumer;
		private transient ResultTree result;
		
		public Item(String symbol, Consumer consumer)	{
			if (consumer == null)
				throw new IllegalArgumentException("Got no character consumer for symbol "+symbol);
			if (symbol == null)
				throw new IllegalArgumentException("Got no symbol for consumer "+consumer);

			this.symbol = symbol;
			this.consumer = consumer;
		}
		
		/** Consumes from input by delegating to contained consumer, stores the result. */
		public ResultTree consume(InputText input)
			throws IOException
		{
			return result = consumer.consume(input);
		}
		
		/** Returns the lexer item symbol, enclosed in `backquotes` when not a literal. */
		public String getSymbol()	{
			return symbol;
		}
		
		/** Returns the token symbol, always enclosed in some quotes. */
		public String getTokenIdentifier()	{
			return Token.isTerminal(symbol) ? symbol : Token.COMMAND_QUOTE + symbol + Token.COMMAND_QUOTE;
		}
	
		public ResultTree getResultTree()	{	// this is for ConsumerAlternatives
			return result;
		}
	
		public String toString()	{
			return "{"+symbol+"} "+consumer.toString();
		}
	
		/** Implements Comparable: delegates to character consumer. If they are equal, "terminals" are preferred. */
		public int compareTo(Object o)	{
			Consumer cc1 = consumer;
			Consumer cc2 = ((Item)o).consumer;
			int i;
			if ((i = cc1.compareTo(cc2)) != 0)
				return i;
			return Token.isTerminal(symbol) ? -1 : 1;
		}
	
		/** Compares the contained consumer with other via "==". */
		public boolean equals(Object o)	{
			return ((Item) o).consumer == consumer;
		}

		/** Returns the consumers hashcode. */
		public int hashCode()	{
			return consumer.hashCode();
		}
	}



	// enumeration over all strategy items (toplevel consumers)
	private class ItemEnumerator implements Enumeration
	{
		private Iterator it, it1, it2;
		
		public ItemEnumerator()	{
			it = itemsWithStartChar.entrySet().iterator();
			it1 = it.hasNext() ? ((List) ((Map.Entry)it.next()).getValue()).iterator() : null;
			it2 = itemsWithoutStartChar.iterator();
		}
		public boolean hasMoreElements()	{
			return it.hasNext() || it1 != null && it1.hasNext() || it2.hasNext();
		}
		public Object nextElement()	{
			if (it1 != null)
				if (it1.hasNext())
					return it1.next();
				else
				if (it.hasNext())
					return (it1 = ((List) ((Map.Entry)it.next()).getValue()).iterator()).next();

			if (it2.hasNext())
				return it2.next();
				
			throw new IllegalStateException("Do not call nextElement() when hasMoreElements() returned false!");
		}
	}

}
