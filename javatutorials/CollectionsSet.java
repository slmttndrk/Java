package javatutorials;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * This extends Collection to handle sets, which must contain unique elements.
 * A Set is a Collection that cannot contain duplicate elements. It models the mathematical set abstraction.
 * The Set interface contains only methods inherited from Collection and adds the restriction that duplicate elements
   are prohibited.
 * Set also adds a stronger contract on the behavior of the equals and hashCode operations, allowing Set instances
   to be compared meaningfully even if their implementation types differ.
 * */

public class CollectionsSet {
    public static void main(String[] args) {
        int[] count = {34, 22,10,60,30,22};
        Set<Integer> set = new HashSet<>();
        try {
            for(int i = 0; i < 5; i++) {
                set.add(count[i]);
            }
            System.out.println(set);

            TreeSet sortedSet = new TreeSet<>(set);
            System.out.println("The sorted list is:");
            System.out.println(sortedSet);

            System.out.println("The First element of the set is: "+ sortedSet.first());
            System.out.println("The last element of the set is: "+ sortedSet.last());
        }
        catch(Exception e) {
            System.out.println("Exception!");
        }
    }
}
