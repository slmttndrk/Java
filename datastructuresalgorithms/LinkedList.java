package datastructuresalgorithms;
/***
 * Types:
 *     - Single linked list:
 *          - A single linked list is the most common type of linked list. Each node have data and an address field
 *          that contains a reference to the next node
 *
 *     - Double linked list:
 *          - In the double linked list, there are three fields that are the previous pointer, that contain a reference
 *            to the previous node.Then there is the data, and last you have the next pointer, that contains a
 *            reference to the next node. Thus, you can go in both direction
 *     - Circular linked list:
 *          - The circular linked list is extremely similar to the single linked list. The only difference is that the
 *            last node is connected with first node, forming a circular loop in the circular linked list
 *
 * Properties:
 *     - It can be visualized as a chain of nodes where each node contains a data field and reference(address) to the
 *       next node
 *     - The first node of the linked list is called Head of the linked list. Through head, we can perform different
 *       operations on the linked list
 *     - The last node of the linked list is pointing to the NUll which indicates that it is the last node(TAIl)
 *     - Unlike arrays, linked list elements are not stored at contiguous memory locations
 *     - Linked lists are dynamic in nature
 *
 * Operations:
 *     - Insertion
 *     - Deletion
 *     - Searching
 *
 * Applications:
 *     - Implementation of stack and queue
 *     - Implementation of graphs: adjacency list representation of graphs is most popular which is uses linked list
 *       to store adjacent vertices
 *     - Dynamic memory allocation: we use linked list of free blocks
 *     - Maintaining directory of names
 *     - Performing arithmetic operations on long integers
 *     - Manipulation of polynomials by storing constant in the node of linked list
 *     - Representation of sparse matrix
 *     - Next and previous operations (Image viewer, Music player, web browser etc)
 *     - Redo and undo functionality
 *     - Most recently used section is represented by double linked list
 *     - Binary tree can also be applied by double linked list
 *
 * Algorithms:
 *
 * Advantages:
 *     - Dynamic data structure: A linked list is a dynamic arrangement, so it can be grown and shrink at runtime by
 *       allocating and deallocating memory. So there is no need to give the initial size of the linked list
 *     - No memory wastage: In the linked list, efficient memory utilization can be achieved since the size of the
 *       linked list increase or decrease at runtime so there is no memory wastage and there is no need to previous
 *       to allocate memory
 *     - Implementation: Linear data structures like stack and queue are often easily implemented using linked list
 *     - Insertion and deletion: Insertion and deletion operations are quite easier in the linked list. There is no
 *       need to shift elements after the insertion or deletion of the element only the address present in next pointer
 *       needs to be updated
 *
 * Disadvantages:
 *     - Memory usage: More memory is required in the linked list as compared to an array. Because in linked list a
 *       pointer is also required to store the address of the next element, and it requires extra memory for itself
 *     - Traversal: In a linked list traversal is more time-consuming as compared to an array. Direct access to an
 *       element is not possible in linked list as in an array by index
 *     - Reverse traversing: In a single linked list reverse traversal is not possible but in the case of double linked
 *       list, it can be possible
 *     - Random access: Random access is not possible in a linked list due to its dynamic memory allocation
 *
 */

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void addFront(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void addRear(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public int removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        int removedValue = head.data;
        head = head.next;
        return removedValue;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }
}

class DoublyLinkedList {
    private DoubleSidedNode head;
    private DoubleSidedNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addFront(int value) {
        DoubleSidedNode newNode = new DoubleSidedNode(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addRear(int value) {
        DoubleSidedNode newNode = new DoubleSidedNode(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        int removedValue = head.data;

        if (head == tail) {
            // If there's only one element, reset head and tail
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        return removedValue;
    }

    public int removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        int removedValue = tail.data;

        if (head == tail) {
            // If there's only one element, reset head and tail
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        return removedValue;
    }

    public void printList() {
        DoubleSidedNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }
}

class CircularLinkedList {
    private Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void addToEmpty(int value) {
        Node newNode = new Node(value);
        head = newNode;
        newNode.next = head;
    }

    public void addFront(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            addToEmpty(value);
        } else {
            newNode.next = head;
            Node last = getLastNode();
            last.next = newNode;
            head = newNode;
        }
    }

    public void addRear(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            addToEmpty(value);
        } else {
            Node last = getLastNode();
            newNode.next = head;
            last.next = newNode;
        }
    }

    public int removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        int removedValue = head.data;

        if (head.next == head) {
            // If there's only one element, reset head to null
            head = null;
        } else {
            Node last = getLastNode();
            head = head.next;
            last.next = head;
        }

        return removedValue;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }

    private Node getLastNode() {
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        return current;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        // singly linked list
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addFront(3);
        singlyLinkedList.addFront(2);
        singlyLinkedList.addFront(1);

        singlyLinkedList.addRear(4);
        singlyLinkedList.addRear(5);

        singlyLinkedList.printList();

        System.out.println("Remove front: " + singlyLinkedList.removeFront());

        singlyLinkedList.printList();

        // Doubly linked list
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addFront(3);
        doublyLinkedList.addFront(2);
        doublyLinkedList.addFront(1);

        doublyLinkedList.addRear(4);
        doublyLinkedList.addRear(5);

        doublyLinkedList.printList();

        System.out.println("Remove front: " + doublyLinkedList.removeFront());
        System.out.println("Remove rear: " + doublyLinkedList.removeRear());

        doublyLinkedList.printList();

        // Circular linked list
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.addFront(1);
        circularLinkedList.addRear(3);
        circularLinkedList.addFront(2);

        circularLinkedList.printList();

        System.out.println("Remove front: " + circularLinkedList.removeFront());

        circularLinkedList.printList();
    }
}
