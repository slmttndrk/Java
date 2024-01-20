package datastructuresalgorithms.datastructures;

/***
 * Hash Table:
 *
 * A hash table is a type of data structure that stores key-value pairs. The key is sent to a hash
 * function that performs arithmetic operations on it. The result (commonly called the hash value
 * or hash) is the index of the key-value pair in the hash table.
 * Hashing is a technique which uses less key comparisons and searches the element in O(n) time in
 * the worst case and in an average case it will be done in O(1) time
 *
 * Components of a hash table:
 *
 * Hash function: As we’ve already seen, the hash function determines the index of our key-value pair.
 * Choosing an efficient hash function is a crucial part of creating a good hash table. You should
 * always ensure that it’s a one-way function, i.e., the key cannot be retrieved from the hash. Another
 * property of a good hash function is that it avoids producing the same hash for different keys
 *
 * Array: The array holds all the key-value entries in the table. The size of the array should be set
 * according to the amount of data expected
 *
 * Hash Function Types:
 *
 * Division method: In this the hash function is dependent upon the remainder of a division. For
 * example:-if the record 52,68,99,84 is to be placed in a hash table and let us take the table
 * size is 10.
 * h(key)=record% table size.
 *
 * Mid square method: In this method firstly key is squared and then mid-part of the result is
 * taken as the index. For example: consider that if we want to place a record of 3101 and the
 * size of table is 1000. So 3101*3101=9616201 i.e. h (3101) = 162 (middle 3 digit)
 *
 * Digit folding method: In this method the key is divided into separate parts and by using some
 * simple operations these parts are combined to produce a hash key. For example: consider a record
 * of 12465512 then it will be divided into parts i.e. 124, 655, 12. After dividing the parts combine
 * these parts by adding it.
 * H(key)=124+655+12
 *
 * Hash Function Properties:
 *
 * The hash function is easy to understand and simple to compute
 * The hash function should produce the keys which will get distributed, uniformly over an array
 * A number of collisions should be less while placing the data in the hash table
 * The hash function is a perfect hash function when it uses all the input data
 *
 * Operations:
 *     - Search: Searches an element in a hash table
 *     - Insert: inserts an element in a hash table
 *     - Delete: Deletes an element from a hash table
 *
 * Collision resolution technique:
 *
 * If there is a problem of collision occurs then it can be handled by apply some technique. These
 * techniques are called as collision resolution techniques
 *
 * Chaining: It is a method in which additional field with data i.e. chain is introduced. A chain
 * is maintained at the home bucket. In this when a collision occurs then a linked list is maintained
 * for colliding data
 *
 * Linear probing: It is very easy and simple method to resolve or to handle the collision. In this
 * collision can be solved by placing the second record linearly down, whenever the empty place is
 * found. In this method there is a problem of clustering which means at some place block of a data
 * is formed in a hash table
 *
 * Quadratic probing: This is a method in which solving of clustering problem is done. In this method
 * the hash function is defined by the H(key)=(H(key)+x*x)%table size. Let us consider we have to
 * insert following elements that are:-67, 90,55,17,49
 *
 * Double hashing: It is a technique in which two hash function are used when there is an occurrence
 * of collision. In this method 1 hash function is simple as same as division method. But for the
 * second hash function there are two important rules which are
 *      1.It must never evaluate to zero.
 *      2.Must sure about the buckets, that they are probed
 *
 * Applications:
 *     - Hash is used in databases for indexing
 *     - Hash is used in disk based data structures
 *     - In some programming languages like Python, JavaScript hash is used to implement objects
 *     - Hash is used for cache mapping for fast access of the data
 *     - Hash can be used for password verification
 *     - Hash is used in cryptography as a message digest
 *     - P1:Check if two arrays are equal or not
 *     - P2:The intersection of two unsorted array
 *     - P3:Longest Consecutive Sequence
 *     - P4:Valid Anagram
 *     - P5:Majority Element
 *     - P6:Sort characters by frequency
 *     - P7:Triplet with 0 sum
 *     - P8:First missing positive
 *     - P9:Largest subarray with 0 sum
 *     - P10:Max points on the straight line
 *
 * Algorithms:
 *
 * Advantages:
 *     - Hash provides better synchronization than other data structures
 *     - Hash tables are more efficient than search trees or other data structures
 *     - Hash provides constant time for searching, insertion and deletion operations on average
 *
 * Disadvantages:
 *     - Hash is inefficient when there are many collisions
 *     - Hash collisions are practically not be avoided for large set of possible keys
 *     - Hash does not allow null values
 *
 */

import java.util.LinkedList;

class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.7;

    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int initialCapacity) {
        this.table = new LinkedList[initialCapacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        ensureCapacity();

        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        // Check if the key already exists in the table
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update the existing key
                return;
            }
        }

        // Key does not exist, add a new entry
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index].removeIf(entry -> entry.key.equals(key));
            size--;
        }
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    private void ensureCapacity() {
        if ((double) size / table.length > LOAD_FACTOR_THRESHOLD) {
            resize();
        }
    }

    private void resize() {
        int newCapacity = table.length * 2;
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[newCapacity];

        for (LinkedList<Entry<K, V>> list : table) {
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    int index = hash(entry.key) % newCapacity;
                    if (newTable[index] == null) {
                        newTable[index] = new LinkedList<>();
                    }
                    newTable[index].add(entry);
                }
            }
        }

        table = newTable;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Example usage
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println("Value for key 'two': " + hashTable.get("two")); // Output: 2

        hashTable.remove("two");
        System.out.println("Value for key 'two' after removal: " + hashTable.get("two")); // Output: null
    }
}
