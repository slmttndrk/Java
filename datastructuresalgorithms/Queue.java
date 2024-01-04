package datastructuresalgorithms;
/***
 * Properties:
 *
 * Operations:
 *     - Enqueue
 *     - Dequeue
 *     - Peek
 *
 * Applications:
 *     - Multi programming: Multi programming means when multiple programs are running in the main memory. It is
 *       essential to organize these multiple programs are organized as queues
 *     - Network: In a network , a queue is used in devices such as a router or a switch. Another application of a
 *       queue is a mail queue
 *     - Job Scheduling: The computer has a task to execute a particular number of jobs that are scheduled to be
 *       executed one after another. These jobs are assigned one by one to the processor which is organized using a
 *       queue
 *     - Shared resources: Queues are used as waiting lists for a single resource
 *     - Breadth first traversal or BFS
 *     - Level order tree traversal
 *     - Reverse a path in BST using queue
 *     - Construct complete binary tree from its link list representation
 *     - Number of siblings of a given Node in n-ary tree
 *     - Zig-zag tree traversal
 *
 * Algorithms:
 *
 * Advantages:
 *     - A large amount of data can be managed efficiently with ease
 *     - Operations such as insertion and deletion can be performed with ease as it follows the first in first out rule
 *     - Queues are useful when a particular service is used by multiple customers
 *     - Queues are fast in speed for data inter process communication
 *     - Queues can be used in the implementation of other data structures
 *
 * Disadvantages:
 *     - The operations such as insertion and deletion of elements from the middle are time consuming
 *     - Limited space
 *     - In classical queue, a new element can only be inserted when the existing elements are deleted from the queue
 *     - Searching an elements takes O(N) time
 *     - Maximum size of a queue must be defined prior
 *
 */

class ArrayQueue
{
    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        this.array = new int[DEFAULT_CAPACITY];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int value) {
        if (size == array.length) {
            expandCapacity();
        }

        rear = (rear + 1) % array.length;
        array[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int dequeuedValue = array[front];
        front = (front + 1) % array.length;
        size--;
        return dequeuedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void expandCapacity() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }

        array = newArray;
        front = 0;
        rear = size - 1;
    }
}

class LinkedListQueue
{
    private Node front;
    private Node rear;
    private int size;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            // If the queue is empty, both front and rear point to the new node
            front = newNode;
            rear = newNode;
        } else {
            // Otherwise, add the new node to the rear and update rear
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int dequeuedValue = front.data;
        front = front.next;

        if (front == null) {
            // If the queue becomes empty after dequeue, update rear to null
            rear = null;
        }

        size--;
        return dequeuedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return front.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class Queue
{
    public static void main(String[] args)
    {
        // using array
        ArrayQueue arrayQueue = new ArrayQueue();

        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);

        System.out.println("Queue size: " + arrayQueue.size());
        System.out.println("Front element: " + arrayQueue.peek());

        System.out.println("Dequeue: " + arrayQueue.dequeue());
        System.out.println("Dequeue: " + arrayQueue.dequeue());

        System.out.println("Queue size after dequeues: " + arrayQueue.size());

        // using linked list
        LinkedListQueue linkedListQueue = new LinkedListQueue();

        linkedListQueue.enqueue(1);
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(3);

        System.out.println("Front element: " + linkedListQueue.peek());

        System.out.println("Dequeue: " + linkedListQueue.dequeue());
        System.out.println("Dequeue: " + linkedListQueue.dequeue());

        System.out.println("Is the queue empty? " + linkedListQueue.isEmpty());
    }
}
