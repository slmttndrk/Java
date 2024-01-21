package datastructuresalgorithms.algorithms;

/***
 * Selection sort is a simple sorting algorithm. This sorting algorithm is an in-place comparison-based
 * algorithm in which the list is divided into two parts, the sorted part at the left end and the
 * unsorted part at the right end. Initially, the sorted part is empty and the unsorted part is the
 * entire list.
 * The smallest element is selected from the unsorted array and swapped with the leftmost element, and
 * that element becomes a part of the sorted array. This process continues moving unsorted array
 * boundary by one element to the right.
 *
 * Properties:
 *     - This sorting algorithm is an in-place comparison-based algorithm in which the list is divided
 *       into two parts, the sorted part at the left end and the unsorted part at the right end
 *     - Selection Sort requires the minimum number of swaps.
 *
 * Steps to solve the problem:
 *     - Initialize minimum value(minValue) to location 0.
 *     - Traverse the array to find the minimum element in the array.
 *     - While traversing if any element smaller than minValue is found then swap both the values.
 *     - Then, increment minValue to point to the next element.
 *     - Repeat until the array is sorted.
 *
 * Applications:
 *     - a small list is to be sorted
 *     - cost of swapping does not matter
 *     - checking of all the elements is compulsory
 *     - cost of writing to a memory matters like in flash memory (number of writes/swaps is O(n) as
 *       compared to O(n2) of bubble sort)
 *
 * Advantages:
 *     - The main advantage of the selection sort is that it performs well on a small list
 *     - It is an in-place sorting algorithm, no additional temporary storage is required beyond
 *       what is needed to hold the original list
 *
 * Disadvantages:
 *     - The primary disadvantage of the selection sort is its poor efficiency when dealing with a
 *       huge list of items
 *     - Similar to the bubble sort, the selection sort requires n-squared number of steps for
 *       sorting n elements.
 *
 */

public class SortSelection {
    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(array);

        selectionSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
