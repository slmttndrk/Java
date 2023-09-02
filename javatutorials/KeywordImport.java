package javatutorials;

/**
 * The import Keyword
 * If a class wants to use another class in the same package, the package name need not be used.
 * Classes in the same package find each other without any special syntax.

 * What happens if the Employee class is not in the javatutorials package? The class must then use one of the following
 * techniques for referring to a class in a different package:
 * payroll.Employee
 * import payroll.*;
 * import payroll.Employee;

 * A class file can contain any number of import statements. The import statements must appear after the package
 * statement and before the class declaration.
 * */

public class KeywordImport {
    public void payEmployee(Employee e) {
        e.printEmployee();
    }
}
