package javatutorials;

import java.util.HashSet;

/**
 * HashSet extends AbstractSet and implements the Set interface.
 * It creates a collection that uses a hash table for storage.
 * A hash table stores information by using a mechanism called hashing.
 * In hashing, the informational content of a key is used to determine a unique value, called its hash code.
 * The hash code is then used as the index at which the data associated with the key is stored.
 * The transformation of the key into its hash code is performed automatically.
 * */

public class CollectionClassHashSet {
    public static void main(String[] args) {
        // create a hash set
        HashSet hs = new HashSet();

        // add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println(hs);

        System.out.println("Contains D -> " + hs.contains("D"));
        System.out.println("Contains Z -> " + hs.contains("Z"));
    }
}
