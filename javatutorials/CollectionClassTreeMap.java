package javatutorials;

import java.util.Map;
import java.util.TreeMap;

/**
 * The TreeMap class implements the Map interface by using a tree. A TreeMap provides an efficient means of
   storing key/value pairs in sorted order, and allows rapid retrieval.
 * You should note that, unlike a hash map, a tree map guarantees that its elements will be sorted in an
   ascending key order.
 * */

public class CollectionClassTreeMap {
    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>();

        // Adding elements to the tree map
        treeMap.put("A", 1);
        treeMap.put("C", 3);
        treeMap.put("B", 2);

        // Getting values from the tree map
        int valueA = treeMap.get("A");
        System.out.println("Value of A: " + valueA);

        // Removing elements from the tree map
        treeMap.remove("B");

        // Iterating over the elements of the tree map
        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        }
    }
}
