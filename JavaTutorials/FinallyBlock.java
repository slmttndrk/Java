package JavaTutorials;

/**
 * The finally block follows a try block or a catch block. A finally block of code always executes, irrespective
 * of occurrence of an Exception.

 * Using a finally block allows you to run any cleanup-type statements that you want to execute, no matter
 * what happens in the protected code.

 * A finally block appears at the end of the catch blocks
 * */

public class FinallyBlock {
    public static void main(String args[]) {
        int a[] = new int[2];
        try {
            System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
        }finally {
            a[0] = 6;
            System.out.println("First element value: " + a[0]);
            System.out.println("The finally statement is executed");
        }
    }
}
