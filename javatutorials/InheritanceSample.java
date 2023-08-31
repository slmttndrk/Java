package javatutorials;

/**
 * Inheritance can be defined as the process where one class acquires the properties (methods and fields) of another.
 * With the use of inheritance the information is made manageable in a hierarchical order.

 * The class which inherits the properties of other is known as subclass (derived class, child class) and the class
 * whose properties are inherited is known as superclass (base class, parent class).
 * */

class Inheritance {
    int z;

    public void addition(int x, int y) {
        z = x + y;
        System.out.println("The sum of the given numbers:"+z);
    }

    public void subtraction(int x, int y) {
        z = x - y;
        System.out.println("The difference between the given numbers:"+z);
    }
}

public class InheritanceSample extends Inheritance{
    public void multiplication(int x, int y) {
        z = x * y;
        System.out.println("The product of the given numbers:"+z);
    }

    public static void main(String[] args) {
        int a = 20, b = 10;
        InheritanceSample demo = new InheritanceSample();
        demo.addition(a, b);
        demo.subtraction(a, b);
        demo.multiplication(a, b);
    }
}
