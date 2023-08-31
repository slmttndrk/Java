package javatutorials;

/**
 * If a class inherits a method from its superclass, then there is a chance to override the method provided that
 * it is not marked final.
 * The benefit of overriding is: ability to define a behavior that's specific to the subclass type, which means
 * a subclass can implement a parent class method based on its requirement.

 * you can see that even though b is a type of AAnimal it runs the move method in the DDog class. The reason for this
 * is: In compile time, the check is made on the reference type. However, in the runtime, JVM figures out
 * the object type and would run the method that belongs to that particular object.

 * Therefore, in the example, the program will compile properly since AAnimal class has the method move. Then,
 * at the runtime, it runs the method specific for that object.

 * But, this program will throw a compile time error since b's reference type AAnimal doesn't have a method by
 * the name of bark.

 * Rules for Method Overriding
 * The argument list should be exactly the same as that of the overridden method.

 * The return type should be the same or a subtype of the return type declared in the original overridden method
 * in the superclass.

 * The access level cannot be more restrictive than the overridden method's access level. For example: If the
 * superclass method is declared public then the overriding method in the subclass cannot be either
 * private or protected.

 * Instance methods can be overridden only if they are inherited by the subclass.

 * A method declared final cannot be overridden.

 * A method declared static cannot be overridden but can be re-declared.

 * If a method cannot be inherited, then it cannot be overridden.

 * A subclass within the same package as the instance's superclass can override any superclass method that is not
 * declared private or final.

 * A subclass in a different package can only override the non-final methods declared public or protected.

 * An overriding method can throw any uncheck exceptions, regardless of whether the overridden method throws exceptions
 * or not. However, the overriding method should not throw checked exceptions that are new or broader than the ones
 * declared by the overridden method. The overriding method can throw narrower or fewer exceptions than the overridden
 * method.

 * Constructors cannot be overridden.
 * */

class AAnimal {
    public void move() {
        System.out.println("Animals can move");
    }
}

class DDog extends AAnimal {
    @Override
    public void move() {
        System.out.println("Dogs can walk and run");
    }
    public void bark() {
        System.out.println("Dogs can bark");
    }
}

public class OverridingSample {
    public static void main(String[] args) {
        AAnimal a = new AAnimal();   // Animal reference and object
        AAnimal b = new DDog();   // Animal reference but Dog object

        a.move();   // runs the method in Animal class
        b.move();   // runs the method in Dog class
        //b.bark();   // error: cannot find symbol >> variable b of type Animal
    }
}
