package datastructuresalgorithms.algorithms;

/***
 * Counting sort is a sorting algorithm that sorts the elements of an array by counting the number of
 * occurrences of each unique element in the array. The count is stored in an auxiliary array and the
 * sorting is done by mapping the count as an index of the auxiliary array.
 *
 * Steps to solve the problem:
 *     - Iterate through the input array to find the highest value
 *     - Declare a new array with the value 0 and a size of max+1
 *     - Count each element in the array and increment its value in the auxiliary array generated at
 *       the corresponding index
 *     - Add current and previous frequency to the auxiliary array to find the cumulative sum
 *     - The cumulative value now represents the element's actual position in the sorted input array
 *     - Begin iterating through the auxiliary array from 0 to max
 *     - Put 0 at the corresponding index and reduce the count by 1, which will indicate the element's
 *       second position in the input array if it exists
 *     - Now put the array you got in the previous step into the actual input array
 *
 * Properties:
 *     - Like other algorithms this sorting algorithm is not a comparison-based algorithm, it hashes
 *       the value in a temporary count array and uses them for sorting
 *     - It uses a temporary array making it a non In Place algorithm
 *     - Counting sort is not a stable algorithm. But it can be made stable with some code changes
 *     - It is often used as a sub-routine to another sorting algorithm like radix sort
 *     - Counting sort can be extended to work for negative inputs also
 *
 * Applications:
 *     - If the range of input data is not much bigger than the number of objects to be sorted,
 *       counting sort is efficient
 *     - Consider the following scenario: the data is 10, 5, 10K, 5K, and the input sequence is 1 to
 *       10K
 *     - It isn't a sorting system based on comparisons. It has an O(n) running time complexity, with
 *       space proportional to the data range
 *     - Counting sort counts the occurrences of the data object in O using partial hashing (1)
 *
 * Performance:
 *     - Worst Case Time Complexity [ Big-O ]: O(N+M)
 *     - Best Case Time Complexity [Big-omega]: O(N+M)
 *     - Average Time Complexity [Big-theta]: O(N+M)
 *     - Space Complexity: O(N+M)
 *
 * Advantages:
 *     - Counting sort generally performs faster than all comparison-based sorting algorithms, such as
 *       merge sort and quicksort, if the range of input is of the order of the number of input
 *     - Counting sort is easy to code
 *
 * Disadvantages:
 *     - Counting sort doesn't work on decimal values
 *     - Counting sort is inefficient if the range of values to be sorted is very large
 *     - What if the elements are in the range from 1 to n**2? We can’t use counting sort because
 *       counting sort will take O(n**2) which is worse than comparison-based sorting algorithms
 *
 */

public class SortCounting {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 9, 3, 5};

        System.out.println("Original Array:");
        printArray(array);

        countingSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    static void countingSort(int[] arr) {
        int n = arr.length;

        // Find the maximum value in the array
        int max = findMax(arr);

        // Create an array to store the count of each element
        int[] count = new int[max + 1];

        // Store the count of each element in the count array
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Update the count array to store the actual position of each element
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Create a temporary array to store the sorted result
        int[] output = new int[n];

        // Build the output array using the count array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
