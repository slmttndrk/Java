package javatutorials;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * The SortedMap interface extends Map. It ensures that the entries are maintained in an ascending key order.
 * Several methods throw a NoSuchElementException when no items are in the invoking map.
 * A ClassCastException is thrown when an object is incompatible with the elements in a map.
 * A NullPointerException is thrown if an attempt is made to use a null object when null is not allowed in the map.
 * SortedMap has its implementation in various classes like TreeMap.
 * */

public class CollectionsSortedMap {
    public static void main(String[] args) {
        // Create a hash map
        TreeMap tm = new TreeMap();

        // Put elements to the map
        tm.put("Zara", 3434.34);
        tm.put("Mahnaz", 123.22);
        tm.put("Ayan", 1378.00);
        tm.put("Daisy", 99.22);
        tm.put("Qadir", -19.08);

        // Get a set of the entries
        Set set = tm.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}
