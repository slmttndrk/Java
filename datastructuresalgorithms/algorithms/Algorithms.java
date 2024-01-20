package datastructuresalgorithms.algorithms;

/***
 * An algorithm is a procedure used for solving a problem or performing a computation. Algorithms
 * act as an exact list of instructions that conduct specified actions step by step in either
 * hardware- or software-based routines
 *
 * What are the Characteristics of an Algorithm
 *
 * Clear and Unambiguous: The algorithm should be clear and unambiguous. Each of its steps should be
 * clear in all aspects and must lead to only one meaning
 *
 * Well-Defined Inputs: If an algorithm says to take inputs, it should be well-defined inputs
 *
 * Well-Defined Outputs: The algorithm must clearly define what output will be yielded and it should
 * be well-defined as well
 *
 * Finite-ness: The algorithm must be finite, i.e. it should terminate after a finite time
 *
 * Feasible: The algorithm must be simple, generic, and practical, such that it can be executed with
 * the available resources. It must not contain some future technology or anything
 *
 * Language Independent: The Algorithm designed must be language-independent, i.e. it must be just
 * plain instructions that can be implemented in any language, and yet the output will be the same,
 * as expected
 *
 * Properties:
 *     - It should terminate after a finite time
 *     - It should produce at least one output
 *     - It should take zero or more input
 *     - It should be deterministic means giving the same output for the same input case
 *     - Every step in the algorithm must be effective i.e. every step should do some work
 *
 * Types of Algorithm:
 *
 *     - Brute Force Algorithm: It is the simplest approach for a problem. A brute force algorithm is
 *       the first approach that comes to finding when we see a problem
 *
 *     - Recursive Algorithm: A recursive algorithm is based on recursion. In this case, a problem
 *       is broken into several sub-parts and called the same function again and again
 *
 *     - Sorting Algorithm: Sorting is arranging a group of data in a particular manner according to
 *       the requirement. The algorithms which help in performing this function are called sorting
 *       algorithms. Generally sorting algorithms are used to sort groups of data in an increasing
 *       or decreasing manner
 *
 *     - Searching Algorithm: Searching algorithms are the ones that are used for searching elements
 *       or groups of elements from a particular data structure. They can be of different types based
 *       on their approach or the data structure in which the element should be found
 *
 *     - Hashing Algorithm: Hashing algorithms work similarly to the searching algorithm. But they
 *       contain an index with a key ID. In hashing, a key is assigned to specific data
 *
 *     - Divide and Conquer Algorithm: This algorithm breaks a problem into sub-problems, solves a
 *       single sub-problem and merges the solutions together to get the final solution. It consists
 *       of the following three steps:
 *          Divide
 *          Solve
 *          Combine
 *
 *     - Dynamic Programming Algorithm: This algorithm uses the concept of using the already found
 *       solution to avoid repetitive calculation of the same part of the problem. It divides the
 *       problem into smaller overlapping sub-problems and solves them
 *
 *     - Greedy Algorithm: In this type of algorithm the solution is built part by part. The solution
 *       of the next part is built based on the immediate benefit of the next part. The one solution
 *       giving the most benefit will be chosen as the solution for the next part
 *
 *     - Backtracking Algorithm: The backtracking algorithm basically builds the solution by
 *       searching among all possible solutions. Using this algorithm, we keep on building the
 *       solution following criteria. Whenever a solution fails we trace back to the failure point
 *       and build on the next solution and continue this process till we find the solution or all
 *       possible solutions are looked after
 *
 *     - Randomized Algorithm: In the randomized algorithm we use a random number, so it gives
 *       immediate benefit. The random number helps in deciding the expected outcome
 *
 * How to Design an Algorithm:
 *
 *     - The problem that is to be solved by this algorithm i.e. clear problem definition
 *     - The constraints of the problem must be considered while solving the problem
 *     - The input to be taken to solve the problem
 *     - The output to be expected when the problem is solved
 *     - The solution to this problem, is within the given constraints
 *
 * Advantages:
 *     - It is easy to understand
 *     - An algorithm is a step-wise representation of a solution to a given problem
 *     - In Algorithm the problem is broken down into smaller pieces or steps hence, it is easier
 *       for the programmer to convert it into an actual program
 *
 * Disadvantages:
 *     - Writing an algorithm takes a long time so it is time-consuming
 *     - Understanding complex logic through algorithms can be very difficult
 *     - Branching and Looping statements are difficult to show in Algorithms
 *
 */

public class Algorithms {
    public static void main(String[] args) {
        /**
         * // Pseudocode for Binary Search
         * function binarySearch(arr, target):
         *     low = 0
         *     high = length(arr) - 1
         *
         *     while low <= high:
         *         mid = (low + high) / 2
         *
         *         if arr[mid] == target:
         *             return mid  // Element found
         *         else if arr[mid] < target:
         *             low = mid + 1
         *         else:
         *             high = mid - 1
         *
         *     return -1  // Element not found
         */

        /**
         * // Pseudocode for Bubble Sort
         * function bubbleSort(arr):
         *     n = length(arr)
         *
         *     for i from 0 to n-1:
         *         for j from 0 to n-i-1:
         *             if arr[j] > arr[j+1]:
         *                 swap(arr[j], arr[j+1])
         *
         * // Swap function
         * function swap(a, b):
         *     temp = a
         *     a = b
         *     b = temp
         */

        /**
         * // Pseudocode for Depth-First Search
         * function dfs(graph, start, visited):
         *     if visited[start]:
         *         return
         *
         *     visited[start] = true
         *     processNode(start)
         *
         *     for neighbor in graph.adjacentNodes(start):
         *         dfs(graph, neighbor, visited)
         *
         * // Process Node function (user-defined)
         * function processNode(node):
         *     print("Processing node: " + node)
         */

        /**
         * // Pseudocode for Dijkstra's Algorithm
         * function dijkstra(graph, start):
         *     initializeDistances(graph, start)
         *     priorityQueue = createPriorityQueue()
         *
         *     while priorityQueue is not empty:
         *         current = priorityQueue.extractMin()
         *
         *         for neighbor in graph.adjacentNodes(current):
         *             relaxEdge(current, neighbor, priorityQueue)
         *
         * // Initialize Distances function
         * function initializeDistances(graph, start):
         *     for node in graph.nodes:
         *         if node == start:
         *             setDistance(node, 0)
         *         else:
         *             setDistance(node, INFINITY)
         *
         * // Relax Edge function
         * function relaxEdge(current, neighbor, priorityQueue):
         *     newDistance = getDistance(current) + edgeWeight(current, neighbor)
         *
         *     if newDistance < getDistance(neighbor):
         *         setDistance(neighbor, newDistance)
         *         priorityQueue.decreaseKey(neighbor, newDistance)
         */

    }
}
