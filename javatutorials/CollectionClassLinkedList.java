package javatutorials;

import java.util.LinkedList;

/**
 * The Collection Classes
 * Java provides a set of standard collection classes that implement Collection interfaces. Some of the classes
 * provide full implementations that can be used as-is and others are abstract class, providing skeletal
 * implementations that are used as starting points for creating concrete collections.

 * The LinkedList class extends AbstractSequentialList and implements the List interface.
 * It provides a linked-list data structure.
 * */

public class CollectionClassLinkedList {
    public static void main(String[] args) {
        // create a linked list
        LinkedList ll = new LinkedList();

        // add elements to the linked list
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2");
        System.out.println("Original contents of ll: " + ll);

        // remove elements from the linked list
        ll.remove("F");
        ll.remove(2);
        System.out.println("Contents of ll after deletion: " + ll);

        // remove first and last elements
        ll.removeFirst();
        ll.removeLast();
        System.out.println("ll after deleting first and last: " + ll);

        // get and set a value
        Object val = ll.get(2);
        ll.set(2, (String) val + " Changed");
        System.out.println("ll after change: " + ll);
    }
}
