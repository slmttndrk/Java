package javatutorials;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * The entrySet( ) method declared by the Map interface returns a Set containing the map entries.
 * Each of these set elements is a Map.Entry object.
 * */

public class CollectionsMapEntry {
    public static void main(String[] args) {
        // Create a hash map
        HashMap hm = new HashMap();

        // Put elements to the map
        hm.put("Zara", 3434.34);
        hm.put("Mahnaz", 123.22);
        hm.put("Ayan", 1378.00);
        hm.put("Daisy", 99.22);
        hm.put("Qadir", -19.08);

        // Get a set of the entries
        Set set = hm.entrySet();

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
