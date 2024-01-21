package datastructuresalgorithms.algorithms;

/***
 * Bucket sort is a sorting technique that uses the Scatter-Gather-Approach to sort the array. It
 * divides the unsorted array into separate groups and calls them buckets. Sort the individual
 * buckets, and then gather them all together to form the final sorted array
 *
 * Steps to solve the problem:
 *     - If All the elements are in the range of [0,1] then no need to follow initial two steps and in third step create 10 empty buckets and in step four bucketIndex = array[i]*10
 *     - Calculate the maximum and the minimum element of the array
 *     - Calculate the range: range = (maximum - minimum) / n, where n is the number of buckets
 *     - Create n empty buckets and initialize them with 0
 *     - Loop through the unsorted array and perform the following:
 *          - (i) Calculate bucketIndex bucketIndex = (array[i] - minimum) / range
 *          - (ii) Insert the ith element of the array into the bucket[bucketIndex]
 *     - Sort the individual buckets
 *     - Gather all the elements together
 *
 * Properties:
 *     - Bucket sort assumes that the input is drawn from a uniform distribution
 *     - The computational complexity estimates involve the number of buckets
 *     - Bucket sort can be exceptionally fast because of the way elements are assigned to buckets,
 *       typically using an array where the index is the value
 *     - This means that more auxiliary memory is required for the buckets at the cost of running time
 *       than more comparison sorts
 *
 * Applications:
 *     - Uniformly Distributed data
 *     - Floating point numbers between range 0.0 to 1.0.
 *     - Bucket Sort is a very different type of sorting algorithm as it does not involve direct
 *       comparison between the numbers. It can only be applied to uniformly distributed data
 *     - Whenever we have floating-point numbers between 0 and 1, bucket sort might be the best sorting
 *       approach. Reason - if we use merge-sort, quick-sort, heap-sort, etc, the problem will take a
 *       minimum of O(nlogn) time complexity. Also, counting sort cannot be used because floating point
 *       numbers cannot be used as index. Hence, bucket sort is best suited for sorting the array with
 *       floating point numbers of range [0.0-1.0]
 *
 * Performance:
 *     - Worst Case Time Complexity: O(N**2)
 *          If the array elements are not uniformly distributed, i.e., elements are concentrated within
 *          specific ranges. This will result in one or more buckets having more elements than other
 *          buckets, making bucket sort like any other sorting technique, where every element is
 *          compared to the other. Time complexity increases even further if the elements in the array
 *          are present in the reverse order. If insertion sort is used, the worst-case time complexity
 *          can go up to O(N**2)
 *     - Best Case Time Complexity: O(N+K)
 *          If the array elements are uniformly distributed, bucket size will almost be the same for
 *          all the buckets. Hence, this will be the best case which will take up the least amount of
 *          time. Sorting time complexity will reduce even further if all the elements inside each
 *          bucket are already sorted. To create n buckets and scatter each element from the array,
 *          time complexity = O(n). If we use Insertion sort to sort each bucket, time
 *          complexity = O(k). Hence, best case time complexity for bucket sort = O(n+k),
 *          where n = number of elements, and k = number of buckets
 *     - Average Case Time Complexity: O(N)
 *          It occurs when the elements are distributed randomly in the array. Even if the elements
 *          are not distributed uniformly, bucket sort runs in linear time. It holds true until the
 *          sum of the squares of the bucket sizes is linear in the total number of elements
 *     - Space Complexity : O(N+K)
 *          Space Complexity for bucket sort is O(n+k), where n = number of elements in the array,
 *          and k = number of buckets formed Space taken by each bucket is O(k), and inside each bucket,
 *          we have n elements scattered. Hence, the space complexity becomes O(n+k)
 *
 * Advantages:
 *     - Bucket sort allows each bucket to be processed independently. As a result, you’ll frequently
 *       need to sort much smaller arrays as a secondary step after sorting the main array
 *     - Bucket sort also has the advantage of being able to be used as an external sorting algorithm.
 *       If you need to sort a list that is too large to fit in memory, you may stream it through RAM,
 *       split the contents into buckets saved in external files, and then sort each file separately in
 *       RAM
 *
 * Disadvantages:
 *     - The problem is that if the buckets are distributed incorrectly, you may wind up spending a
 *       lot of extra effort for no or very little gain. As a result, bucket sort works best when the
 *       data is more or less evenly distributed, or when there is a smart technique to pick the
 *       buckets given a fast set of heuristics based on the input array
 *     - Can’t apply it to all data types since a suitable bucketing technique is required. Bucket
 *       sort’s efficiency is dependent on the distribution of the input values, thus it’s not worth
 *       it if your data are closely grouped.In many situations, you might achieve greater performance
 *       by using a specialized sorting algorithm like radix sort, counting sort, or burst sort instead
 *       of bucket sort
 *     - Bucket sort’s performance is determined by the number of buckets used, which may need some
 *       additional performance adjustment when compared to other algorithms
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortBucket {
    public static void main(String[] args) {
        double[] array = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};

        System.out.println("Original Array:");
        printArray(array);

        bucketSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }

    static void bucketSort(double[] arr) {
        int n = arr.length;

        // Create buckets
        List<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Place elements into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate the buckets to get the sorted array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
