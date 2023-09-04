package javatutorials;

import java.util.HashMap;

/**
 * The HashMap class uses a hashtable to implement the Map interface.
 * This allows the execution time of basic operations, such as get( ) and put( ), to remain constant even for large
   sets.
 * */

public class CollectionClassHashMap {
    public static void main(String[] args)
    {
        // Create an empty hash map by declaring object
        HashMap map = new HashMap();

        // Adding elements to the Map
        // using standard put() method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Print size and content of the Map
        System.out.println("Size of map is: " + map.size());

        // Printing elements in object of Map
        System.out.println(map);

        // Checking if a key is present and if
        // present, print value by passing
        // random element
        if (map.containsKey("vishal")) {

            // Mapping
            Object a = map.get("vishal");

            // Printing value for the corresponding key
            System.out.println("value for key" + " \"vishal\" is: " + a);
        }
    }
}
