package datastructuresalgorithms.algorithms;

/***
 * Dynamic Programming is a technique in computer programming that helps to efficiently solve a
 * class of problems that have overlapping sub-problems and optimal substructure property
 *
 * Characteristics of Dynamic Programming:
 *     - Optimal Substructure: A given problem has Optimal Substructure Property if the optimal
 *       solution of the given problem can be obtained by using optimal solutions of its sub-problems
 *       For example, the Shortest Path problem has the following optimal substructure property:
 *       If a node x lies in the shortest path from a source node u to destination node v then the
 *       shortest path from u to v is a combination of the shortest path from u to x and the shortest
 *       path from x to v. The standard All Pair Shortest Path algorithm like Floyd–Warshall and
 *       Single Source Shortest path algorithm for negative weight edges like Bellman–Ford are
 *       typical examples of Dynamic Programming
 *
 *     - Overlapping Sub-problems: Like Divide and Conquer, Dynamic Programming combines solutions
 *       to sub-problems. Dynamic Programming is mainly used when solutions to the same sub-problems
 *       are needed again and again. In dynamic programming, computed solutions to sub-problems are
 *       stored in a table so that these don’t have to be recomputed. So Dynamic Programming is not
 *       useful when there are no common (overlapping) sub-problems because there is no point in
 *       storing the solutions if they are not needed again
 *
 * Tabulation and Memoization:
 *     - Tabulation Method – Bottom Up Dynamic Programming: As the name itself suggests starting
 *       from the bottom and accumulating answers to the top. Let’s discuss in terms of state
 *       transition.
 *     - Let’s describe a state for our DP problem to be dp[x] with dp[0] as base state and dp[n] as
 *       our destination state. So, we need to find the value of destination state i.e dp[n]. If we
 *       start our transition from our base state i.e. dp[0] and follow our state transition relation
 *       to reach our destination state dp[n], we call it the Bottom-Up approach as it is quite clear
 *       that we started our transition from the bottom base state and reached the topmost desired
 *       state
 *     - Memoization Method – Top-Down Dynamic Programming: Once, again let’s describe it in terms of
 *       state transition. If we need to find the value for some state say dp[n] and instead of starting
 *       from the base state that i.e. dp[0] we ask our answer from the states that can reach the
 *       destination state dp[n] following the state transition relation, then it is the top-down fashion
 *       of DP.
 *     - Here, we start our journey from the top most destination state and compute its answer by
 *       taking in count the values of states that can reach the destination state, till we reach the
 *       bottom-most base state
 *
 * How to solve a Dynamic Programming Problem:
 *     - Step 1: How to classify a problem as a Dynamic Programming Problem
 *          Typically, all the problems that require maximizing or minimize certain quantities or
 *          counting problems that say to count the arrangements under certain conditions or
 *          certain probability problems can be solved by using Dynamic Programming.
 *          All dynamic programming problems satisfy the overlapping sub-problems property and most of
 *          the classic dynamic problems also satisfy the optimal substructure property. Once, we
 *          observe these properties in a given problem, be sure that it can be solved using DP
 *
 *      - Step 2: Deciding the state
 *          DP problems are all about state and their transition. This is the most basic step which
 *          must be done very carefully because the state transition depends on the choice of state
 *          definition you make. So, let’s see what do we mean by the term “state”.
 *          State A state can be defined as the set of parameters that can uniquely identify a certain
 *          position or standing in the given problem. This set of parameters should be as small as
 *          possible to reduce state space.
 *          For example: In our famous Knapsack problem, we define our state by two parameters index
 *          and weight i.e DP[index][weight]. Here DP[index][weight] tells us the maximum profit it
 *          can make by taking items from range 0 to index having the capacity of sack to be weight.
 *          Therefore, here the parameters index and weight together can uniquely identify a
 *          sub-problem for the knapsack problem
 *          So, our first step will be deciding a state for the problem after identifying that the
 *          problem is a DP problem
 *          As we know DP is all about using calculated results to formulate the final result. So,
 *          our next step will be to find a relation between previous states to reach the current
 *          state
 *
 *      - Step 3: Formulating a relation among the states
 *          This part is the hardest part of solving a DP problem and requires a lot of intuition,
 *          observation, and practice
 *
 *      - Step 4: Adding memoization or tabulation for the state
 *          This is the easiest part of a dynamic programming solution. We just need to store the
 *          state answer so that next time that state is required, we can directly use it from our
 *          memory
 *
 */

public class DynamicProgramming {
}

class KnapsackDynamicProgramming {

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        int maxValue = knapsackDynamicProgramming(weights, values, capacity);

        System.out.println("Maximum value in the knapsack: " + maxValue);
    }

    static int knapsackDynamicProgramming(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the dynamic programming table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }
}

// Shortest path between two nodes in a weighted directed graph using the Floyd-Warshall algorithm
class ShortestPathDynamicProgramming {

    public static void main(String[] args) {
        int[][] graph = {
                {0, 5, Integer.MAX_VALUE, 10},
                {Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };

        int[][] shortestPathMatrix = floydWarshall(graph);

        System.out.println("Shortest path matrix:");
        printMatrix(shortestPathMatrix);
    }

    static int[][] floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // Initialize dist matrix with the same values as the input graph
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Compute the shortest path matrix using dynamic programming
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(matrix[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
