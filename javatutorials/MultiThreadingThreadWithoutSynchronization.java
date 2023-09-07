package javatutorials;

/**
 * When we start two or more threads within a program, there may be a situation when multiple threads try to access
   the same resource and finally they can produce unforeseen result due to concurrency issues. For example, if
   multiple threads try to write within a same file then they may corrupt the data because one of the threads can
   override data or while one thread is opening the same file at the same time another thread might be closing the
   same file.

 * So there is a need to synchronize the action of multiple threads and make sure that only one thread can access
   the resource at a given point in time. This is implemented using a concept called monitors. Each object in Java
   is associated with a monitor, which a thread can lock or unlock. Only one thread at a time may hold a lock on a
   monitor.

 * Java programming language provides a very handy way of creating threads and synchronizing their task by using
   synchronized blocks. You keep shared resources within this block.

 * Here, the objectidentifier is a reference to an object whose lock associates with the monitor that the synchronized
   statement represents.
 * */

class PrintDemo {
    public void printCount() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Counter   ---   "  + i );
            }
        } catch (Exception e) {
            System.out.println("Thread  interrupted.");
        }
    }
}

class TThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    PrintDemo  PD;

    TThreadDemo( String name,  PrintDemo pd) {
        threadName = name;
        PD = pd;
    }

    @Override
    public void run() {
        PD.printCount();
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

public class MultiThreadingThreadWithoutSynchronization {
    public static void main(String[] args) {

        PrintDemo pd = new PrintDemo();

        TThreadDemo t1 = new TThreadDemo( "Thread - 1 ", pd );
        TThreadDemo t2 = new TThreadDemo( "Thread - 2 ", pd );

        t1.start();
        t2.start();

        // wait for threads to end
        try {
            t1.join();
            t2.join();
        } catch ( Exception e) {
            System.out.println("Interrupted");
        }
    }
}
