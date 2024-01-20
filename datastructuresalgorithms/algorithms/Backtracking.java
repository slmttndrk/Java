package datastructuresalgorithms.algorithms;

/***
 * Think about a scenario where you are standing outside a maze, and you need to find the exit. Now,
 * you have a couple of ways you can try to find the exit door, uncertain of the outcome. You may
 * either run into some wrong path, backtrack(move back to the starting point) and try to find a new
 * path, or one in many chances, you may land into the correct path and reach your exit door. But out
 * of multiple scenarios, you have only one path(marked in green) which will lead you to the exit door.
 *
 * For any backtracking problem, the backtracking algorithm tries to go through one of the paths to
 * reach to the possible solution, and if the path doesn't lead them there, then the problem
 * backtracks through the same path and takes another path in search of the solution.
 *
 * To understand this clearly, consider the given example. Suppose you are standing in front of
 * three roads, one of which is having a bag of gold at it's end, but you don't know which one it is.
 * Firstly you will go in Path 1 , if that is not the one, then come out of it, and go into Path 2 ,
 * and again if that is not the one, come out of it and go into Path 3 . So, let's say we are standing
 * at 'A' and we divided our problem into three smaller sub-problems 'B', 'D' and 'F'. And using this
 * sub-problem, we have three possible path to get to our solution -- 'C', 'E', & 'G'.
 *
 * There are three types of problems in backtracking:
 *
 *     - Decision Problem – In this, we search for a feasible solution.
 *     - Optimization Problem – In this, we search for the best solution.
 *     - Enumeration Problem – In this, we find all feasible solutions
 *
 * Backtracking Algorithm Properties:
 *
 *     - A backtracking algorithm uses the depth-first search method. When it starts exploring the
 *       solutions, a bounding function is applied so that the algorithm can check if the so-far built
 *       solution satisfies the constraints. If it does, it continues searching. If it doesn't, the
 *       branch would be eliminated, and the algorithm goes back to the level before.
 *     - It uses recursive calling to find a solution set by building a solution step by step,
 *       increasing levels with time. In order to find these solutions, a search tree named state-space
 *       tree is used. In a state-space tree, each branch is a variable, and each level represents a
 *       solution.
 *     - Backtracking is used to solve a problem that have multiple solutions.
 *
 * Application of Backtracking:
 *     - To find all Hamiltonian Paths present in a graph.
 *     - To solve the N Queen problem.
 *     - Maze solving problem.
 *     - The Knight's tour problem.
 *     - Binary Strings: generating all binary strings
 *     - Generating k – ary Strings
 *     - The Knapsack Problem
 *     - Graph Coloring Problem
 *
 * Advantage of Backtracking:
 *     - Backtracking can almost solve any problems, due to its brute-force nature, although we use
 *       it to solve problems which have branching involved.
 *     - Backtracking is an easy method to implement and contains fewer lines of code.
 *
 * Disadvantage of Backtracking:
 *     - More optimal algorithms for the given problem may exist.
 *     - When the branching factor is high, it is very time-consuming
 *     - Large space complexity because we are using recursion so function information is stored on
 *       stack.
 *
 */

public class Backtracking {
}

class KnapsackBacktracking {
    static int maxWeight; // maximum weight allowed in the knapsack
    static int[] weights; // array of item weights
    static int[] values;  // array of item values
    static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // Example data
        maxWeight = 10;
        weights = new int[]{2, 3, 4, 5};
        values = new int[]{3, 4, 5, 6};

        // Solve the Knapsack problem
        knapsack(0, 0, 0);

        System.out.println("Maximum value in the knapsack: " + maxResult);
    }

    static void knapsack(int currentWeight, int currentValue, int index) {
        // Base case: check if the knapsack is full or all items are considered
        if (currentWeight > maxWeight || index == weights.length) {
            return;
        }

        // Include the current item
        int newWeight = currentWeight + weights[index];
        int newValue = currentValue + values[index];
        maxResult = Math.max(maxResult, newValue);

        // Explore with including the current item
        knapsack(newWeight, newValue, index + 1);

        // Explore without including the current item
        knapsack(currentWeight, currentValue, index + 1);
    }
}

class MazeSolver {
    static int N = 5; // Size of the maze
    static int[][] maze = {
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1}
    };
    static int[][] solution = new int[N][N];

    public static void main(String[] args) {
        if (solveMaze(0, 0)) {
            System.out.println("Maze solved:");
            printSolution();
        } else {
            System.out.println("No solution exists.");
        }
    }

    static boolean solveMaze(int row, int col) {
        // Check if we reached the end of the maze
        if (row == N - 1 && col == N - 1) {
            solution[row][col] = 1;
            return true;
        }

        // Check if the current cell is valid
        if (isSafe(row, col)) {
            // Mark the current cell as part of the solution path
            solution[row][col] = 1;

            // Move down
            if (solveMaze(row + 1, col))
                return true;

            // Move right
            if (solveMaze(row, col + 1))
                return true;

            // If neither down nor right is a valid move, backtrack
            solution[row][col] = 0;
        }

        return false;
    }

    static boolean isSafe(int row, int col) {
        // Check if the cell is within the maze boundaries and is not blocked (0)
        return row >= 0 && row < N && col >= 0 && col < N && maze[row][col] == 1;
    }

    static void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class NQueens {
    static int N = 8; // Number of queens (adjustable)

    public static void main(String[] args) {
        solveNQueens();
    }

    static void solveNQueens() {
        int[][] board = new int[N][N];

        if (solveNQueensUtil(board, 0)) {
            printSolution(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    static boolean solveNQueensUtil(int[][] board, int col) {
        if (col == N) {
            return true; // All queens are placed successfully
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place queen

                if (solveNQueensUtil(board, col + 1)) {
                    return true; // Recur to place the rest of the queens
                }

                // If placing the queen in the current position doesn't lead to a solution
                // then remove the queen from the current position (backtrack)
                board[i][col] = 0;
            }
        }

        return false; // Queen can't be placed in any row of the current column
    }

    static boolean isSafe(int[][] board, int row, int col) {
        // Check for queens in the same row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check for queens in the upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check for queens in the lower diagonal on the left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true; // If no conflict is found
    }

    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

