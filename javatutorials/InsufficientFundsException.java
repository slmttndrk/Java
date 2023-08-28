package javatutorials;

/**
 * When writing your own exception classes:

 * All exceptions must be a child of Throwable.

 * If you want to write a checked exception that is automatically enforced by the Handle or Declare Rule, you
 * need to extend the Exception class.

 * If you want to write a runtime exception, you need to extend the RuntimeException class.

 * You just need to extend the predefined Exception class to create your own Exception. These are considered to be
 * checked exceptions. The following InsufficientFundsException class is a user-defined exception that extends the
 * Exception class, making it a checked exception. An exception class is like any other class, containing useful
 * fields and methods.

 * Common Exceptions
 * JVM Exceptions − These are exceptions/errors that are exclusively or logically thrown by the JVM.
 * Examples: NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException.

 * Programmatic Exceptions − These exceptions are thrown explicitly by the application or the API programmers.
 * Examples: IllegalArgumentException, IllegalStateException.

 * */

public class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
