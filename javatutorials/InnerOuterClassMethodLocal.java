package javatutorials;

/**
 * A class within a method and this will be a local type. Like local variables, the scope of the inner class is
 * restricted within the method.

 * A method-local inner class can be instantiated only within the method where the inner class is defined.
 * */

public class InnerOuterClassMethodLocal {
    // instance method of the outer class
    void myMethod() {
        int num = 23;

        // method-local inner class
        class MethodInnerDemo {
            public void print() {
                System.out.println("This is method inner class "+num);
            }
        } // end of inner class

        // Accessing the inner class
        MethodInnerDemo inner = new MethodInnerDemo();
        inner.print();
    }

    public static void main(String[] args) {
        InnerOuterClassMethodLocal outer = new InnerOuterClassMethodLocal();
        outer.myMethod();
    }
}
