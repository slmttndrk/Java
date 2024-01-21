package datastructuresalgorithms.algorithms;

/***
 * Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search
 * interval in half. The idea of binary search is to use the information that the array is sorted and
 * reduce the time complexity to O(Log n)
 *
 * Properties:
 *     - The pre-condition for the binary search is that the elements must be arranged in a sorted
 *       order
 *     - The implementation of binary search is limited as it can be implemented only on those data
 *       structures that have two-way traversal
 *     - It is based on the divide and conquer approach
 *     - It is preferrable for the large-size data sets
 *     - It can be implemented only on a singledimensional array
 *
 * Steps to solve the problem:
 *     - Compare 'x' with the middle element
 *     - If 'x' matches with the middle element, we return the mid index
 *     - Else If 'x' is greater than the mid element, then 'x' can only lie in the right half subarray
 *       after the mid element. So we recur for the right half
 *     - Else ('x' is smaller) recur for the left half
 *
 * Applications:
 *     - Find an element in a sorted array
 *     - Find the first value greater than or equal to x in a given array of sorted integers
 *     - Find the frequency of a given target value in an array of integers
 *     - Dictionary: In the dictionary, all the words are arranged in lexicographical order, therefore,
 *       to find a particular word, we can simply binary search to find the alphabets without having to
 *       go through each word
 *     - Find if a number is a square of any integer: To check if a number is a square of any integer,
 *       run a binary search from 1 to num and check if the square of mid is equal to num.
 *
 * Performance:
 *     - Best Case Time Complexity of Binary Search: O(1)
 *     - Average Case Time Complexity of Binary Search: O(logN)
 *     - Worst Case Time Complexity of Binary Search: O(logN)
 *     - Space Complexity of Binary Search: O(1) for iterative, O(logN) for recursive
 *
 * Advantages:
 *     - It is better than a linear search algorithm since its run time complexity is O(Log n)
 *     - At each iteration, the binary search algorithm eliminates half of the list and significantly
 *       reduces the search space
 *     - The binary search algorithm works even when the array is rotated by some position and finds
 *       the target element
 *
 * Disadvantages:
 *     - The recursive method uses stack space
 *     - Programming binary search algorithm is error prone and difficult
 *     - The interaction of binary search with memory hierarchy i.e. caching is poor. (because of its
 *       random access nature)
 *
 */

public class SearchBinary {
}

class SearchBinaryIterative {

    public static void main(String[] args) {
        int[] array = {1, 5, 7, 9, 11, 14, 18, 25};

        int target = 7;

        System.out.println("Original Sorted Array:");
        printArray(array);

        int index = binarySearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at the middle
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }

            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // If we reach here, the element was not present
        return -1;
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

class SearchBinaryRecursive {

    public static void main(String[] args) {
        int[] array = {1, 5, 7, 9, 11, 14, 18, 25};

        int target = 7;

        System.out.println("Original Sorted Array:");
        printArray(array);

        int index = recursiveBinarySearch(array, target, 0, array.length - 1);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    static int recursiveBinarySearch(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at the middle
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, search in the right half
            if (arr[mid] < target) {
                return recursiveBinarySearch(arr, target, mid + 1, right);
            }

            // If target is smaller, search in the left half
            return recursiveBinarySearch(arr, target, left, mid - 1);
        }

        // If we reach here, the element was not present
        return -1;
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
