package javatutorials;

/**
 * In Object-oriented programming, abstraction is a process of hiding the implementation details from the user, only
 * the functionality will be provided to the user. In other words, the user will have the information on what the
 * object does instead of how it does it.

 * In Java, abstraction is achieved using Abstract classes and interfaces.

 * Abstract Class
 * A class which contains the abstract keyword in its declaration is known as abstract class.
 * Abstract classes may or may not contain abstract methods, i.e., methods without body ( public void get(); )
 * But, if a class has at least one abstract method, then the class must be declared abstract.
 * If a class is declared abstract, it cannot be instantiated.
 * If you inherit an abstract class, you have to provide implementations to all the abstract methods in it.
 * To use an abstract class, you have to inherit it from another class, provide implementations to the abstract
 * methods in it.
 * */

abstract class AA {
    public void print(){
        System.out.println("Abstraction!");
    }
}

public class AbstractClassSample extends AA {
    public static void main(String[] args) {
        AbstractClassSample acs = new AbstractClassSample();
        acs.print();
    }
}
