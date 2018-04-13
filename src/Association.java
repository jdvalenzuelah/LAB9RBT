/**
 * @author David Valenzuela 171001
 * @author Fernando Hegnstenberg 17699
 * @author 2001 duane a. bailey
 *
 * @param <K>
 * @param <V>
 */
public class Association<K extends Comparable<K>, V> implements Comparable<K> {

	/**
	 * the key of the key-value pair
	 */
	protected K theKey; 
	
	/**
	 * the value of the key-value pair
	 */
	protected V theValue;
	
	/**
	 * pre: key is non-null
	 *post: constructs a key-value pair
	 * @param key
	 * @param value
	 */
	public Association(K key, V value){
	if(key != null) {
		theKey = key;
		theValue = value;
	}
	}
	
	/**
	 * pre: key is non-null
	// post: constructs a key-value pair; value is null
	 * @param key C
	 */
	public Association(K key)	{
	this(key,null);
	}

	/**
	 * @return the theKey
	 */
	public K getTheKey() {
		return theKey;
	}

	/**
	 * @param theKey the theKey to set
	 */
	public void setTheKey(K theKey) {
		this.theKey = theKey;
	}

	/**
	 * @return the theValue
	 */
	public V getTheValue() {
		return theValue;
	}

	/**
	 * @param theValue the theValue to set
	 */
	public void setTheValue(V theValue) {
		this.theValue = theValue;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(K arg0) {
		return this.theKey.compareTo(arg0);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.theKey.toString() + ": " + this.theValue.toString();
	}
}
