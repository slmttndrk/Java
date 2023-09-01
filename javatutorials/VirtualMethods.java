package javatutorials;

/**
 * Here, we instantiate two Salary objects. One using a Salary reference s, and the other using an Employee reference e.

 * While invoking s.mailCheck(), the compiler sees mailCheck() in the Salary class at compile time, and the JVM
 * invokes mailCheck() in the Salary class at run time.

 * mailCheck() on e is quite different because e is an Employee reference. When the compiler sees e.mailCheck(), the
 * compiler sees the mailCheck() method in the Employee class.

 * Here, at compile time, the compiler used mailCheck() in Employee to validate this statement. At run time, however,
 * the JVM invokes mailCheck() in the Salary class.

 * This behavior is referred to as virtual method invocation, and these methods are referred to as virtual methods.
 * An overridden method is invoked at run time, no matter what data type the reference is that was used in the source
 * code at compile time.
 * */

class EEmployee{
    public void mailCheck(){}
}
class Salary extends EEmployee{
    public Salary(String name, String address, int number, double salary) {}
    @Override
    public void mailCheck(){}
}

public class VirtualMethods {
    public static void main(String [] args) {
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        EEmployee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();
        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
    }
}
