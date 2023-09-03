package javatutorials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * A collections framework is a unified architecture for representing and manipulating collections. All collections
   frameworks contain the following −

 * Interfaces − These are abstract data types that represent collections. Interfaces allow collections to be
   manipulated independently of the details of their representation. In object-oriented languages, interfaces
   generally form a hierarchy.

 * Implementations, i.e., Classes − These are the concrete implementations of the collection interfaces. In essence,
   they are reusable data structures.

 * Algorithms − These are the methods that perform useful computations, such as searching and sorting, on objects that
   implement collection interfaces. The algorithms are said to be polymorphic: that is, the same method can be used
   on many different implementations of the appropriate collection interface.

 * The Collection interface is the foundation upon which the collections framework is built. It declares the core
   methods that all collections will have.

 * Because all collections implement Collection, familiarity with its methods is necessary for a clear understanding
   of the framework. Several of these methods can throw an UnsupportedOperationException.
 * */

public class CollectionsInterface {
    public static void main(String[] args) {
        // ArrayList
        ArrayList a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);

        // LinkedList
        LinkedList l1 = new LinkedList();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);

        // HashSet
        HashSet s1 = new HashSet();
        s1.add("Zara");
        s1.add("Mahnaz");
        s1.add("Ayan");
        System.out.println();
        System.out.println(" Set Elements");
        System.out.print("\t" + s1);

        // HashMap
        HashMap m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");
        System.out.println();
        System.out.println(" Map Elements");
        System.out.print("\t" + m1);
    }
}
