package datastructuresalgorithms.datastructures;

/***
 * Properties:
 *     - The insertion and deletion happens at the same end i.e. from the top of the stack
 *     - Stack is implemented through Array or Linked list
 *     - If the allocated space for stack is full, and any attempt to add more elements will lead to stack overflow.
 *       The opposite, any attempt to extract elements on an empty stack leads to stack underflow
 *
 * Operations:
 *     - Push
 *     - Pop
 *     - Peek
 *
 * Applications:
 *     - Expression evaluation and conversion
 *     - Backtracking
 *     - Function call (call stack function)
 *     - Parentheses checking
 *     - String reversal
 *     - Syntax parsing
 *     - Memory management
 *     - The celebrity problem
 *     - Iterative Tower of hanoi
 *     - Find next greater elements (frequency)(left -right)
 *
 * Algorithms:
 *
 * Advantages:
 *     - Efficient data management: Stack helps you manage the data in a LIFO
 *     - Efficient management of functions: When a function is called , the local variables are stored in stack,
 *       and it is automatically destroyed once returned
 *     - Control over memory
 *     - Smart memory management
 *     - Not easily corrupted
 *     - Does not allow resizing of variables
 *
 * Disadvantages:
 *     - Limited memory size
 *     - Chances of stack overflow
 *     - Random access not possible
 *     - Unreliable
 *     - Undesired termination
 *
 */

class ArrayStack
{
    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int size;
    private int capacity;

    public ArrayStack() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = new int[capacity];
        this.size = 0;
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void push(int value) {
        if (size == capacity) {
            expandCapacity();
        }

        array[size++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int poppedValue = array[--size];
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void expandCapacity() {
        capacity *= 2;
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}

class Node
{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack
{
    private Node top;

    public LinkedListStack() {
        this.top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class Stack
{
    public static void main(String[] args)
    {
        // using array
        ArrayStack arrayStack = new ArrayStack();

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);

        System.out.println("Stack size: " + arrayStack.size());
        System.out.println("Top element: " + arrayStack.peek());

        System.out.println("Pop: " + arrayStack.pop());
        System.out.println("Pop: " + arrayStack.pop());

        System.out.println("Stack size after pops: " + arrayStack.size());

        // using linked list
        LinkedListStack linkedListStack = new LinkedListStack();

        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);

        System.out.println("Top element: " + linkedListStack.peek());

        System.out.println("Pop: " + linkedListStack.pop());
        System.out.println("Pop: " + linkedListStack.pop());

        System.out.println("Is the stack empty? " + linkedListStack.isEmpty());
    }
}
