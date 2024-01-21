package datastructuresalgorithms.algorithms;

/***
 * Linear Search is defined as a sequential search algorithm that starts at one end and goes through
 * each element of a list until the desired element is found, otherwise the search continues till the
 * end of the data set. It is the easiest searching algorithm
 *
 * Properties:
 *     - It can be implemented on both a single and multidimensional array
 *     - It is preferable for the small-sized data sets
 *     - The linear search can be implemented on any linear data structure such as an array, linked
 *       list, etc.
 *     - In a linear search, the elements don't need to be arranged in sorted order
 *
 * Steps to solve the problem:
 *     - Start from the leftmost element of arr and one by one compare 'x' with each element of arr
 *     - If 'x' matches with an element, return the index
 *     - If 'x' doesn’t match with any of the elements, return -1
 *
 * Applications:
 *     - Linear search can be applied to both single-dimensional and multidimensional arrays
 *     - Linear search is easy to implement and effective when the array contains only a few elements
 *     - Linear Search is also efficient when the search is performed to fetch a single search in an
 *       unordered-List
 *
 * Performance:
 *     - Best Case Complexity - In Linear search, best case occurs when the element we are finding is
 *       at the first position of the array. The best-case time complexity of linear search is O(1)
 *     - Average Case Complexity - The average case time complexity of linear search is O(n)
 *     - Worst Case Complexity - In Linear search, the worst case occurs when the element we are
 *       looking is present at the end of the array. The worst-case in linear search could be when the
 *       target element is not present in the given array, and we have to traverse the entire array.
 *       The worst-case time complexity of linear search is O(n)
 *     - Space Complexity - The space complexity of linear search is O(1)
 *
 * Advantages:
 *     - Will perform fast searches of small to medium lists. With today's powerful computers, small to
 *       medium arrays can be searched relatively quickly
 *     - The list does not need to sorted. Unlike a binary search, linear searching does not require an
 *       ordered list
 *     - Not affected by insertions and deletions. As the linear search does not require the list to be
 *       sorted, additional elements can be added and deleted. As other searching algorithms may have
 *       to reorder the list after insertions or deletions, this may sometimes mean a linear search
 *       will be more efficient
 *
 * Disadvantages:
 *     - Slow searching of large lists. For example, when searching through a database of everyone in
 *       the Northern Ireland to find a particular name, it might be necessary to search through 1.8
 *       million names before you found the one you wanted. This speed disadvantage is why other search
 *       methods have been developed
 *
 */

public class SearchLinear {
    public static void main(String[] args) {
        int[] array = {1, 5, 9, 14, 25, 7, 18};

        int target = 7;

        System.out.println("Original Array:");
        printArray(array);

        int index = linearSearch(array, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index if the element is found
            }
        }
        return -1; // Return -1 if the element is not found
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
