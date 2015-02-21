/**
 * 
 */
package org.lenzi.cdisample.util;

/**
 * @author slenzi
 */
public abstract class AbstractKeyFetch<K,V> implements KeyFetch<K,V> {

	/* (non-Javadoc)
	 * @see org.lenzi.cdisample.util.KeyFetch#getKey(java.lang.Object)
	 */
	@Override
	public abstract K getKey(V value);

}
