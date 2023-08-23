/**
 * Each time a new object is created, at least one constructor will be invoked. The main rule of constructors
 * is that they should have the same name as the class. A class can have more than one constructor.
 * */

public class Puppy {
    public Puppy() {
    }

    public Puppy(String name) {
        // This constructor has one parameter, name.
        System.out.println("Passed Name is :" + name );
    }

    public static void main(String []args) {
        // Following statement would create an object myPuppy
        Puppy myPuppy = new Puppy( "tommy" );
    }
}

/**
 * Declaration − A variable declaration with a variable name with an object type.
 * Instantiation − The 'new' keyword is used to create the object.
 * Initialization − The 'new' keyword is followed by a call to a constructor. This call initializes the new object.
 * */