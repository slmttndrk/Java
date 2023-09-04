package javatutorials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Comparable interface provides a compareTo() method for the ordering of objects.
 * This ordering is called the class’s natural ordering and the compareTo() method is called its natural comparison
 * method.

 * compareTo() method compares this object with an o1 object and returns an integer.
 * */

class EEEmployee implements Comparable {
    String name;
    int age;
    EEEmployee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //overridden compareTo method
    @Override
    public int compareTo(Object o) {
        return this.age - ((EEEmployee) o).age;
    }
}

public class CollectionsComparable {
    public static void main(String[] args) {
        // CREATION
        List<EEEmployee> list = new ArrayList<>();
        //INSERTION
        list.add(new EEEmployee("Krishna", 30));
        list.add(new EEEmployee("Archana", 28));
        list.add(new EEEmployee("Vineet", 25));
        list.add(new EEEmployee("Ramesh", 38));
        list.add(new EEEmployee("Alok", 28));
        System.out.println("Before sorting: ");
        for (EEEmployee e : list) {
            System.out.print("[ EMP : age = " + e.age + " ] ");
        }
        //SORTING
        Collections.sort(list);
        System.out.println("\nAfter sorting: ");
        for (EEEmployee e : list) {
            System.out.print("[ EMP : age = " + e.age + " ] ");
        }
    }
}
