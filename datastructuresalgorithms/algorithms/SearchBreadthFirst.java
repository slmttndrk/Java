package datastructuresalgorithms.algorithms;

/**
 * BFSIterative:
 * ============
 *  1  procedure BFS(G, root) is
 *  2      let Q be a queue
 *  3      label root as explored
 *  4      Q.enqueue(root)
 *  5      while Q is not empty do
 *  6          v := Q.dequeue()
 *  7          if v is the goal then
 *  8              return v
 *  9          for all edges from v to w in G.adjacentEdges(v) do
 * 10              if w is not labeled as explored then
 * 11                  label w as explored
 * 12                  w.parent := v
 * 13                  Q.enqueue(w)
 * */

import java.util.LinkedList;
import java.util.Queue;

public class SearchBreadthFirst {
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
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("BFS Iterative starting from vertex 0:");
        bfsIterative(graph, 0);

        int searchVertex = 4;
        System.out.println("\nBFS for vertex " + searchVertex + " :");
        int foundVertex = bfsIterativeSearch(graph, 0, searchVertex);

        if (foundVertex != -1) {
            System.out.println("Vertex " + searchVertex + " found in the graph.");
        } else {
            System.out.println("Vertex " + searchVertex + " not found in the graph.");
        }
    }

    // BFS is typically implemented using an iterative approach rather than a recursive one
    static void bfsIterative(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            LinkedList<Integer> adjacencyList = graph.getAdjacencyList(currentVertex);
            for (Integer adjacentVertex : adjacencyList) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                }
            }
        }
    }

    static int bfsIterativeSearch(Graph graph, int startVertex, int searchVertex) {
        boolean[] visited = new boolean[graph.vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            if (currentVertex == searchVertex) {
                return currentVertex; // Return the found vertex
            }

            LinkedList<Integer> adjacencyList = graph.getAdjacencyList(currentVertex);
            for (Integer adjacentVertex : adjacencyList) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                }
            }
        }

        return -1; // Vertex not found
    }
}
