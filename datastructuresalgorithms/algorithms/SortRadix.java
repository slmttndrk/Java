package datastructuresalgorithms.algorithms;

/***
 * Radix sort is an algorithm that uses counting sort as a subroutine to sort an array of
 * integers/strings in either ascending or descending order. The main idea of radix sort revolves
 * around applying counting sort digit by digit on the given array
 *
 * Steps to solve the problem:
 *     - Find the maximum element of the array, let it be max
 *     - Find the number of digits in max, let it be k
 *     - For each, i ranging from 1 To k, apply the counting sort algorithm for the i^{th}
 *       least-significant digit of each element. If any element has less than i digits consider 0 at
 *       its place (Because 29 can also be represented as 029)
 *
 * Properties:
 *     - It makes assumptions about the data like the data must be between a range of elements
 *     - Input array must have the elements with the same radix and width
 *     - Radix sort works on sorting based on an individual digit or letter position
 *     - We must start sorting from the rightmost position and use a stable algorithm at each position
 *     - Radix sort is not an in-place algorithm as it uses a temporary count array
 *
 * Applications:
 *     - The Radix sort algorithm is used in a typical computer, a sequential random-access machine,
 *       multiple fields key records
 *     - While creating a suffix array, use the DC3 algorithm (Kärkkäinen-Sanders-Burkhardt)
 *     - The Radix sort algorithm locates locations where there are numbers in extensive ranges
 *
 * Performance:
 *     - Worst Case Time Complexity [ Big-O ]: O(N+K)
 *     - Best Case Time Complexity [Big-omega]: O(N+K)
 *     - Average Time Complexity [Big-theta]: O(N+K)
 *     - Space Complexity: O(MAX)
 *
 * Advantages:
 *     - Fast when the keys are short, i.e. when the array element range is small
 *     - Used in suffix arrays construction algorithms such as Manber's and the DC3 algorithm
 *     - Radix Sort is a stable sort because it maintains the relative order of elements with equal
 *       values
 *
 * Disadvantages:
 *     - The Radix Sort algorithm is less flexible than other sorts because it is based on digits or
 *       letters. As a result, for each different type of data, it must be rewritten
 *     - Radix sort has a higher constant than other sorting algorithms
 *     - It takes up more space than Quicksort, which is used for in-place sorting
 *     - Radix sort may be slower than other sorting algorithms such as merge sort and Quicksort if
 *       the operations are inefficient. These operations include sub-inset lists and delete functions,
 *       as well as the process of isolating the desired digits
 *     - Because it is based on digits or letters, the radix sort is less flexible than other sorts. If
 *       the data type must be rewritten, so must the Radix sort
 *
 */

import java.util.Arrays;

public class SortRadix {
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Original Array:");
        printArray(array);

        radixSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    static void radixSort(int[] arr) {
        // Find the maximum number to determine the number of digits
        int max = findMax(arr);

        // Perform counting sort for every digit place (from least significant to most significant)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Count array for digits 0 to 9

        // Initialize count array
        Arrays.fill(count, 0);

        // Store the count of occurrences of each digit
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Update the count array to store the actual position of each element
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array using the count array and maintain the stability of sorting
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
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
