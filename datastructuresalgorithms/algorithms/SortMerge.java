package datastructuresalgorithms.algorithms;

/***
 * The Merge Sort algorithm is a sorting algorithm that is based on the Divide and Conquer paradigm.
 * In this algorithm, the array is initially divided into two equal halves, and then they are combined
 * in a sorted manner
 * Think of it as a recursive algorithm continuously splits the array in half until it cannot be
 * further divided. This means that if the array becomes empty or has only one element left, the
 * dividing will stop, i.e. it is the base case to stop the recursion. If the array has multiple
 * elements, split the array into halves and recursively invoke the merge sort on each of the halves.
 * Finally, when both halves are sorted, the merge operation is applied. Merge operation is the process
 * of taking two smaller sorted arrays and combining them to eventually make a larger one
 *
 * Steps to solve the problem:
 *     - mergeSort(arr[], left, right)
 *     - If right > left
 *     - Find the middle point to divide the array into two halves: middle m = left + (right – left)/2
 *     - Call mergeSort for first half: mergeSort(arr, left, m)
 *     - Call mergeSort for second half: mergeSort(arr, m + 1, right)
 *     - Merge the two halves sorted merge(arr, left, m, right)
 *
 *  * Properties:
 *     - Merge Sort is useful for sorting linked lists.
 *     - Merge Sort is a stable sort which means that the same element in an array maintain their
 *       original positions with respect to each other.
 *     - Overall time complexity of Merge sort is O(nLogn). It is more efficient as it is in worst
 *       case also the runtime is O(nlogn)
 *     - The space complexity of Merge sort is O(n). This means that this algorithm takes a lot of
 *       space and may slower down operations for the last data sets.
 *
 * Applications:
 *     - Merge Sort is useful for sorting linked lists in O(n Log n) time
 *     - Merge sort can be implemented without extra space for linked lists
 *     - Merge sort is used for counting inversions in a list
 *     - Merge sort is used in external sorting
 *
 * Performance:
 *     - Worst Case Time Complexity [ Big-O ]: O(n*log n)
 *     - Best Case Time Complexity [Big-omega]: O(n*log n)
 *     - Average Time Complexity [Big-theta]: O(n*log n)
 *     - Space Complexity: O(n)
 *
 * Advantages:
 *     - Merge sort can efficiently sort a list in O(n*log(n)) time
 *     - Fast for large arrays unlike selection, insertion, and bubble sort it doesn't go through the
 *       whole array many times
 *
 * Disadvantages:
 *     - For small datasets, merge sort is slower than other sorting algorithms
 *     - For the temporary array, mergesort requires an additional space of O(n)
 *     - Even if the array is sorted, the merge sort goes through the entire process
 *
 */

public class SortMerge {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point of the array
            int middle = (left + right) / 2;

            // Recursively sort the two halves
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Merge the two arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray (if any)
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray (if any)
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
