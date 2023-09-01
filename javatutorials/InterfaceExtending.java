package javatutorials;

/**
 * Extending Interfaces
 * An interface can extend another interface in the same way that a class can extend another class. The extends
   keyword is used to extend an interface, and the child interface inherits the methods of the parent interface.
 * */

interface Sports {
    public void setHomeTeam(String name);
    public void setVisitingTeam(String name);
}

interface Football extends Sports {
    public void homeTeamScored(int points);
    public void visitingTeamScored(int points);
    public void endOfQuarter(int quarter);
}

/**
 * Extending Multiple Interfaces
 * A Java class can only extend one parent class. Multiple inheritance is not allowed. Interfaces are not classes,
   however, and an interface can extend more than one parent interface.
 * The extends keyword is used once, and the parent interfaces are declared in a comma-separated list.
 * */

interface Event {}

public interface InterfaceExtending extends Football, Event{
}
