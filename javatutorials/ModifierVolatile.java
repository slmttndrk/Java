package javatutorials;

/**
 * The Volatile Modifier
 * The volatile modifier is used to let the JVM know that a thread accessing the variable must always merge its own
 * private copy of the variable with the master copy in the memory.
 * Accessing a volatile variable synchronizes all the cached copied of the variables in the main memory. Volatile can
 * only be applied to instance variables, which are of type object or private. A volatile object reference can be null.

 * Usually, run() is called in one thread (the one you start using the Runnable), and stop() is called from another
 * thread. If in line 1, the cached value of active is used, the loop may not stop when you set active to false
 * in line 2. That's when you want to use volatile.
 * */

public class ModifierVolatile {
    private volatile boolean active;

    public void run() {
        active = true;
        while (active) {   // line 1
            // some code here
        }
    }

    public void stop() {
        active = false;   // line 2
    }
}
