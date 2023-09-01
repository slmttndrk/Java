package javatutorials;

/**
 * An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods.
 * A class implements an interface, thereby inheriting the abstract methods of the interface.
 * Along with abstract methods, an interface may also contain constants, default methods, static methods, and nested
   types. Method bodies exist only for default methods and static methods.
 * Writing an interface is similar to writing a class. But a class describes the attributes and behaviors of an
   object. And an interface contains behaviors that a class implements.
 * Unless the class that implements the interface is abstract, all the methods of the interface need to be defined in
   the class.
 * An interface is similar to a class in the following ways:
 * An interface can contain any number of methods.
 * An interface is written in a file with a .java extension, with the name of the interface matching the name of the
   file.
 * The byte code of an interface appears in a .class file.
 * Interfaces appear in packages, and their corresponding bytecode file must be in a directory structure that matches
   the package name.

 * However, an interface is different from a class in several ways, including:
 * You cannot instantiate an interface.
 * An interface does not contain any constructors.
 * All of the methods in an interface are abstract.
 * An interface is not extended by a class; it is implemented by a class.
 * An interface can extend multiple interfaces.
 * An interface cannot contain instance fields. The only fields that can appear in an interface must be declared both
   static and final.

 * Interfaces have the following properties:
 * An interface is implicitly abstract. You do not need to use the abstract keyword while declaring an interface.
 * Each method in an interface is also implicitly abstract, so the abstract keyword is not needed.
 * Methods in an interface are implicitly public.
 *
 * Implementing Interfaces
 * When a class implements an interface, you can think of the class as signing a contract, agreeing to perform the
   specific behaviors of the interface. If a class does not perform all the behaviors of the interface, the class
   must declare itself as abstract.

 * When overriding methods defined in interfaces, there are several rules to be followed:
 * Checked exceptions should not be declared on implementation methods other than the ones declared by the interface
   method or subclasses of those declared by the interface method.
 * The signature of the interface method and the same return type or subtype should be maintained when overriding the
   methods.
 * An implementation class itself can be abstract and if so, interface methods need not be implemented.

 * When implementation interfaces, there are several rules:
 * A class can implement more than one interface at a time.
 * A class can extend only one class, but implement many interfaces.
 * An interface can extend another interface, in a similar way as a class can extend another class.
 * */

interface AC {
    void eat();
    void travel();
}

public class InterfaceImplementing implements AC {
    public void eat() {
        System.out.println("Mammal eats");
    }

    public void travel() {
        System.out.println("Mammal travels");
    }

    public int noOfLegs() {
        return 0;
    }

    public static void main(String[] args) {
        InterfaceImplementing ii = new InterfaceImplementing();
        ii.eat();
        ii.travel();
    }
}
