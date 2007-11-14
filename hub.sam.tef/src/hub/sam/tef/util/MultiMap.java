package hub.sam.tef.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MultiMap<E, V> {

    public Map<E, Collection<V>> values = new HashMap<E, Collection<V>>();

    protected Collection<V> createCollection() {
        return new HashSet<V>();
    }

    public void put(E key, V value) {
        Collection<V> set = values.get(key);
        if (set == null) {
            set = createCollection();
            values.put(key, set);
        }
        set.add(value);
    }

    public void putAll(E key, Iterable<? extends V> value) {
        Collection<V> set = values.get(key);
        if (set == null) {
            set = createCollection();
            values.put(key, set);
        }
        for (V v: value) {
            set.add(v);
        }
    }

    public void removeValue(V value) {
        for (Collection<V> values: this.values.values()) {
            values.remove(value);
        }
    }

    public void removeKey(E key) {
        values.get(key).clear();
        values.remove(key);
    }

    public Collection<V> get(E key) {
        Collection<V> result = values.get(key);
        if (result == null) {
            result = createCollection();
            values.put(key, result);
        }
        return result;
    }

    public Collection<Collection<V>> getValues() {
    	return values.values();
    }

    public Collection<E> getKeys() {
    	return values.keySet();
    }
    
    public void clear() {
    	values.clear();
    }
}
