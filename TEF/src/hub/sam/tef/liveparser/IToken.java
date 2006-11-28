package hub.sam.tef.liveparser;

public interface IToken {
		
	/**
	 * @param string A string to match against this token.
	 * @return True if the given string starts with this token.
	 */
	public boolean isPrefix(String string);
	
	/**
	 * Returns the largest substring of string that matches this token and
	 * starts from the beginning of string.
	 * 
	 * @param string
	 *            The string to match against the token.
	 * @return The result.
	 */
	public String match(String string);
}
