package javatutorials;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TreeSet provides an implementation of the Set interface that uses a tree for storage.
 * Objects are stored in a sorted and ascending order.

 * Access and retrieval times are quite fast, which makes TreeSet an excellent choice when storing large amounts
 * of sorted information that must be found quickly.
 * */

public class CollectionClassTreeSet {
    public static void main(String args[]) {
        // Create a tree set
        TreeSet ts = new TreeSet();

        // Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        System.out.println(ts);

        SortedSet tailSet = ts.tailSet("C");
        System.out.println(tailSet);

        SortedSet subSet = ts.subSet("C", "E");
        System.out.println(subSet);

    }
}
