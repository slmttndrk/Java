package datastructuresalgorithms.algorithms;

/***
 * A greedy algorithm is an approach for solving a problem by selecting the best option available
 * at the moment. It doesn't worry whether the current best result will bring the overall optimal
 * result.
 * The algorithm never reverses the earlier decision even if the choice is wrong. It works in a
 * top-down approach.
 * This algorithm may not produce the best result for all the problems. It's because it always goes
 * for the local best choice to produce the global best result.
 *
 * Properties of Greedy Algorithm:
 *     - Greedy Choice Property: If an optimal solution to the problem can be found by choosing the
 *       best choice at each step without reconsidering the previous steps once chosen, the problem
 *       can be solved using a greedy approach. This property is called greedy choice property.
 *
 *     - Optimal Substructure: If the optimal overall solution to the problem corresponds to the
 *       optimal solution to its sub-problems, then the problem can be solved using a greedy approach.
 *       This property is called optimal substructure.
 *
 * Components of Greedy Algorithm:
 *     - Candidate set: A solution that is created from the set is known as a candidate set.
 *     - Selection function: This function is used to choose the candidate or subset which can be
 *       added in the solution.
 *     - Feasibility function: A function that is used to determine whether the candidate or subset
 *       can be used to contribute to the solution or not.
 *     - Objective function: A function is used to assign the value to the solution or the partial
 *       solution.
 *     - Solution function: This function is used to intimate whether the complete function has been
 *       reached or not.
 *
 * Greedy Algorithm:
 *     - To begin with, the solution set (containing answers) is empty.
 *     - At each step, an item is added to the solution set until a solution is reached.
 *     - If the solution set is feasible, the current item is kept.
 *     - Else, the item is rejected and never considered again.
 *
 * Applications of Greedy Algorithm:
 *     - Selection Sort
 *     - Fractional knapsack Problem
 *     - Minimum Spanning Tree(Prim's, Kruskal's,)
 *     - Single-Source Shortest Path Problem
 *     - Job Scheduling Problem
 *     - Huffman Coding
 *     - Ford-Fulkerson Algorithm
 *
 * Advantages of Greedy Algorithm:
 *     - The algorithm is easier to describe.
 *     - This algorithm can perform better than other algorithms (but, not in all cases).
 *
 * Disadvantages of Greedy Algorithm:
 *     - As mentioned earlier, the greedy algorithm doesn't always produce the optimal solution. This
 *       is the major disadvantage of the algorithm
 *
 */

import java.util.Arrays;

public class Greedy {
}

//  finding the Minimum Spanning Tree (MST); Kruskal's algorithm
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.weight, edge.weight);
    }
}

class KruskalsAlgorithm {

    public static void main(String[] args) {
        // Example graph represented by an adjacency matrix
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        minimumSpanningTree(graph);
    }

    static void minimumSpanningTree(int[][] graph) {
        int V = graph.length;

        // Create an array to store edges
        Edge[] edges = new Edge[V * (V - 1) / 2];
        int index = 0;

        // Populate the edges array with non-zero weights from the graph
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges[index++] = new Edge(i, j, graph[i][j]);
                }
            }
        }

        // Sort the edges array based on weights
        Arrays.sort(edges);

        // Initialize the parent array for disjoint set union-find
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        // Initialize the result array to store the edges of the minimum spanning tree
        Edge[] result = new Edge[V - 1];
        int resultIndex = 0;

        // Perform Kruskal's algorithm
        for (int i = 0; i < index; i++) {
            Edge currentEdge = edges[i];
            int rootSrc = find(parent, currentEdge.src);
            int rootDest = find(parent, currentEdge.dest);

            if (rootSrc != rootDest) {
                // Include the current edge in the result
                result[resultIndex++] = currentEdge;
                // Perform union to merge the sets of src and dest
                union(parent, rootSrc, rootDest);
            }
        }

        // Print the minimum spanning tree
        System.out.println("Minimum Spanning Tree:");
        for (int i = 0; i < V - 1; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
        }
    }

    static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        // Path compression
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        parent[rootX] = rootY;
    }
}
