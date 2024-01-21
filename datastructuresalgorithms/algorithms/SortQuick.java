package datastructuresalgorithms.algorithms;

/***
 * Quick sort is a fast sorting algorithm used to sort a list of elements. Quick sort algorithm is
 * invented by C. A. R. Hoare.
 * The quick sort algorithm attempts to separate the list of elements into two parts and then sort
 * each part recursively. That means it use divide and conquer strategy. In quick sort, the partition
 * of the list is performed based on the element called pivot. Here pivot element is one of the
 * elements in the list.
 * The list is divided into two partitions such that "all elements to the left of pivot are smaller
 * than the pivot and all elements to the right of pivot are greater than or equal to the pivot".
 *
 * Steps to solve the problem:
 *     - quickSort(arr, left, right)
 *     - if right > left
 *     - pivotIndex = partition(arr, left, right)
 *     - quickSort(arr, left, pivotIndex-1)
 *     - quickSort(arr, pivotIndex+1, right)
 *     - Below Partition Flow
 *          - Consider the first element of the list as pivot (i.e., Element at first position in the
 *            list)
 *          - Define two variables i and j. Set i and j to first and last elements of the list
 *            respectively
 *          - Increment i until list[i] < pivot then stop
 *          - Decrement j until list[j] > pivot then stop
 *          - If i < j then exchange list[i] and list[j]
 *          - Repeat steps 3,4 & 5 until i > j
 *          - Exchange the pivot element with list[j] element and return j
 *
 * Properties:
 *     - Quick Sort is useful for sorting arrays
 *     - In efficient implementations Quick Sort is not a stable sort, meaning that the relative
 *       order of equal sort items is not preserved
 *     - Overall time complexity of Quick Sort is O(nlogn). In the worst case, it makes O(n**2)
 *       comparisons, though this behavior is rare
 *     - The space complexity of Quick Sort is O(logn). It is an in-place sort (i.e. it doesn't
 *       require any extra storage)
 *
 * Applications:
 *     - Commercial Computing is used in various government and private organizations for the purpose
 *       of sorting various data like sorting files by name/date/price, sorting of students by their
 *       roll no., sorting of account profile by given id, etc.
 *     - The sorting algorithm is used for information searching and as Quicksort is the fastest
 *       algorithm so it is widely used as a better way of searching
 *     - It is used everywhere where a stable sort is not needed
 *     - Quicksort is a cache-friendly algorithm as it has a good locality of reference when used
 *       for arrays
 *     - It is tail -recursive and hence all the call optimization can be done
 *     - It is an in-place sort that does not require any extra storage memory
 *     - Variants of Quicksort are used to separate the Kth smallest or largest elements
 *
 * Performance:
 *     - Worst Case Time Complexity [ Big-O ]: O(n**2)
 *     - Best Case Time Complexity [Big-omega]: O(nlog n)
 *     - Average Time Complexity [Big-theta]: O(nlog n)
 *     - Space Complexity: O(logn)
 *
 * Advantages:
 *     - It is in-place since it uses only a small auxiliary stack
 *     - It requires only n (log n) time to sort n items
 *     - It has an extremely short inner loop
 *
 * Disadvantages:
 *     - It is recursive. Especially, if recursion is not available, the implementation is extremely
 *       complicated
 *     - It requires quadratic (i.e., n**2) time in the worst-case
 *     - It is fragile, i.e. a simple mistake in the implementation can go unnoticed and cause it to
 *       perform badly
 *
 */

public class SortQuick {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the pivot index such that elements smaller than pivot are on the left
            // and elements greater than pivot are on the right
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the two halves
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the rightmost element as the pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (put the pivot in its correct position)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the index of the pivot
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
