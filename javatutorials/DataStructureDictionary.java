package javatutorials;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * The Dictionary class is an abstract class that defines a data structure for mapping keys to values.
 * This is useful in cases where you want to be able to access data via a particular key rather than an integer index.
 * Since the Dictionary class is abstract, it provides only the framework for a key-mapped data structure rather
   than a specific implementation.

 * Dictionary is an abstract class that represents a key/value storage repository and operates much like Map.

 * Given a key and value, you can store the value in a Dictionary object. Once the value is stored, you can retrieve
   it by using its key. Thus, like a map, a dictionary can be thought of as a list of key/value pairs.

 * */

public class DataStructureDictionary {
    public static void main(String[] args)
    {
        Dictionary<String, Integer> dict= new Hashtable<>();
        dict.put("Alice", 25);
        dict.put("Bob", 30);
        dict.put("Charlie", 35);

        System.out.println(dict.get("Bob")); // 30

        int oldValue = dict.put("Charlie", 40);
        System.out.println(oldValue); // 35

        dict.remove("Alice");

        System.out.println(dict.size()); // 2

        Enumeration<String> k = dict.keys();
        while (k.hasMoreElements()) {
            String key = k.nextElement();
            System.out.println("Key: " + key + ", Value: "
                    + dict.get(key));
        }
    }
}
