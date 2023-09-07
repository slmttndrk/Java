package javatutorials;

/**
 * Core Java provides complete control over multithreaded program. You can develop a multithreaded program which can
   be suspended, resumed, or stopped completely based on your requirements. There are various static methods which
   you can use on thread objects to control their behavior.
 * Be aware that the latest versions of Java has deprecated the usage of suspend( ), resume( ), and stop( ) methods
   and so you need to use available alternatives.
 * */

class RRunnableDemo implements Runnable {
    public Thread t;
    private String threadName;
    boolean suspended = false;

    RRunnableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 10; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(300);
                synchronized(this) {
                    while(suspended) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    void suspend() {
        suspended = true;
    }

    synchronized void resume() {
        suspended = false;
        notify();
    }
}

public class MultiThreadingThreadControl {
    public static void main(String[] args) {

        RRunnableDemo r1 = new RRunnableDemo( "Thread-1");
        r1.start();

        RRunnableDemo r2 = new RRunnableDemo( "Thread-2");
        r2.start();

        try {
            Thread.sleep(1000);
            r1.suspend();
            System.out.println("Suspending First Thread");
            Thread.sleep(1000);
            r1.resume();
            System.out.println("Resuming First Thread");

            r2.suspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            r2.resume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }try {
            System.out.println("Waiting for threads to finish.");
            r1.t.join();
            r2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}
