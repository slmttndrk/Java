package datastructuresalgorithms.algorithms;

/**
 * DFSRecursive:
 * ============
 *  procedure DFS(G, v) is
 *     label v as discovered
 *     if v is the goal then
 *         return v
 *     for all directed edges from v to w that are in G.adjacentEdges(v) do
 *         if vertex w is not labeled as discovered then
 *             recursively call DFS(G, w)
 *
 * DFSIterative:
 * ============
 *  procedure DFS_iterative(G, v) is
 *     let S be a stack
 *     S.push(v)
 *     while S is not empty do
 *         v = S.pop()
 *         if v is the goal then
 *             return v
 *         if v is not labeled as discovered then
 *             label v as discovered
 *             for all edges from v to w in G.adjacentEdges(v) do
 *                 S.push(w)
 * */

import java.util.LinkedList;
import java.util.Stack;

public class SearchDepthFirst {
    static class Graph {
        private final int vertices;
        private final LinkedList<Integer>[] adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adjacencyList[v].add(w);
        }

        LinkedList<Integer> getAdjacencyList(int v) {
            return adjacencyList[v];
        }
    }

    public static void main(String[] args) {
        // Create a sample graph
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);

        System.out.println("DFS Recursive Traversal starting from vertex 0:");
        dfsRecursive(graph, 0, new boolean[graph.vertices]);

        System.out.println("\nDFS Iterative Traversal starting from vertex 0:");
        dfsIterative(graph, 0);

        int searchVertex = 4;
        System.out.println("\nDFSRecursiveSearch for vertex " + searchVertex + " :");
        int foundVertexRecursive = dfsRecursiveSearch(graph, 0, searchVertex, new boolean[graph.vertices]);

        if (foundVertexRecursive != -1) {
            System.out.println("Vertex " + searchVertex + " found in the graph (DFS Recursive).");
        } else {
            System.out.println("Vertex " + searchVertex + " not found in the graph (DFS Recursive).");
        }

        System.out.println("DFSIterativeSearch for vertex " + searchVertex + " :");
        int foundVertexIterative = dfsIterativeSearch(graph, 0, searchVertex);

        if (foundVertexIterative != -1) {
            System.out.println("Vertex " + searchVertex + " found in the graph (DFS Iterative).");
        } else {
            System.out.println("Vertex " + searchVertex + " not found in the graph (DFS Iterative).");
        }
    }

    static void dfsRecursive(Graph graph, int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");

        LinkedList<Integer> adjacencyList = graph.getAdjacencyList(currentVertex);
        for (Integer adjacentVertex : adjacencyList) {
            if (!visited[adjacentVertex]) {
                dfsRecursive(graph, adjacentVertex, visited);
            }
        }
    }

    static void dfsIterative(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.vertices];
        Stack<Integer> stack = new Stack<>();

        visited[startVertex] = true;
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");

            LinkedList<Integer> adjacencyList = graph.getAdjacencyList(currentVertex);
            for (Integer adjacentVertex : adjacencyList) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    stack.push(adjacentVertex);
                }
            }
        }
    }

    static int dfsRecursiveSearch(Graph graph, int currentVertex, int searchVertex, boolean[] visited) {
        visited[currentVertex] = true;

        if (currentVertex == searchVertex) {
            return currentVertex; // Return the found vertex
        }

        LinkedList<Integer> adjacencyList = graph.getAdjacencyList(currentVertex);
        for (Integer adjacentVertex : adjacencyList) {
            if (!visited[adjacentVertex]) {
                int result = dfsRecursiveSearch(graph, adjacentVertex, searchVertex, visited);
                if (result != -1) {
                    return result; // Vertex found in the recursive call
                }
            }
        }

        return -1; // Vertex not found
    }

    static int dfsIterativeSearch(Graph graph, int startVertex, int searchVertex) {
        boolean[] visited = new boolean[graph.vertices];
        Stack<Integer> stack = new Stack<>();

        visited[startVertex] = true;
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (currentVertex == searchVertex) {
                return currentVertex; // Return the found vertex
            }

            LinkedList<Integer> adjacencyList = graph.getAdjacencyList(currentVertex);
            for (Integer adjacentVertex : adjacencyList) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    stack.push(adjacentVertex);
                }
            }
        }

        return -1; // Vertex not found
    }
}
