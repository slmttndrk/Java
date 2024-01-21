package datastructuresalgorithms.algorithms;

/***
 * A Heap is a special Tree-based data structure in which the tree is a complete binary tree.
 * Generally, Heaps can be of two types:
 *      Max-Heap: In a Max-Heap the key present at the root node must be greatest among the keys present
 *      at all of it’s children. The same property must be recursively true for all sub-trees in that
 *      Binary Tree.
 *      Min-Heap: In a Min-Heap the key present at the root node must be minimum among the keys present
 *      at all of it’s children. The same property must be recursively true for all sub-trees in that
 *      Binary Tree.
 *
 * Properties:
 *     - Ordering: Nodes must be arranged in an order according to values. The values should follow
 *       min-heap or max-heap property
 *     - Structural: All levels in a heap should be full. In other words, it should be a complete
 *       binary tree
 *     - Array based implementation, so the last parent node index is always (n/2)-1 and the indexs of
 *       left child and right child of nay parent node whose index is `i` are (2i+1) and (2i+2)
 *       respectively
 *
 * Applications:
 *     - Heap is used in the construction of priority queues. We can insert, delete, identify the
 *       highest priority element, or insert and extract with priority, among other things, in
 *       O(log N) time using a priority queue. Although data structures such as BST, AVL trees,
 *       and the Red-Black tree can accomplish the same functionalities, they are more complex than
 *       heaps.Priority queues themselves have more advanced uses, such as bandwidth control in an
 *       n/w router, prims and Dijkstra's algorithm, Huffman coding, and the BFS algorithm
 *     - Order statistics: The Heap data structure can be used to find the kth smallest / largest
 *       element in an array quickly and effectively
 *     - Heap sort is one of the fastest sorting algorithms with time complexity of O(N* log(N), and
 *       it’s easy to implement
 *     - Best First Search (BFS) is an informed search, where unlike the queue in Breadth-First Search,
 *       this technique is implemented using a priority queue
 *     - Patient treatment: In a hospital, an emergency patient, or the patient with more injury is
 *       treated first. Here the priority is the degree of injury
 *     - Systems concerned with security use heap sort, like the Linux kernel
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
 * Advantages:
 *     - Less time complexity, for inserting or deleting an element in the heap the time complexity is
 *       just O(log N)
 *     - It helps to find the minimum number and greatest number
 *     - To just peek at the most prior element the time complexity is constant O(1)
 *     - Can be implemented using an array, it doesn’t need any extra space for pointer
 *     - A binary heap is a balanced binary tree, and easy to implement
 *     - Heap can be created with O(N) time
 *
 * Disadvantages:
 *     - The time complexity for searching an element in Heap is O(N)
 *     - To find a successor or predecessor of an element, the heap takes O(N) time, whereas BST takes
 *       only O(log N) time
 *     - To print all elements of the heap in sorted order time complexity is O(N*log N), whereas, for
 *       BST, it takes only O(N) time
 *     - Memory management is more complex in heap memory because it is used globally. Heap memory is
 *       divided into two parts-old generations and the young generation etc. at java garbage
 *       collection
 *
 */

public class SortHeap {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Original Array:");
        printArray(array);

        heapSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    static void heapSort(int[] arr) {
        int n = arr.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int root) {
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;

        // If left child is larger than root
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // If right child is larger than the largest so far
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // If the largest is not the root, swap and recursively heapify the affected subtree
        if (largest != root) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
