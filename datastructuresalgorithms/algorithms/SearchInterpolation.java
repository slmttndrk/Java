package datastructuresalgorithms.algorithms;

/***
 * The Interpolation Search is an improvement over Binary Search for instances, where the values in a
 * sorted array are uniformly distributed. Interpolation constructs new data points within the range of
 * a discrete set of known data points. Binary Search always goes to the middle element to check. On
 * the other hand, interpolation search may go to different locations according to the value of the
 * key being searched. For example, if the value of the key is closer to the last element,
 * interpolation search is likely to start search toward the end side.
 *
 * Properties:
 *     - Interpolation searching algorithm is only used when the elements in an array is sorted and
 *       uniformly distributed
 *     - pos = low + ((target – A[low]) * (high – low) / (A[high] – A[low]))
 *
 * Steps to solve the problem:
 *     - pos = low + ((target – A[low]) * (high – low) / (A[high] – A[low]))
 *     - In a loop, calculate the value of pos using the above formula
 *     - If it is a match, return the index of the item, and exit
 *     - If the item is less than the element at position pos, calculate the target position of the
 *       left sub-array. Otherwise calculate the same in the right sub-array
 *     - Repeat until a match is found or the search space reduces to zero
 *
 * Applications:
 *     - Since the major requirement to use Interpolation Search is that the data set must be sorted
 *       and uniformly distributed, it has a very limited number of applications in real life, where
 *       data is actually quite randomised
 *     - Interpolation Search Algorithm is a search algorithm that has been inspired by the way humans
 *       search through a telephone book for a particular name, the key value by which the book's
 *       entries are ordered
 *
 * Performance:
 *     - Worst case time complexity: O(N)
 *     - Average case time complexity: O(log log N)
 *     - Best case time complexity: O(1)
 *     - Space complexity: O(1)
 *
 * Advantages:
 *     - When all elements in the list are sorted and evenly distributed, then executing time of
 *       Interpolation search algorithm is log(log n)
 *
 * Disadvantages:
 *     - However, When the elements in the list are increased exponentially, then executing time of
 *       Interpolation search algorithm is 0(n)
 *
 */

public class SearchInterpolation {
    public static void main(String[] args) {
        int[] array = {1, 5, 7, 9, 11, 14, 18, 25};

        int target = 7;

        System.out.println("Original Sorted Array:");
        printArray(array);

        int index = interpolationSearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // Interpolation formula to find the mid-point
            int pos = low + ((target - arr[low]) * (high - low) / (arr[high] - arr[low]));

            if (arr[pos] == target) {
                return pos; // Element found
            }

            if (arr[pos] < target) {
                low = pos + 1; // Search in the right half
            } else {
                high = pos - 1; // Search in the left half
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
