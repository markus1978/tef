package hub.sam.tef.rcc.generalutil;

/**
 * Object utility. Equality and hash code for objects that may be null.
	
  @author Ritzberger Fritz
*/

public abstract class Equals
{
	/**
	 * Returns false if objects are not equal or one of them is null and the other not.
	 */
	public static boolean equals(Object o1, Object o2)	{
		return o1 == o2 ? true : o1 == null || o2 == null ? false : o1.equals(o2);
	}	// null == null is true in Java

	/**
	 * Returns zero for a null object, else the objects hash code.
	 */
	public static int hashCode(Object o)	{
		return o == null ? 0 : o.hashCode();
	}

	private Equals()	{}
	
}