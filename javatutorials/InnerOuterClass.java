package javatutorials;

/**
 * Nested classes are divided into two types:

 * 1. Non-static nested classes − These are the non-static members of a class.
 * 2. Static nested classes − These are the static members of a class.

 * Inner classes(non-static nested classes) are a security mechanism in Java. We know a class cannot be associated with
 * the access modifier private, but if we have the class as a member of other class, then the inner class can be made
 * private. And this is also used to access the private members of a class.

 * Inner classes are of three types depending on how and where you define them. They are:

 * 1. Inner Class
 * 2. Method-local Inner Class
 * 3. Anonymous Inner Class

 * Unlike a class, an inner class can be private and once you declare an inner class private, it cannot be
 * accessed from an object outside the class.
 * */

class OuterDemo {
    int num;

    // inner class
    private class InnerDemo {
        public void print() {
            System.out.println("This is an inner class");
        }
    }

    // Accessing the inner class from the method within
    void displayInner() {
        InnerDemo inner = new InnerDemo();
        inner.print();
    }
}

public class InnerOuterClass {
    public static void main(String[] args) {
        // Instantiating the outer class
        OuterDemo outer = new OuterDemo();

        // Accessing the displayInner() method.
        outer.displayInner();
    }
}
