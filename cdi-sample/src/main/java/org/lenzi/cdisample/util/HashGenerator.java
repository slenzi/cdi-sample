/**
 * 
 */
package org.lenzi.cdisample.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Utility class for converting collections to hashes.
 * 
 * @author slenzi
 */
public class HashGenerator<K,V> {

	/**
	 * 
	 */
	public HashGenerator() { }
	
	/**
	 * 
	 * @return
	 */
	public static <K,V> HashGenerator<K,V> getInstance(){
		return new HashGenerator<K,V>();
	}
	
	/**
	 * Convert a list of objects into a hashmap using the keys from the key fetcher which can be of any type.
	 * 
	 * NOTE, you should use a key from your object that is unique, otherwise you may lose some objects
	 * in the conversion.
	 * 
	 * @param items The list of object to convert to a hashmap
	 * @param keyFetch The key predicate which returns keys to be used for the hashmap.
	 * @return
	 */
	public HashMap<K,V> toHash(List<V> items, KeyFetch<K,V> keyFetch){
		if(items == null || items.size() == 0){
			return null;
		}
		HashMap<K,V> map = new HashMap<K,V>();
		for(V val : items){
			map.put(keyFetch.getKey(val), val);
		}
		return map;
	}
	
	/**
	 * Convert a collection of objects into a hashmap using the keys from the key fetcher which can be of any type.
	 * 
	 * NOTE, you should use a key from your object that is unique, otherwise you may lose some objects
	 * in the conversion.
	 * 
	 * @param items The collection of object to convert to a hashmap
	 * @param keyFetch The key predicate which returns keys to be used for the hashmap.
	 * @return
	 */
	public HashMap<K,V> toHash(Collection<V> items, KeyFetch<K,V> keyFetch){
		if(items == null || items.size() == 0){
			return null;
		}
		HashMap<K,V> map = new HashMap<K,V>();
		for(V val : items){
			map.put(keyFetch.getKey(val), val);
		}
		return map;
	}
	
	/**
	 * Converts a collection of objects into a hashmap using keys from the key fetcher. This
	 * function maps keys to lists which is useful if your key references more than one object. 
	 * 
	 * @param items
	 * @param keyFetch
	 * @return
	 */
	public HashMap<K,List<V>> toHashList(Collection<V> items, KeyFetch<K,V> keyFetch){
		if(items == null || items.size() == 0){
			return null;
		}
		HashMap<K,List<V>> map = new HashMap<K,List<V>>();
		for(V val : items){
			if(map.get(keyFetch.getKey(val)) == null){
				// key currently maps to nothing. create new list, add value, then add to map.
				List<V> list = new ArrayList<V>();
				list.add(val);
				map.put(keyFetch.getKey(val), list);
			}else{
				// key maps to existing list. add value to list.
				map.get(keyFetch.getKey(val)).add(val);
			}
		}
		return map;		
	}
	
}
