package datastructuresalgorithms.algorithms;

/***
 * A sorting algorithm is a method for reorganizing a large number of items into a specific order,
 * such as alphabetical, highest-to-lowest value or shortest-to-longest distance. Sorting algorithms
 * take lists of items as input data, perform specific operations on those lists and deliver ordered
 * arrays as output
 *
 * Characteristics of Sorting Algorithms:
 *     - Speed (or better: time complexity): The most important criterion when selecting a sorting
 *       method is its speed. The main point of interest here is how the speed changes depending on
 *       the number of elements to be sorted. After all, one algorithm can be twice as fast as
 *       another at a hundred elements, but at a thousand elements, it can be five times slower
 *     - Space complexity: Not only time complexity is relevant for sorting methods, but also
 *       space complexity. Space complexity specifies how much additional memory the algorithm
 *       requires depending on the number of elements to be sorted. This does not refer to the
 *       memory required for the elements themselves, but to the additional memory required for
 *       auxiliary variables, loop counters, and temporary arrays
 *    - Stability: In stable sorting methods, the relative sequence of elements that have the same
 *      sort key is maintained. This is not guaranteed for non-stable sort methods: The relative
 *      order can be maintained but does not have to be
 *    - Comparison sorts / non-comparison sorts: Most of the well-known sorting methods are based on
 *      the comparison of two elements on less, greater or equal. However, there are also
 *      non-comparison-based sorting algorithms. You can find out how this can work in the Counting
 *      Sort and Radix Sort sections
 *    - Recursive / non-recursive: A recursive sorting algorithm requires additional memory on the
 *      stack. If the recursion is too deep, the dreaded StackOverflowException is imminent
 *
 * Classification of Sorting Algorithm:
 *     - Based on Number of Swaps or Inversion This is the number of times the algorithm swaps
 *       elements to sort the input. Selection Sort requires the minimum number of swaps
 *     - Based on Number of Comparisons This is the number of times the algorithm compares elements
 *       to sort the input. Using Big-O notation, the sorting algorithm examples listed above require
 *       at least O(nlogn) comparisons in the best case and O(n^2) comparisons in the worst case for
 *       most of the outputs
 *     - Based on Recursion or Non-Recursion Some sorting algorithms, such as Quick Sort, use recursive
 *       techniques to sort the input. Other sorting algorithms, such as Selection Sort or Insertion
 *       Sort, use non-recursive techniques. Finally, some sorting algorithm, such as Merge Sort, make
 *       use of both recursive and non-recursive techniques to sort the input
 *     - Based on Stability Sorting algorithms are said to be stable if the algorithm maintains the
 *       relative order of elements with equal keys. In other words, two equivalent elements remain
 *       in the same order in the sorted output as they were in the input
 *     - Insertion sort, Merge Sort, and Bubble Sort are stable
 *     - Heap Sort and Quick Sort are not stable
 *     - Based on Extra Space Requirement Sorting algorithms are said to be in place if they require
 *       a constant O(1) extra space for sorting
 *     - Insertion sort and Quick-sort are in place sort as we move the elements about the pivot and
 *       do not actually use a separate array which is NOT the case in merge sort where the size of
 *       the input must be allocated beforehand to store the output during the sort
 *     - Merge Sort is an example of out place sort as it require extra memory space for it’s
 *       operations
 *
 * Complexity and Stability of Sorting Algorithms:
 *
 *       |  Sorting Algorithms  |   Best    |   Worst   |   Average |   Space   |   Stability   |
 *       ========================================================================================
 *       |  Bubble Sort         |   n       |   n*n     |   n*n     |   1       |   Yes         |
 *       |  Selection Sort      |   n*n     |   n*n     |   n*n     |   1       |   No          |
 *       |  Insertion Sort      |   n       |   n*n     |   n*n     |   1       |   Yes         |
 *       |  Merge Sort          |   nlogn   |   nlogn   |   nlogn   |   n       |   Yes         |
 *       |  Quick Sort          |   nlogn   |   n*n     |   nlogn   |   logn    |   No          |
 *       |  Counting Sort       |   n+k     |   n+k     |   n+k     |   max     |   Yes         |
 *       |  Radix Sort          |   n+k     |   n+k     |   n+k     |   max     |   Yes         |
 *       |  Bucket Sort         |   n+k     |   n*n     |   n       |   n+k     |   Yes         |
 *       |  Heap Sort           |   nlogn   |   nlogn   |   nlogn   |   1       |   No          |
 *       |  Shell Sort          |   nlogn   |   n*n     |   nlogn   |   1       |   No          |
 */

public class Sort {
}
