package javatutorials;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This extends Collection and an instance of List stores an ordered collection of elements.
 * The List interface extends Collection and declares the behavior of a collection that stores a sequence of elements.
 * Elements can be inserted or accessed by their position in the list, using a zero-based index.
 * A list may contain duplicate elements.
 * In addition to the methods defined by Collection, List defines some of its own.
 * Several of the list methods will throw an UnsupportedOperationException if the collection cannot be modified, and
   a ClassCastException is generated when one object is incompatible with another.
 * */

public class CollectionsList {
    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);

        List l1 = new LinkedList();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);
    }
}
