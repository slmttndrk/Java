package JavaTutorials;

import java.io.FileReader;
import java.io.IOException;

/**
 * try-with-resources, also referred as automatic resource management, is a new exception handling mechanism
 * that was introduced in Java 7, which automatically closes the resources used within the try catch block.\

 * Declare the required resources within the parenthesis, and the created resource will be closed automatically
 * at the end of the block

 * To use a class with try-with-resources statement it should implement AutoCloseable interface and the close() method
 * of it gets invoked automatically at runtime.

 * You can declare more than one class in try-with-resources statement.

 * While you declare multiple classes in the try block of try-with-resources statement these classes are closed in
 * reverse order.

 * Except the declaration of resources within the parenthesis everything is the same as normal try/catch block of a
 * try block.

 * The resource declared in try gets instantiated just before the start of the try-block.

 * The resource declared at the try block is implicitly declared as final.
 * */

public class TryWithResources {
    public static void main(String args[]) {
        try(FileReader fr = new FileReader("E://file.txt")) {
            char [] a = new char[50];
            fr.read(a);   // reads the content to the array
            for(char c : a)
                System.out.print(c);   // prints the characters one by one
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

