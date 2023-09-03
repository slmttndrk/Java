package javatutorials;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * The Hashtable class provides a means of organizing data based on some user-defined key structure.
 * For example, in an address list hash table you could store and sort data based on a key such as ZIP code rather
   than on a person's name.
 * The specific meaning of keys with regard to hash tables is totally dependent on the usage of the hash table and
   the data it contains.

 * Hashtable was part of the original java.util and is a concrete implementation of a Dictionary.

 * However, Java 2 re-engineered Hashtable so that it also implements the Map interface. Thus, Hashtable is now
   integrated into the collections framework. It is similar to HashMap, but is synchronized.

 * Like HashMap, Hashtable stores key/value pairs in a hash table. When using a Hashtable, you specify an object
   that is used as a key, and the value that you want linked to that key. The key is then hashed, and the resulting
   hash code is used as the index at which the value is stored within the table.
 * */

public class DataStructureHashtable {
    public static void main(String[] args) {
        // Create a hash map
        Hashtable balance = new Hashtable();
        Enumeration names;
        String str;
        double bal;

        balance.put("Zara", 3434.34);
        balance.put("Mahnaz", 123.22);
        balance.put("Ayan", 1378.00);
        balance.put("Daisy", 99.22);
        balance.put("Qadir", -19.08);

        // Show all balances in hash table.
        names = balance.keys();

        while(names.hasMoreElements()) {
            str = (String) names.nextElement();
            System.out.println(str + ": " + balance.get(str));
        }
        System.out.println();

        // Deposit 1,000 into Zara's account
        bal = ((Double)balance.get("Zara"));
        balance.put("Zara", bal + 1000);
        System.out.println("Zara's new balance: " + balance.get("Zara"));
    }
}
