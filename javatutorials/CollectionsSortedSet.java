package javatutorials;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The SortedSet interface extends Set and declares the behavior of a set sorted in an ascending order.
 * Several methods throw a NoSuchElementException when no items are contained in the invoking set.
 * A ClassCastException is thrown when an object is incompatible with the elements in a set.
 * A NullPointerException is thrown if an attempt is made to use a null object and null is not allowed in the set.
 * SortedSet have its implementation in various classes like TreeSet.
 * */

public class CollectionsSortedSet {
    public static void main(String[] args) {
        // Create the sorted set
        SortedSet set = new TreeSet();

        // Add elements to the set
        set.add("b");
        set.add("c");
        set.add("a");

        // Iterating over the elements in the set
        Iterator it = set.iterator();

        while (it.hasNext()) {
            // Get element
            Object element = it.next();
            System.out.println(element.toString());
        }
    }
}
