package datastructuresalgorithms.algorithms;

/***
 * Exponential search allows for searching through a sorted, unbounded list for a specified input
 * value (the search "key"). The algorithm consists of two stages. The first stage determines a
 * range in which the search key would reside if it were in the list. In the second stage, a binary
 * search is performed on this range. In the first stage, assuming that the list is sorted in
 * ascending order, the algorithm looks for the first exponent, j, where the value 2^j is greater
 * than the search key. This value, 2^j becomes the upper bound for the binary search with the previous
 * power of 2, 2^(j - 1), being the lower bound for the binary search
 *
 * Properties:
 *     - Finding the range in which the key could sit
 *     - Applying binary search in this range
 *     - Exponential search algorithm (also called doubling search, galloping search, Struzik search)
 *       is a search algorithm, created by Jon Bentley and Andrew Chi-Chih Yao in 1976, for searching
 *       sorted, unbounded/infinite lists
 *
 * Steps to solve the problem:
 *     - Start with value i=1
 *     - Check for a condition i < n and Array[i]<=key, where n is the number of items in the array
 *       and key is the element being sought
 *     - Increment value of I in powers of 2, that is, i=i*2
 *     - Keep on incrementing the value of 'i' until the condition is met
 *     - Apply binary on the range i/2 to the end of Array - binarySearch(Array, i/2, min(i,n-1))
 *
 * Applications:
 *     - Exponential Binary Search is useful for unbounded searches where size of array is infinite
 *     - It works better than Binary Search for bounded arrays when the element to be searched is
 *       closer to the beginning of the array.
 *
 * Performance:
 *     - Worst case time complexity: O(log i) where i is the index of the element being searched
 *     - Average case time complexity: O(log i)
 *     - Best case time complexity: O(1)
 *     - Space complexity: O(1)
 *
 * Advantages:
 *     - Exponential Binary Search is useful for unbounded searches where size of array is infinite
 *
 * Disadvantages:
 *     - The list should be sorted to perform the exponential search, if the list is unsorted, it will
 *       give wrong results
 *
 */

public class SearchExponential {
    public static void main(String[] args) {
        int[] array = {1, 5, 7, 9, 11, 14, 18, 25};

        int target = 7;

        System.out.println("Original Sorted Array:");
        printArray(array);

        int index = exponentialSearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;

        // If the target is present at the first position
        if (arr[0] == target) {
            return 0;
        }

        // Find range for binary search by repeatedly doubling it
        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }

        // Perform binary search within the identified range
        return binarySearch(arr, target, i / 2, Math.min(i, n - 1));
    }

    static int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Element found
            }

            if (arr[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return -1; // Element not found
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
