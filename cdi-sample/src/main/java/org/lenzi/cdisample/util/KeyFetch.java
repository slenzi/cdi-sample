/**
 * 
 */
package org.lenzi.cdisample.util;

/**
 * @author slenzi
 */
public interface KeyFetch<K,V> {
	
	public K getKey(V value);
	
}
