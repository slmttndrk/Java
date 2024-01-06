package datastructuresalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsFramework {
    public static void main(String[] args) {
        // Java Util Collection Interface
        // ------------------------------
        // Interfaces -> Classes
        // =====================
        // List         -> ArrayList, LinkedList, Vector, Stack,
        // Queue        -> PriorityQueue, LinkedList, ArrayDeque
        // Set          -> HashSet, LinkedHashSet, TreeSet
        // Deque        -> LinkedList, ArrayDeque
        // SortedSet    -> TreeSet
        // NavigableSet -> TreeSet
        // -----------------------
        // import java.util.Interface;
        // import java.util.Class;
        // Interface<T> interface = new Class<T>();

        // ########################################

        // Java Util Map Interface
        // -----------------------
        // Interfaces -> Classes
        // =====================
        // Map          -> HashMap, LinkedHashMap, TreeMap,
        // SortedMap    -> TreeMap
        // NavigableMap -> TreeMap
        // --------------------------------
        // import java.util.Interface;
        // import java.util.Class;
        // Interface<T1, T2> interface = new Class<T1, T2>();

        // ########################################

        // Adding elements to the Collections class object
        List<String> items = new ArrayList<>();
        Collections.addAll(items, "Fruits", "Bat", "Ball");

        // Sorting a Collection
        Collections.sort(items);

        // Sorting according to reverse ordering
        Collections.sort(items, Collections.reverseOrder());

        // Searching in a Collection
        System.out.println("The index of Fruits is " + Collections.binarySearch(items, "Fruits"));

        // Copying Elements
        List<String> itemsCopy = new ArrayList<>();
        Collections.addAll(itemsCopy, "A", "B", "C", "D", "E");
        Collections.copy(itemsCopy, items);

        // Disjoint Collection
        System.out.println(Collections.disjoint(itemsCopy, items));
    }
}
