package javatutorials;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * WeakHashMap is an implementation of the Map interface that stores only weak references to its keys.
 * Storing only weak references allows a key-value pair to be garbage-collected when its key is no longer
   referenced outside of the WeakHashMap.
 * This class provides the easiest way to harness the power of weak references.
 * It is useful for implementing "registry-like" data structures, where the utility of an entry vanishes when
   its key is no longer reachable by any thread.
 * The WeakHashMap functions identically to the HashMap with one very important exception:
   if the Java memory manager no longer has a strong reference to the object specified as a key,
   then the entry in the map will be removed.

 * Weak Reference − If the only references to an object are weak references, the garbage collector can reclaim the
   object's memory at any time.it doesn't have to wait until the system runs out of memory. Usually, it will be
   freed the next time the garbage collector runs.
 * */

public class CollectionClassWeakHashMap {
    private static Map map;
    public static void main (String[] args) {
        map = new WeakHashMap();
        map.put("Maine", "Augusta");

        Runnable runner = new Runnable() {
            public void run() {
                while (map.containsKey("Maine")) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Thread waiting");
                    System.gc();
                }
            }
        };
        Thread t = new Thread(runner);
        t.start();
        System.out.println("Main waiting");
        try {
            t.join();
        } catch (InterruptedException ignored) {
        }
    }
}
