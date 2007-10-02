package fri.util.collections;

import java.util.List;

/**
	A hashtable that holds a list of unique values instead of a single value for one key.

	@author Fritz Ritzberger
*/

public class UniqueAggregatingHashtable extends AggregatingHashtable
{
	public UniqueAggregatingHashtable()	{
		super();
	}
	
	public UniqueAggregatingHashtable(int initialCapacity)	{
		super(initialCapacity);
	}
	
	protected boolean shouldAdd(List list, Object value)	{
		return list != null ? list.indexOf(value) < 0 : true;
	}

}
