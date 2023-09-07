package javatutorials;

/**
 * The second way to create a thread is to create a new class that extends Thread class using the following two simple
   steps. This approach provides more flexibility in handling multiple threads created using available methods in
   Thread class.

 * 1. You will need to override run( ) method available in Thread class. This method provides an entry point for the
   thread and you will put your complete business logic inside this method.
 * 2. Once Thread object is created, you can start it by calling start() method, which executes a call to run( ) method.
 * */

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    @Override
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class MultiThreadingExtendingThread {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo( "Thread-1");
        t1.start();

        ThreadDemo t2 = new ThreadDemo( "Thread-2");
        t2.start();
    }
}
