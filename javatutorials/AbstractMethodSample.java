package javatutorials;

/**
 * Abstract Methods
 * abstract keyword is used to declare the method as abstract.
 * You have to place the abstract keyword before the method name in the method declaration.
 * An abstract method contains a method signature, but no method body.
 * Instead of curly braces, an abstract method will have a semicolon (;) at the end.
 * If you want a class to contain a particular method but you want the actual implementation of that method to be
 * determined by child classes, you can declare the method in the parent class as an abstract.

 * Declaring a method as abstract has two consequences:
 * The class containing it must be declared as abstract.
 * Any class inheriting the current class must either override the abstract method or declare itself as abstract.
 * */

abstract class AB {
    public abstract void print();
}

public class AbstractMethodSample extends AB {

    @Override
    public void print() {
        System.out.println("Abstract Method!");
    }

    public static void main(String[] args) {
        AbstractMethodSample ams = new AbstractMethodSample();
        ams.print();
    }
}
