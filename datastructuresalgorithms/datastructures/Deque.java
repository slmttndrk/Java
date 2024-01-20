package datastructuresalgorithms.datastructures;

/***
 * Properties:
 *     - Double-ended queue == deque
 *     - Deque is a linear data structure that allows insertion and deletion at both ends
 *     - It can be implemented using an array or a linked list
 *     - Maintains the order of elements, allowing First In, First Out (FIFO) and Last In, First Out (LIFO) operations
 *     - Provides access to both the front and rear elements
 *
 * Operations:
 *     - AddFront
 *     - AddRear
 *     - RemoveFront
 *     - RemoveRear
 *     - PeekFront
 *     - PeekRear
 *
 * Applications:
 *     - Useful when elements need to be added or removed from both ends efficiently
 *     - Deques can be used in task scheduling algorithms where tasks can be added to either end based on priority
 *     - Deques can be employed in undo mechanisms where actions can be undone by popping from either end
 *
 * Algorithms:
 *     - Breadth-First Search (BFS)
 *     - Sliding Window Maximum
 *
 * Advantages:
 *     - Deques provide efficient operations for adding and removing elements from both ends
 *     - Suited for scenarios where elements need to be accessed and modified at both ends
 *
 * Disadvantages:
 *     - Implementation using arrays may lead to memory overhead, especially when resizing is required
 *     - Implementing and maintaining a deque may be more complex compared to a simpler data structures
 *
 */

class ArrayDeque{
    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayDeque() {
        this.array = new int[DEFAULT_CAPACITY];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public void addFront(int value) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            // Wrap around to the end of the array if front is at the beginning
            front = array.length - 1;
        } else {
            front--;
        }

        array[front] = value;
        size++;
    }

    public void addRear(int value) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == array.length - 1) {
            // Wrap around to the beginning of the array if rear is at the end
            rear = 0;
        } else {
            rear++;
        }

        array[rear] = value;
        size++;
    }

    public int removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        int removedValue = array[front];

        if (front == rear) {
            // If there's only one element, reset front and rear
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % array.length;
        }

        size--;
        return removedValue;
    }

    public int removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        int removedValue = array[rear];

        if (front == rear) {
            // If there's only one element, reset front and rear
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            // Wrap around to the end of the array if rear is at the beginning
            rear = array.length - 1;
        } else {
            rear--;
        }

        size--;
        return removedValue;
    }

    public int peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        return array[front];
    }

    public int peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        return array[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}

class DoubleSidedNode {
    int data;
    DoubleSidedNode next;
    DoubleSidedNode prev;

    public DoubleSidedNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedListDeque {
    private DoubleSidedNode front;
    private DoubleSidedNode rear;
    private int size;

    public LinkedListDeque() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void addFront(int value) {
        DoubleSidedNode newNode = new DoubleSidedNode(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        size++;
    }

    public void addRear(int value) {
        DoubleSidedNode newNode = new DoubleSidedNode(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public int removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        int removedValue = front.data;

        if (front == rear) {
            // If there's only one element, reset front and rear
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }

        size--;
        return removedValue;
    }

    public int removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        int removedValue = rear.data;

        if (front == rear) {
            // If there's only one element, reset front and rear
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }

        size--;
        return removedValue;
    }

    public int peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        return front.data;
    }

    public int peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }

        return rear.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class Deque {
    public static void main(String[] args) {
        // using array
        ArrayDeque arrayDeque = new ArrayDeque();

        arrayDeque.addFront(1);
        arrayDeque.addFront(2);
        arrayDeque.addRear(3);

        System.out.println("Front element: " + arrayDeque.peekFront());
        System.out.println("Rear element: " + arrayDeque.peekRear());

        System.out.println("Remove front: " + arrayDeque.removeFront());
        System.out.println("Remove rear: " + arrayDeque.removeRear());

        System.out.println("Is the deque empty? " + arrayDeque.isEmpty());

        // using linked list
        LinkedListDeque linkedListDeque = new LinkedListDeque();

        linkedListDeque.addFront(1);
        linkedListDeque.addFront(2);
        linkedListDeque.addRear(3);

        System.out.println("Front element: " + linkedListDeque.peekFront());
        System.out.println("Rear element: " + linkedListDeque.peekRear());

        System.out.println("Remove front: " + linkedListDeque.removeFront());
        System.out.println("Remove rear: " + linkedListDeque.removeRear());

        System.out.println("Is the deque empty? " + linkedListDeque.isEmpty());
    }
}
