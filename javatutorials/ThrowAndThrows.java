package javatutorials;

import java.rmi.RemoteException;

// The difference between throws and throw keywords, throws is used to postpone the handling of a checked
// exception and throw is used to invoke an exception explicitly.

// A method can declare that it throws more than one exception, in which case the exceptions are declared
// in a list separated by commas.

/**
 * throws RemoteException, InsufficientFundsException {}
 * */

public class ThrowAndThrows {
    public void deposit(double amount) throws RemoteException {
        // Method implementation
        throw new RemoteException();
    }
    // Remainder of class definition
}

// You can handle more than one exception using a single catch block
/**
 * catch (IOException|FileNotFoundException ex) {
 *    logger.log(ex);
 *    throw ex;
 * }
 * */