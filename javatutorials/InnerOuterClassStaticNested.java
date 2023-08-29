package javatutorials;

/**
 * A static inner class is a nested class which is a static member of the outer class. It can be accessed
 * without instantiating the outer class, using other static members. Just like static members, a static
 * nested class does not have access to the instance variables and methods of the outer class.
 * */

public class InnerOuterClassStaticNested {
    static class NestedDemo {
        public void myMethod() {
            System.out.println("This is my nested class");
        }
    }

    public static void main(String[] args) {
        InnerOuterClassStaticNested.NestedDemo nested = new InnerOuterClassStaticNested.NestedDemo();
        nested.myMethod();
    }
}
