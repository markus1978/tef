package hub.sam.tef.util;

import java.util.Collection;
import java.util.HashSet;

public class Tree<E> extends MultiMap<E, E>{

    public Tree<E> collapseTree() {
        Tree<E> result = new Tree<E>();
        for (E key: values.keySet()) {
            collectAllValues(key, result.get(key));
        }
        return result;
    }
    
    public Collection<E> getRoots() {
        Collection<E> result = new HashSet<E>();
        for (Collection<E> value: values.values()) {
            result.addAll(value);
        }
        for (Collection<E> value: values.values()) {
            for (E singleValue: value) {
                if (values.get(singleValue) != null) {
                    result.removeAll(values.get(singleValue));
                }
            }
        }
        return result;
    }
    
    public Collection<E> getLeaves(E key) {
        Collection<E> result = new HashSet<E>();
        Collection<E> children = values.get(key);
        if (children == null || children.size() == 0) {
            result.add(key);
        } else {
            for (E child: children) {
                result.addAll(getLeaves(child));
            }
        }
        return result;        
    }
    
    private void collectAllValues(E key, Collection<E> result) { 
        Collection<E> values = this.values.get(key);
        if (values != null) {
            for (E value: values) {
                if (result.add(value)) {
                	collectAllValues(value, result);
                }
            }                
        }
    }
}