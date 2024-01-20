package datastructuresalgorithms;

import java.util.Arrays;

/***
 * Heap:
 *
 * A Heap is a special Tree-based data structure in which the tree is a complete binary tree.
 * Generally, Heaps can be of two types:
 *      - Max-Heap: In a Max-Heap the key present at the root node must be greatest among the keys
 *        present at all of its children. The same property must be recursively true for all subtrees
 *        in that Binary Tree.
 *      - Min-Heap: In a Min-Heap the key present at the root node must be minimum among the keys
 *        present at all of its children. The same property must be recursively true for all subtrees
 *        in that Binary Tree.
 *
 * Properties:
 *      - Ordering: Nodes must be arranged in an order according to values. The values should follow
 *        min-heap or max-heap property
 *      - Structural: All levels in a heap should be full. In other words, it should be a complete
 *        binary tree
 *      - Array based implementation, so the last parent node index is always (n/2)-1 and the index
 *        of left child and right child of nay parent node whose index is `i` are (2i+1) and (2i+2)
 *        respectively
 *
 * Operations:
 *     - Heapify:Process to rearrange the heap in order to maintain heap-property
 *     - Find-max (or Find-min):find a maximum item of a max-heap, or a minimum item of a min-heap,
 *       respectively
 *     - Insertion:process to insert an element in existing heap time complexity O(log N)
 *     - Deletion: deleting the top element of the heap or the highest priority element, and then
 *       organizing the heap and returning the element with time complexity O(log N)
 *     - Extract Min-Max → Returning and deleting the maximum or minimum element in max-heap and
 *       min-heap respectively
 *
 * Applications:
 *     - Heap is used in the construction of priority queues. We can insert, delete, identify the
 *       highest priority element, or insert and extract with priority, among other things, in
 *       O(log N) time using a priority queue. Although data structures such as BST, AVL trees, and
 *       the Red-Black tree can accomplish the same functionalities, they are more complex than heaps.
 *       Priority queues themselves have more advanced uses, such as bandwidth control in an n/w
 *       router, prims and Dijkstra's algorithm, Huffman coding, and the BFS algorithm
 *     - Order statistics: The Heap data structure can be used to find the kth smallest / largest
 *       element in an array quickly and effectively
 *     - Heap sort is one of the fastest sorting algorithms with time complexity of O(N* log(N), and
 *       it’s easy to implement
 *     - Breadth First Search (BFS) is an informed search, where unlike the queue in Breadth-First Search,
 *       this technique is implemented using a priority queue
 *     - Patient treatment: In a hospital, an emergency patient, or the patient with more injury is
 *       treated first. Here the priority is the degree of injury
 *     - Systems concerned with security use heap sort, like the Linux kernel
 *
 * Algorithms:
 *
 * Advantages:
 *     - Less time complexity, for inserting or deleting an element in the heap the time complexity
 *       is just O(log N)
 *     - It helps to find the minimum number and greatest number
 *     - To just peek at the most prior element the time complexity is constant O(1)
 *     - Can be implemented using an array, it doesn't need any extra space for pointer
 *     - A binary heap is a balanced binary tree, and easy to implement
 *     - Heap can be created with O(N) time
 *
 * Disadvantages:
 *     - The time complexity for searching an element in Heap is O(N)
 *     - To find a successor or predecessor of an element, the heap takes O(N) time, whereas BST
 *       takes only O(log N) time
 *     - To print all elements of the heap in sorted order time complexity is O(N*log N), whereas,
 *       for BST, it takes only O(N) time
 *     - Memory management is more complex in heap memory because it is used globally. Heap memory
 *       is divided into two parts-old generations and the young generation etc. at java garbage
 *       collection
 *
 */

class MinHeap {
    private int capacity;
    private int size;
    private int[] heap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int minIndex = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] < heap[minIndex]) {
            minIndex = left;
        }

        if (right < size && heap[right] < heap[minIndex]) {
            minIndex = right;
        }

        if (i != minIndex) {
            swap(i, minIndex);
            heapifyDown(minIndex);
        }
    }

    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        heap[size] = key;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMin() {
        if (size <= 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return min;
    }

    public void print() {
        System.out.println("Min-Heap: " + Arrays.toString(Arrays.copyOf(heap, size)));
    }
}

class MaxHeap {
    private int capacity;
    private int size;
    private int[] heap;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int maxIndex = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[maxIndex]) {
            maxIndex = left;
        }

        if (right < size && heap[right] > heap[maxIndex]) {
            maxIndex = right;
        }

        if (i != maxIndex) {
            swap(i, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        heap[size] = key;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMax() {
        if (size <= 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return max;
    }

    public void print() {
        System.out.println("Max-Heap: " + Arrays.toString(Arrays.copyOf(heap, size)));
    }
}

public class TreeHeap {
    public static void main(String[] args) {
        // Example usage of MinHeap
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(8);
        minHeap.insert(2);

        minHeap.print();

        System.out.println("Min element extracted: " + minHeap.extractMin());
        minHeap.print();

        // Example usage of MaxHeap
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(5);
        maxHeap.insert(8);
        maxHeap.insert(2);

        maxHeap.print();

        System.out.println("Max element extracted: " + maxHeap.extractMax());
        maxHeap.print();
    }
}
