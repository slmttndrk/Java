package javatutorials;

/**
 * Abstract Class
 * An abstract class can never be instantiated. If a class is declared as abstract then the sole purpose is for
 * the class to be extended.
 * A class cannot be both abstract and final (since a final class cannot be extended). If a class contains abstract
 * methods then the class should be declared abstract. Otherwise, a compile error will be thrown.
 * An abstract class may contain both abstract methods as well normal methods.

 * Abstract Methods
 * An abstract method is a method declared without any implementation. The methods body (implementation) is provided
 * by the subclass. Abstract methods can never be final or strict.
 * Any class that extends an abstract class must implement all the abstract methods of the super class, unless the
 * subclass is also an abstract class.
 * If a class contains one or more abstract methods, then the class must be declared abstract. An abstract class does
 * not need to contain abstract methods.
 * The abstract method ends with a semicolon. Example: public abstract sample();
 * */

abstract class Modifier {
    private double price;
    private String model;
    private String year;
    public abstract void goFast();   // an abstract method
    public abstract void changeColor();
}

public class ModifierAbstract extends Modifier {
    public void goFast() {
        //TODO
    }
    public void changeColor() {
        //TODO
    }
}
