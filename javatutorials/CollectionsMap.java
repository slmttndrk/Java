package javatutorials;

import java.util.HashMap;
import java.util.Map;

/**
 * The Map interface maps unique keys to values. A key is an object that you use to retrieve a value at a later date.
 * Given a key and a value, you can store the value in a Map object.
 * After the value is stored, you can retrieve it by using its key.
 * Several methods throw a NoSuchElementException when no items exist in the invoking map.
 * A ClassCastException is thrown when an object is incompatible with the elements in a map.
 * A NullPointerException is thrown if an attempt is made to use a null object and null is not allowed in the map.
 * An UnsupportedOperationException is thrown when an attempt is made to change an unmodifiable map.
 * Map has its implementation in various classes like HashMap.
 * */

public class CollectionsMap {
    public static void main(String[] args) {
        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");

        System.out.println();
        System.out.println(" Map Elements");
        System.out.print("\t" + m1);
    }
}
