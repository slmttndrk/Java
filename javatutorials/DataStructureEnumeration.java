package javatutorials;

import java.util.Enumeration;
import java.util.Vector;

/**
 * The Enumeration
 * The Enumeration interface isn't itself a data structure, but it is very important within the context of other
   data structures. The Enumeration interface defines a means to retrieve successive elements from a data structure.

 * For example, Enumeration defines a method called nextElement that is used to get the next element in a data
   structure that contains multiple elements.

 * The Enumeration interface defines the methods by which you can enumerate (obtain one at a time) the elements in a
   collection of objects.

 * This legacy interface has been superceded by Iterator. Although not deprecated, Enumeration is considered
   obsolete for new code. However, it is used by several methods defined by the legacy classes such as Vector and
   Properties, is used by several other API classes, and is currently in widespread use in application code.
 * */

public class DataStructureEnumeration {
    public static void main(String[] args) {
        Enumeration days;
        Vector dayNames = new Vector();

        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();

        while (days.hasMoreElements()) {
            System.out.println(days.nextElement());
        }
    }
}
