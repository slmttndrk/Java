package datastructuresalgorithms.algorithms;

/***
 * A divide and conquer algorithm is a strategy of solving a large problem by breaking the problem
 * into smaller sub-problems, solving the sub-problems, and combining them to get the desired output.
 *
 * Terminologies:
 *     - Divide: This involves dividing the problem into smaller sub-problems
 *     - Conquer: Solve sub-problems by calling recursively until solved
 *     - Combine: Combine the sub-problems to get the final solution of the whole problem
 *
 * Some Standard Algorithms:
 *     - Quicksort: is a sorting algorithm. The algorithm picks a pivot element and rearranges the
 *       array elements so that all elements smaller than the picked pivot element move to the left
 *       side of the pivot, and all greater elements move to the right side. Finally, the algorithm
 *       recursively sorts the subarrays on the left and right of the pivot element
 *
 *     - Merge Sort: is also a sorting algorithm. The algorithm divides the array into two halves,
 *       recursively sorts them, and finally merges the two sorted halves
 *
 *     - Closest Pair of Points: The problem is to find the closest pair of points in a set of points
 *       in the x-y plane. The problem can be solved in O(n^2) time by calculating the distances of
 *       every pair of points and comparing the distances to find the minimum. The Divide and Conquer
 *       algorithm solves the problem in O(N log N) time
 *
 *     - Strassen’s Algorithm: is an efficient algorithm to multiply two matrices. A simple method to
 *       multiply two matrices needs 3 nested loops and is O(n^3). Strassen’s algorithm multiplies
 *       two matrices in O(n^2.8974) time
 *
 *     - Karatsuba algorithm: is a fast multiplication algorithm that uses a divide and conquer
 *       approach to multiply two numbers
 *
 * Time Complexity of Divide and Conquer Algorithm:
 *     - T(n) = aT(n/b) + f(n),
 *
 *      where,
 *          - n    = size of input
 *          - a    = number of sub-problems in the recursion
 *          - n/b  = size of each sub-problem. All sub-problems are assumed to have the same size.
 *          - f(n) = cost of the work done outside the recursive call, which includes the cost of
 *                   dividing the problem and cost of merging the solutions
 *
 * Divide and Conquer (D & C) vs Dynamic Programming (DP) :
 *     - Both paradigms (D & C and DP) divide the given problem into sub-problems and solve sub-problems.
 *       How do choose one of them for a given problem? Divide and Conquer should be used when the same
 *       sub-problems are not evaluated many times. Otherwise, Dynamic Programming or Memoization should
 *       be used. For example, Quicksort is a Divide and Conquer algorithm, we never evaluate the same
 *       sub-problems again. On the other hand, for calculating the nth Fibonacci number, Dynamic
 *       Programming should be preferred
 *
 * Advantages:
 *     - The difficult problem can be solved easily
 *     - It divides the entire problem into sub-problems thus it can be solved parallel ensuring
 *       multiprocessing
 *     - Efficiently uses cache memory without occupying much space
 *     - Reduces time complexity of the problem
 *
 * Disadvantages:
 *     - It involves recursion which is sometimes slow
 *     - Efficiency depends on the implementation of logic
 *     - It may crash the system if the recursion is performed rigorously
 *
 */

import java.util.Arrays;

public class DivideAndConquer {

}
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ClosestPairOfPoints {
    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };

        Point[] closestPair = findClosestPair(points);

        System.out.println("Closest Pair of Points: (" + closestPair[0].x + ", " + closestPair[0].y +
                ") and (" + closestPair[1].x + ", " + closestPair[1].y + ")");
    }

    static Point[] findClosestPair(Point[] points) {
        if (points.length < 2) {
            throw new IllegalArgumentException("At least two points are required");
        }

        // Sort points based on their x-coordinates
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1.x, p2.x));

        // Find the closest pair recursively
        return findClosestPairRecursive(points, 0, points.length - 1);
    }

    static Point[] findClosestPairRecursive(Point[] points, int left, int right) {
        if (right - left <= 2) {
            // Base case: When the subset has 2 or 3 points, use brute force
            return bruteForceClosestPair(points, left, right);
        }

        // Divide the points into two halves
        int mid = (left + right) / 2;

        // Recursively find the closest pair in each half
        Point[] leftClosestPair = findClosestPairRecursive(points, left, mid);
        Point[] rightClosestPair = findClosestPairRecursive(points, mid + 1, right);

        // Find the closest pair across the two halves
        Point[] closestPairAcross = findClosestPairAcrossMid(points, left, right, mid,
                leftClosestPair, rightClosestPair);

        // Return the closest pair among the three possibilities
        return findMinimumDistancePair(leftClosestPair, rightClosestPair, closestPairAcross);
    }

    static Point[] bruteForceClosestPair(Point[] points, int left, int right) {
        Point[] closestPair = new Point[2];
        double minDistance = Double.POSITIVE_INFINITY;

        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double distance = calculateDistance(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
        }

        return closestPair;
    }

    static Point[] findClosestPairAcrossMid(Point[] points, int left, int right, int mid,
                                            Point[] leftClosestPair, Point[] rightClosestPair) {
        double leftMaxX = points[mid].x;
        double rightMinX = points[mid + 1].x;

        // Find points in the left subset that are within the strip
        Point[] leftStrip = Arrays.stream(leftClosestPair)
                .filter(point -> point.x >= leftMaxX - minDistance(leftClosestPair, rightClosestPair))
                .toArray(Point[]::new);

        // Find points in the right subset that are within the strip
        Point[] rightStrip = Arrays.stream(rightClosestPair)
                .filter(point -> point.x <= rightMinX + minDistance(leftClosestPair, rightClosestPair))
                .toArray(Point[]::new);

        // Find the closest pair within the strip
        return findClosestPairInStrip(leftStrip, rightStrip, minDistance(leftClosestPair, rightClosestPair));
    }

    static Point[] findClosestPairInStrip(Point[] leftStrip, Point[] rightStrip, double minDistance) {
        Point[] closestPair = new Point[2];
        double minStripDistance = minDistance;

        for (int i = 0; i < leftStrip.length; i++) {
            for (int j = 0; j < rightStrip.length; j++) {
                double distance = calculateDistance(leftStrip[i], rightStrip[j]);
                if (distance < minStripDistance) {
                    minStripDistance = distance;
                    closestPair[0] = leftStrip[i];
                    closestPair[1] = rightStrip[j];
                }
            }
        }

        return closestPair;
    }

    static double minDistance(Point[] leftClosestPair, Point[] rightClosestPair) {
        double minLeft = minDistance(leftClosestPair);
        double minRight = minDistance(rightClosestPair);
        return Math.min(minLeft, minRight);
    }

    static double minDistance(Point[] pair) {
        if (pair[0] == null || pair[1] == null) {
            return Double.POSITIVE_INFINITY;
        }
        return calculateDistance(pair[0], pair[1]);
    }

    static double calculateDistance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static Point[] findMinimumDistancePair(Point[] pair1, Point[] pair2, Point[] pair3) {
        double min1 = minDistance(pair1);
        double min2 = minDistance(pair2);
        double min3 = minDistance(pair3);

        if (min1 <= min2 && min1 <= min3) {
            return pair1;
        } else if (min2 <= min1 && min2 <= min3) {
            return pair2;
        } else {
            return pair3;
        }
    }
}

