package javatutorials;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * The collections framework defines several algorithms that can be applied to collections and maps.
 * These algorithms are defined as static methods within the Collections class.
 * Several of the methods can throw a ClassCastException, which occurs when an attempt is made to compare incompatible
   types, or an UnsupportedOperationException, which occurs when an attempt is made to modify an unmodifiable
   collection.
 * */

public class CollectionAlgorithms {
    public static void main(String[] args) {

        // Create and initialize linked list
        LinkedList ll = new LinkedList();
        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);

        // Create a reverse order comparator
        Comparator r = Collections.reverseOrder();

        // Sort list by using the comparator
        Collections.sort(ll, r);

        // Get iterator
        Iterator li = ll.iterator();
        System.out.print("List sorted in reverse: ");

        while(li.hasNext()) {
            System.out.print(li.next() + " ");
        }
        System.out.println();
        Collections.shuffle(ll);

        // display randomized list
        li = ll.iterator();
        System.out.print("List shuffled: ");

        while(li.hasNext()) {
            System.out.print(li.next() + " ");
        }

        System.out.println();
        System.out.println("Minimum: " + Collections.min(ll));
        System.out.println("Maximum: " + Collections.max(ll));
    }
}
