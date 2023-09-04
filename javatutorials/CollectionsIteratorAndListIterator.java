package javatutorials;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Often, you will want to cycle through the elements in a collection. For example, you might want to display each
   element. The easiest way to do this is to employ an iterator, which is an object that implements either the
   Iterator or the ListIterator interface.

 * Iterator enables you to cycle through a collection, obtaining or removing elements. ListIterator extends Iterator
   to allow bidirectional traversal of a list, and the modification of elements.

 * Before you can access a collection through an iterator, you must obtain one. Each of the collection classes
   provides an iterator( ) method that returns an iterator to the start of the collection. By using this iterator
   object, you can access each element in the collection, one element at a time.

 * In general, to use an iterator to cycle through the contents of a collection, follow these steps:
 * Obtain an iterator to the start of the collection by calling the collection's iterator( ) method.
 * Set up a loop that makes a call to hasNext( ). Have the loop iterate as long as hasNext( ) returns true.
 * Within the loop, obtain each element by calling next( ).
 * */

public class CollectionsIteratorAndListIterator {
    public static void main(String[] args) {
        // Create an array list
        ArrayList al = new ArrayList();

        // add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        // Use iterator to display contents of al
        System.out.print("Original contents of al: ");
        Iterator itr = al.iterator();

        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Modify objects being iterated
        ListIterator litr = al.listIterator();

        while(litr.hasNext()) {
            Object element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("Modified contents of al: ");
        itr = al.iterator();

        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Now, display the list backwards
        System.out.print("Modified list backwards: ");

        while(litr.hasPrevious()) {
            Object element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
