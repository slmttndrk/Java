package datastructuresalgorithms.algorithms;

/***
 * Jump Search is a searching algorithm for sorted arrays. The basic idea is to check fewer elements
 * by jumping ahead by fixed steps or skipping some elements in place of searching all elements.
 *
 * Properties:
 *     - This algorithm works only for sorted input arrays
 *     - Optimal size of the block to be skipped is √n, thus resulting in the time complexity O(√n2)
 *     - The time complexity of this algorithm lies in between linear search (O(n)) and binary search
 *       (O(log n))
 *     - It is also called block search algorithm
 *     - If we compare it with linear and binary search then it comes out then it is better than
 *       linear search but not better than binary search
 *     - linear search < jump search < binary search
 *
 * Steps to solve the problem:
 *     - Start from index 0
 *     - Jump head by 'B'(B = √N) elements. Current position = Current position + B. If position is
 *       out of element list, set current position to last position
 *     - If element at current position < target element, then do Linear Search on element from
 *       position current position -B to current position else go to step 2.If current position is
 *       last position. Exit. Element not found
 *
 * Applications:
 *     - If jumping back in a list takes significantly more time than jumping forward then one should
 *       use this algorithm
 *
 * Performance:
 *     - Worst case time complexity: O(√N)
 *     - Average case time complexity: O(√N)
 *     - Best case time complexity: O(1)
 *     - Space complexity: O(1)
 *
 * Advantages:
 *     - It is faster than the linear search technique which has a time complexity of O(n) for
 *       searching an element
 *
 * Disadvantages:
 *     - It is slower than binary search algorithm which searches an element in O(log n)
 *     - It requires the input array to be sorted
 *
 */

public class SearchJump {
    public static void main(String[] args) {
        int[] array = {1, 5, 7, 9, 11, 14, 18, 25};

        int target = 7;

        System.out.println("Original Sorted Array:");
        printArray(array);

        int index = jumpSearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

        // Jumping through the array
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);

            if (prev >= n) {
                return -1;
            }
        }

        // Linear search in the block
        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
