/**
 * 
 */
package org.lenzi.cdisample.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author slenzi
 */
public abstract class CollectionUtil {

	/**
	 * Check if the collection is empty
	 * 
	 * @param c The collection to check.
	 * @return False if the collection is not null and contains at least one element. True if the collection
	 * is null, or if the collection is empty.
	 */
	public static boolean isEmpty(Collection<?> c){
		if(c != null && c.size() > 0){
			return false;
		}
		return true;
	}
	
	/**
	 * Split a collection into a list of smaller collections.
	 *  
	 * @param input The collection  to split
	 * @param size The max number of elements in the smaller collection.
	 * @return A list of lists.
	 */
	public static <E extends Object> List<List<E>> split(Collection<E> input, int size) {
	    List<List<E>> master = new ArrayList<List<E>>();
	    if (input != null && input.size() > 0) {
	        List<E> col = new ArrayList<E>(input);
	        boolean done = false;
	        int startIndex = 0;
	        int endIndex = col.size() > size ? size : col.size();
	        while (!done) {
	            master.add(col.subList(startIndex, endIndex));
	            if (endIndex == col.size()) {
	                done = true;
	            }else {
	                startIndex = endIndex;
	                endIndex = col.size() > (endIndex + size) ? (endIndex + size) : col.size();
	            }
	        }
	    }
	    return master;
	}

}
