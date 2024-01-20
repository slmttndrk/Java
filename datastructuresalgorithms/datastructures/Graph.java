package datastructuresalgorithms.datastructures;

/***
 * Graph:
 *
 * A graph is a non-linear kind of data structure made up of nodes or vertices and edges. The edges
 * connect any two nodes in the graph, and the nodes are also known as vertices
 *
 * Terminologies:
 *     - An edge is one of the two primary units used to form graphs. Each edge has two ends, which
 *       are vertices to which it is attached
 *     - If two vertices are endpoints of the same edge, they are adjacent
 *     - A vertex's outgoing edges are directed edges that point to the origin
 *     - A vertex's incoming edges are directed edges that point to the vertex's destination
 *     - The total number of edges occurring to a vertex in a graph is its degree
 *     - The out-degree of a vertex in a directed graph is the total number of outgoing edges,
 *       whereas the in-degree is the total number of incoming edges
 *     - A vertex with an in-degree of zero is referred to as a source vertex, while one with an
 *       out-degree of zero is known as sink vertex
 *     - An isolated vertex is a zero-degree vertex that is not an edge's endpoint
 *     - A path is a set of alternating vertices and edges, with each vertex connected by an edge
 *     - The path that starts and finishes at the same vertex is known as a cycle
 *     - A path with unique vertices is called a simple path
 *     - For each pair of vertices x, y, a graph is strongly connected if it contains a directed
 *       path from x to y and a directed path from y to x
 *     - A directed graph is weakly connected if all of its directed edges are replaced with
 *       undirected edges, resulting in a connected graph. A weakly linked graph's vertices have
 *       at least one out-degree or in-degree
 *     - A tree is a connected forest. The primary form of the tree is called a rooted tree, which
 *       is a free tree
 *     - A spanning subgraph that is also a tree is known as a spanning tree
 *     - A connected component is the unconnected graph's most connected subgraph
 *     - A bridge, which is an edge of removal, would sever the graph
 *     - Forest is a graph without a cycle
 *
 * Types:
 *     - Finite Graph: The graph G=(V, E) is called a finite graph if the number of vertices and
 *       edges in the graph is limited in number
 *     - Infinite Graph: The graph G=(V, E) is called a finite graph if the number of vertices
 *       and edges in the graph is interminable
 *     - Trivial Graph: A graph G= (V, E) is trivial if it contains only a single vertex and no edges
 *     - Simple Graph: If each pair of nodes or vertices in a graph G=(V, E) has only one edge, it
 *       is a simple graph. As a result, there is just one edge linking two vertices, depicting
 *       one-to-one interactions between two elements
 *     - Multi Graph: If there are numerous edges between a pair of vertices in a graph G= (V, E),
 *       the graph is referred to as a multi graph. There are no self-loops in a Multi-graph
 *     - Null Graph: It's a reworked version of a trivial graph. If several vertices but no edges
 *       connect them, a graph G= (V, E) is a null graph
 *     - Complete Graph: If a graph G= (V, E) is also a simple graph, it is complete. Using the edges,
 *       with n number of vertices must be connected. It's also known as a full graph because each
 *       vertex's degree must be n-1
 *     - Pseudo Graph: If a graph G= (V, E) contains a self-loop besides other edges, it is a
 *       pseudo graph
 *     - Regular Graph: If a graph G= (V, E) is a simple graph with the same degree at each vertex,
 *       it is a regular graph. As a result, every whole graph is a regular graph
 *     - Weighted Graph: A graph G= (V, E) is called a labeled or weighted graph because each edge
 *       has a value or weight representing the cost of traversing that edge
 *     - Directed Graph: A directed graph also referred to as a digraph, is a set of nodes connected
 *       by edges, each with a direction
 *     - Undirected Graph: An undirected graph comprises a set of nodes and links connecting them.
 *       The order of the two connected vertices is irrelevant and has no direction. You can form an
 *       undirected graph with a finite number of vertices and edges
 *     - Connected Graph: If there is a path between one vertex of a graph data structure and any
 *       other vertex, the graph is connected
 *     - Disconnected Graph: When there is no edge linking the vertices, you refer to the null graph
 *       as a disconnected graph
 *     - Cyclic Graph: If a graph contains at least one graph cycle, it is considered to be cyclic
 *     - Acyclic Graph: When there are no cycles in a graph, it is called an acyclic graph
 *     - Directed Acyclic Graph: It's also known as a directed acyclic graph (DAG), and it's a graph
 *       with directed edges but no cycle. It represents the edges using an ordered pair of vertices
 *       since it directs the vertices and stores some data
 *     - Subgraph: The vertices and edges of a graph that are subsets of another graph are known as
 *       a subgraph
 *
 * Properties:
 *     - Adjacency Matrix: The adjacency matrix of a simple labeled graph, also known as the
 *       connection matrix, is a matrix with rows and columns labeled by graph vertices and a 1 or 0
 *       in position depending on whether they are adjacent or not
 *     - Adjacency List: A finite graph is represented by an adjacency list, which is a collection
 *       of unordered lists. Each unordered list describes the set of neighbors of a particular
 *       vertex in the graph within an adjacency list
 *
 * Operations:
 *     - Creating graphs
 *     - Insert vertex
 *     - Delete vertex
 *     - Insert edge
 *     - Delete edge
 *
 * Applications:
 *     - Graphs are used to represent flow of control in computers
 *     - Graphs are used in social networking sites where users act as nodes and connection between
 *       them acts as edges
 *     - In an operating system, graphs are used as resource allocation graphs
 *     - Graphs are used in Google maps to find the shortest route
 *     - Graphs are also used in airlines system for effective route optimization
 *     - In-state transition diagrams, the graph is used to represent their states and their
 *       transition
 *     - In transportation, graphs are used to find the shortest path
 *     - In circuits, graphs can be used to represent circuit points as nodes and wires as edges
 *     - Graphs are used in solving puzzles with only one solution, such as mazes
 *     - Graphs are used in computer networks for Peer to peer (P2P) applications
 *     - Graphs basically in the form of DAG(Directed acyclic graph) are used as alternative to
 *       blockchain for cryptocurrency. For example crypto like IOTA, Nano are mainly based on DAG
 *
 * Algorithms:
 *
 * Advantages:
 *     - By using graphs we can easily find the shortest path, neighbors of the nodes, and many more
 *     - Graphs are used to implement algorithms like DFS and BFS
 *     - It is used to find minimum spanning tree which has many practical applications
 *     - It helps in organizing data
 *     - Because of its non-linear structure, helps in understanding complex problems and their
 *       visualization
 *
 * Disadvantages:
 *     - Graphs use lots of pointers which can be complex to handle
 *     - It can have large memory complexity
 *     - If the graph is represented with an adjacency matrix then it does not allow parallel edges
 *       and multiplication of the graph is also difficult
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    public static void main(String[] args) {
        GraphAdjacencyMatrix gam = new GraphAdjacencyMatrix(3);
        gam.addEdge(0, 1);
        gam.addEdge(1, 2);
        gam.addEdge(2, 0);
        gam.printGraph();
        System.out.println();

        GraphAdjacencyList gal = new GraphAdjacencyList(3);
        gal.addEdge(0, 1);
        gal.addEdge(1, 2);
        gal.addEdge(2, 0);
        gal.printGraph();
        System.out.println();

        GraphEdgeList gel = new GraphEdgeList(3);
        gel.addEdge(0, 1);
        gel.addEdge(1, 2);
        gel.addEdge(2, 0);
        gel.printGraph();
        System.out.println();

        GraphObjectOriented goo = new GraphObjectOriented();
        GraphObjectOriented.Vertex v0 = new GraphObjectOriented.Vertex(0);
        GraphObjectOriented.Vertex v1 = new GraphObjectOriented.Vertex(1);
        GraphObjectOriented.Vertex v2 = new GraphObjectOriented.Vertex(2);
        goo.vertices.add(v0);
        goo.vertices.add(v1);
        goo.vertices.add(v2);
        goo.addEdge(v0, v1);
        goo.addEdge(v1, v2);
        goo.addEdge(v2, v0);
        goo.printGraph();
    }
}

class GraphAdjacencyMatrix {
    int V; // Number of vertices
    boolean[][] adjacencyMatrix;

    // Constructor
    public GraphAdjacencyMatrix(int V) {
        this.V = V;
        this.adjacencyMatrix = new boolean[V][V];
    }

    // Method to add an edge
    public void addEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = true;
        adjacencyMatrix[dest][src] = true; // For undirected graph
    }

    // Method to print the graph
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjacencyMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    // Additional methods as needed
}

class GraphAdjacencyList {
    int V; // Number of vertices
    List<List<Integer>> adjacencyList;

    // Constructor
    public GraphAdjacencyList(int V) {
        this.V = V;
        this.adjacencyList = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new LinkedList<>());
        }
    }

    // Method to add an edge
    public void addEdge(int src, int dest) {
        adjacencyList.get(src).add(dest);
        adjacencyList.get(dest).add(src); // For undirected graph
    }

    // Method to print the graph
    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Additional methods as needed
}

class GraphEdgeList {
    int V; // Number of vertices
    List<Edge> edges;

    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Constructor
    public GraphEdgeList(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
    }

    // Method to add an edge
    public void addEdge(int src, int dest) {
        edges.add(new Edge(src, dest));
        edges.add(new Edge(dest, src)); // For undirected graph
    }

    // Method to print the graph
    public void printGraph() {
        System.out.println("Edge List:");
        for (Edge edge : edges) {
            System.out.println(edge.src + " -- " + edge.dest);
        }
    }

    // Additional methods as needed
}

class GraphObjectOriented {
    List<Vertex> vertices;

    static class Vertex {
        int data;
        List<Edge> edges;

        public Vertex(int data) {
            this.data = data;
            this.edges = new ArrayList<>();
        }

        // Additional methods for Vertex as needed
    }

    static class Edge {
        Vertex source, destination;

        public Edge(Vertex source, Vertex destination) {
            this.source = source;
            this.destination = destination;
        }

        // Additional methods for Edge as needed
    }

    // Constructor
    public GraphObjectOriented() {
        this.vertices = new ArrayList<>();
    }

    // Method to add a vertex
    public void addVertex(int data) {
        vertices.add(new Vertex(data));
    }

    // Method to add an edge
    public void addEdge(Vertex src, Vertex dest) {
        src.edges.add(new Edge(src, dest));
        dest.edges.add(new Edge(dest, src)); // For undirected graph
    }

    // Method to print the graph
    public void printGraph() {
        System.out.println("Object-Oriented Representation:");
        for (Vertex vertex : vertices) {
            System.out.print("Vertex " + vertex.data + " connected to: ");
            for (Edge edge : vertex.edges) {
                System.out.print(edge.destination.data + " ");
            }
            System.out.println();
        }
    }

    // Additional methods as needed
}
