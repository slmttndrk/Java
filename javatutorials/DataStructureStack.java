package javatutorials;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * The Stack class implements a last-in-first-out (LIFO) stack of elements.

 * Stack is a subclass of Vector that implements a standard last-in, first-out stack.

 * Stack only defines the default constructor, which creates an empty stack. Stack includes all the methods
   defined by Vector, and adds several of its own.
 * */

public class DataStructureStack {
    static void showPush(Stack st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showPop(Stack st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }


    public static void main(String[] args) {
        Stack st = new Stack();
        System.out.println("stack: " + st);
        showPush(st, 42);
        showPush(st, 66);
        showPush(st, 99);
        showPop(st);
        showPop(st);
        showPop(st);
        try {
            showPop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}
