package javatutorials;

/**
 * The Transient Modifier
 * An instance variable is marked transient to indicate the JVM to skip the particular variable when serializing
 * the object containing it.
 * This modifier is included in the statement that creates the variable, preceding the class or data type of
 * the variable.
 * */

public class ModifierTransient {
    public transient int limit = 55;   // will not persist

    public int b;   // will persist
}
