/*
/*
* Universidad del Valle de Guatemala
* Algoritmos y Estructuras de Datos
* Ing. DOuglas Barrios
* Miembros:
* - Max de Leon 13012
* - Javier Bucaro 13033
* - Kuk Ho Chung 13279
* En referencia de la pagina http://www.cs.pomona.edu/classes/cs062/bailey/structure5/Association.java
*/

package main;
import java.util.*;
import javax.swing.*;

public class Association<K,V> implements Map.Entry<K,V>{
	protected K theKey; // the key of the key-value pair
	/*
 	* The mutable value.  An arbitrary object.
    */
    protected V theValue; // the value of the key-value pair

    public Association(K key, V value){
/*
 * REVISAR ERROR EN ESTA LINEA DE CÓDIGO PROBLEMA CON EL ASSERT
 */
    	//Assert.pre(key != null, "Key must not be null.");
        theKey = key;
        theValue = value;
    }

    /*
     * Constructs a pair from a key; value is null.
     *
     * @pre key is non-null
     * @post constructs a key-value pair; value is null
     * @param key A non-null key value.
     */
    public Association(K key){
        this(key,null);
    }

    /*
     * Standard comparison function.  Comparison based on keys only.
     *
     * @pre other is non-null Association
     * @post returns true iff the keys are equal
     * @param other Another association.
     * @return true iff the keys are equal.
     */
    public boolean equals(Object other){
        Association otherAssoc = (Association)other;
        return getKey().equals(otherAssoc.getKey());
    }   
    /*
     * Standard hashcode function.
     *
     * @post return hash code association with this association
     * @return A hash code for association.
     * @see Hashtable
     */
    public int hashCode(){
        return getKey().hashCode();
    }
	    
    /*
     * Fetch value from association.  May return null.
     *
     * @post returns value from association
     * @return The value field of the association.
     */
    public V getValue(){
        return theValue;
    }
    /*
     * Fetch key from association.  Should not return null.
     *
     * @post returns key from association
     * @return Key of the key-value pair.
     */
    public K getKey(){
        return theKey;
    }
    /*
     * Sets the value of the key-value pair.
     *
     * @post sets association's value to value
     * @param value The new value.
     */
    public V setValue(V value){
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }
    /*
     * Standard string representation of an association.
     *
     * @post returns string representation
     * @return String representing key-value pair.
     */
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
	}
}