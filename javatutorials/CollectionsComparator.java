package javatutorials;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The Comparator interface provides the methods for performing sorting operations.
 * By using the Comparator interface we can do multiple sorting sequences.
 * We can sort the objects with respect to multiple data members.

 * compare() method compares the first object with the second object and returns an integer
 * */

class Student {
    String name;
    int age, roll;
    Student(String name, int age, int roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
    }
}
class AgeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Student) o1).age - ((Student) o2).age;
    }
}
class RollComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((Student) o1).roll - ((Student) o2).roll;
    }
}

public class CollectionsComparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Ramesh", 30, 20));
        list.add(new Student("Adithya", 7, 10));
        list.add(new Student("Krishna", 25, 5));
        list.add(new Student("Vineet", 24, 15));
        System.out.println("BEFORE SORTING");
        for (Student e : list) {
            System.out.println("[ STU : name = " + e.name + " age = " + e.age + " roll = " + e.roll + "]");
        }
        Collections.sort(list,new AgeComparator());
        System.out.println("AFTER SORTING WITH AGE");
        for (Student e : list) {
            System.out.println("[ STU : name = " + e.name + " age = " + e.age + " ]");
        }
        Collections.sort(list,new RollComparator());
        System.out.println("AFTER SORTING WITH ROLL");
        for (Student e : list) {
            System.out.println("[ STU : name = " + e.name + " roll = " + e.roll + " ]");
        }
    }

}
