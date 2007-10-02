package fri.util.collections;

import java.util.*;
import java.io.*;

/**
	A hashtable that holds a list of values instead of a single value for one key.
	In any case the <i>get(Object)</i> method returns a List (Vector) of values.
	Every new <i>put()</i> call adds to the list of values. The <i>remove()</i>
	call removes the whole list of values at once.

	@author Fritz Ritzberger
*/

public class AggregatingHashtable extends Hashtable
{
	public AggregatingHashtable()	{
		super();
	}
	
	public AggregatingHashtable(int initialCapacity)	{
		super(initialCapacity);
	}
	
	/**
		Puts the passed value into a List (Vector) for given key, creates the list when necessary.
		@return null if list was not yet existent, else the found list.
	*/
	public Object put(Object key, Object value)	{
		List list = (List) super.get(key);
		Object ret = null;
		
		if (list == null)	{
			list = createAggregationList();
			super.put(key, list);
		}
		else	{
			if (shouldAdd(list, value) == false)
				return list;
			
			ret = list;
		}

		list.add(value);
		return ret;
	}
	
	/** To be overridden for filtering values. */
	protected boolean shouldAdd(List list, Object value)	{
		return true;
	}

	/** To be overridden for allocation of special aggregation List types. */
	protected List createAggregationList()	{
		return new ArrayList();
	}

	/** Replaces the list of objects for a key by a new list, overriding aggregation. */
	public void replace(Object key, List newList)	{
		super.put(key, newList);
	}



	// Must adjust deserialization as put() will put value lists into newly provided lists
	private void readObject(ObjectInputStream s) 
		throws IOException, ClassNotFoundException
	{
		s.defaultReadObject();

		for (Iterator it = entrySet().iterator(); it.hasNext(); )	{
			Map.Entry entry = (Map.Entry) it.next();
			List list = (List) entry.getValue();
			Object o = list.size() == 1 ? list.get(0) : null;	// resolve the list that has been put by super.readObject()
			if (o instanceof List)	{	// apache commons MultiHashMap came around with that problem only on JDK 1.2 and 1.3 ?
				super.put(entry.getKey(), o);
			}
		}
	}

}
