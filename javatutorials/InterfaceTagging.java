package javatutorials;

/**
 * The most common use of extending interfaces occurs when the parent interface does not contain any methods.
 * For example, the MouseListener interface in the java.awt.event package extended java.util.EventListener

 * An interface with no methods in it is referred to as a tagging interface. There are two basic design purposes
 * of tagging interfaces:

 * Creates a common parent − As with the EventListener interface, which is extended by dozens of other interfaces
   in the Java API, you can use a tagging interface to create a common parent among a group of interfaces.
   For example, when an interface extends EventListener, the JVM knows that this particular interface is going to be
   used in an event delegation scenario.

 * Adds a data type to a class − This situation is where the term, tagging comes from. A class that implements a
   tagging interface does not need to define any methods (since the interface does not have any), but the class
   becomes an interface type through polymorphism.
 * */

public interface InterfaceTagging {}
