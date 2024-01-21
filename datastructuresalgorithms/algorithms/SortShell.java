package datastructuresalgorithms.algorithms;

/***
 * Shell sort is mainly a variation of Insertion Sort. In insertion sort, we move elements only one
 * position ahead. When an element has to be moved far ahead, many movements are involved. The idea of
 * ShellSort is to allow the exchange of far items. In Shell sort, we make the array gap-sorted for a
 * large value of gap. We keep reducing the value of gap until it becomes 1. An array is said to be
 * gap-sorted if all sublists of every gap’th element are sorted.
 *
 * Steps to solve the problem:
 *     - Initialize the value of gap size. Example: gap
 *     - Divide the list into smaller sub-part. Each must have equal intervals to gap
 *     - Sort these sub-lists using insertion sort
 *     - Repeat this step 2 until the list is sorted and gap size is 1
 *
 * Properties:
 *     - Comparison-based sorting technique
 *     - Inplace sorting technique just like insertion sort
 *     - Works very well for medium-sized datasets
 *     - Unstable sorting technique
 *
 * Applications:
 *     - Shell sort is a replacement of insertion sort when insertion sort is taking too much execution
 *       time
 *     - We use shell sort when the call of the stack is overhead
 *     - Shell sort is applicable when recursion exceeds a particular limit
 *
 * Performance:
 *     - Worst Case Complexity: less than or equal to O(n2)
 *     - Best Case Complexity: O(n*log n)
 *     - Average Case Complexity: O(n*log n) It is around O(n1.25).
 *     - Note: The complexity depends on the interval chosen. The above complexities differ for
 *       different increment sequences chosen. Best increment sequence is unknown
 *
 * Advantages:
 *     - Shell sort algorithm is only efficient for finite number of elements in an array
 *     - Shell sort algorithm is 5.32 x faster than bubble sort algorithm
 *
 * Disadvantages:
 *     - Shell sort algorithm is complex in structure and bit more difficult to understand
 *     - Shell sort algorithm is significantly slower than the merge sort, quick sort and heap sort
 *       algorithms
 *
 */

public class SortShell {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(array);

        shellSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a large gap and reduce it
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform insertion sort for the elements at a given gap
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
