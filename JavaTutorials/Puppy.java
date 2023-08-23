package JavaTutorials;

/**
 * Each time a new object is created, at least one constructor will be invoked. The main rule of constructors
 * is that they should have the same name as the class. A class can have more than one constructor.
 * */

public class Puppy {
    int puppyAge;

    public Puppy(String name) {
        // This constructor has one parameter, name.
        System.out.println("Name chosen is :" + name );
    }

    public void setAge( int age ) {
        puppyAge = age;
    }

    public int getAge( ) {
        System.out.println("JavaTutorials.Puppy's age is :" + puppyAge );
        return puppyAge;
    }

    public static void main(String []args) {
        /* Object creation */
        Puppy myPuppy = new Puppy( "tommy" );

        /* Call class method to set puppy's age */
        myPuppy.setAge( 2 );

        /* Call another class method to get puppy's age */
        myPuppy.getAge( );

        /* You can access instance variable as follows as well */
        System.out.println("Variable Value :" + myPuppy.puppyAge );
    }
}

/**
 * Declaration − A variable declaration with a variable name with an object type.
 * Instantiation − The 'new' keyword is used to create the object.
 * Initialization − The 'new' keyword is followed by a call to a constructor. This call initializes the new object.
 * */