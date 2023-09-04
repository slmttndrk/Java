package javatutorials;

import java.util.LinkedHashMap;

/**
 *
 * */

public class CollectionClassLinkedHashMap {
    public static void main(String[] args)
    {

        LinkedHashMap hm1 = new LinkedHashMap();

        // Add mappings to Map
        // using put() method
        hm1.put(3, "Geeks");
        hm1.put(2, "For");
        hm1.put(1, "Geeks");

        // Printing mappings to the console
        System.out.println("Mappings of LinkedHashMap : " + hm1);
    }
}
