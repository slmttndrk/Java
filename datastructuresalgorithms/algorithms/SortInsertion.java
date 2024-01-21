package datastructuresalgorithms.algorithms;

/***
 * Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards
 * in your hands. The array is virtually split into a sorted and an unsorted part. Values from the
 * unsorted part are picked and placed at the correct position in the sorted part
 *
 * Properties:
 *     - This algorithm is one of the simplest algorithm with simple implementation
 *     - Basically, Insertion sort is efficient for small data values
 *     - Insertion sort is adaptive in nature, i.e. it is appropriate for data sets which are already
 *       partially sorted
 *     - Insertion sort is an in-place algorithm, meaning it requires no extra space
 *     - Maintains relative order of the input data in case of two equal values (stable)
 *     - the bubble sort performs poorly compared to the insertion sort. Due to the high number of
 *       swaps, it's expected to generate twice as many write operations and twice as many cache
 *       misses
 *     - Insertion sort's advantage is that it only scans as many elements as it needs in order to
 *       place the k+1st element, while selection sort must scan all remaining elements to find the
 *       k+1st element. Experiments show that insertion sort usually performs about half as many
 *       comparisons as selection sort
 *
 * Steps to solve the problem:
 *     - Iterate from arr[1] to arr[N] over the array
 *     - Compare the current element (key) to its predecessor
 *     - If the key element is smaller than its predecessor, compare it to the elements before. Move
 *       the greater elements one position up to make space for the swapped element
 *
 * Applications:
 *     - One more real-world example of insertion sort is how tailors arrange shirts in a cupboard,
 *       they always keep them in sorted order of size and thus insert new shirts at the right position
 *       very quickly by moving other shirts forward to keep the right place for a new shirt
 *
 * Performance:
 *     - Worst-case performance of insertion sort is O(n²) comparisons and swaps
 *     - Best-case performance is O(n) comparisons and O(1) swaps
 *     - Average-case performance is O(n²) comparisons and swaps
 *
 * Advantages:
 *     - The main advantage of the insertion sort is its simplicity. It also exhibits a good
 *       performance when dealing with a small list. The insertion sort is an in-place sorting
 *       algorithm so the space requirement is minimal
 *
 * Disadvantages:
 *     - The disadvantage of the insertion sort is that it does not perform as well as other, better
 *       sorting algorithms. With n-squared steps required for every n element to be sorted, the
 *       insertion sort does not deal well with a huge list. Therefore, the insertion sort is
 *       particularly useful only when sorting a list of few items
 *
 */

public class SortInsertion {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(array);

        insertionSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the key into its correct position
            arr[j + 1] = key;
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
