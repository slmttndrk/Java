package javatutorials;

import java.util.LinkedHashSet;

/**
 * This class extends HashSet, but adds no members of its own.
 * LinkedHashSet maintains a linked list of the entries in the set, in the order in which they were inserted.
 * This allows insertion-order iteration over the set.
 * That is, when cycling through a LinkedHashSet using an iterator, the elements will be returned in the order in
   which they were inserted.
 * The hash code is then used as the index at which the data associated with the key is stored.
 * The transformation of the key into its hash code is performed automatically.

 * Look at the print order of the HashSet!
 * */

public class CollectionClassLinkedHashSet {
    public static void main(String args[]) {
        // create a hash set
        LinkedHashSet hs = new LinkedHashSet();

        // add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println(hs);
    }
}
