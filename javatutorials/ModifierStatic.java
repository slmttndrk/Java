package javatutorials;

/**
 * Static Variables
 * The static keyword is used to create variables that will exist independently of any instances created for the
 * class. Only one copy of the static variable exists regardless of the number of instances of the class.
 * Static variables are also known as class variables. Local variables cannot be declared static.

 * Static Methods
 * The static keyword is used to create methods that will exist independently of any instances created for the class.
 * Static methods do not use any instance variables of any object of the class they are defined in. Static methods
 * take all the data from parameters and compute something from those parameters, with no reference to variables.
 * Class variables and methods can be accessed using the class name followed by a dot and the name of the variable
 * or method.
 * */

public class ModifierStatic {
    private static int numInstances = 0;

    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    ModifierStatic() {
        ModifierStatic.addInstance();
    }

    public static void main(String[] arguments) {
        System.out.println("Starting with " + ModifierStatic.getCount() + " instances");

        for (int i = 0; i < 5; ++i) {
            new ModifierStatic();
        }
        System.out.println("Created " + ModifierStatic.getCount() + " instances");
    }
}
