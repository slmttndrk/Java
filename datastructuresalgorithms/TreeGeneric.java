package datastructuresalgorithms;

import java.util.ArrayList;
import java.util.List;

/***
 * Types:
 *     - Generic Tree (n-ary Tree) : Each node to have an arbitrary number of children
 *     - Binary Tree
 *     - Binary Search Tree
 *     - AVL Tree
 *     - Heap Tree
 *
 * Terminology:
 *     - Node is the main component of a tree that stores the data along with the links to other nodes
 *     - Edge( also called branch) connects two nodes of a tree. A node can have more than one edge
 *     - Parent node is a predecessor to any other node. In simple words, it is a node in the tree that has branches
 *       to other nodes
 *     - The node which is connected below to another node is called a child of that node. All nodes except the root
 *       node are child nodes
 *     - The first node of the tree which originates it is called the root of the tree. A tree can have only one root
 *     - Nodes with no child are called leaf nodes or external nodes
 *     - Nodes with at least one child is called an internal node or non-leaf nodes
 *     - Nodes having the same parent are called siblings
 *     - The nodes belonging to the same level with different parent nodes
 *     - Degree of a node is defined as the number of children of that node. The degree of the tree is the highest
 *       degree of a node among all the nodes
 *     - The nodes in the tree has to be reachable from other nodes through a unique sequence of edges called path. The
 *       number of edges in a path is called the length of the path
 *     - The level of a node is defined as the number of edges in the unique path between the root and the node
 *     - A tree formed by a node and all of its descendants in the tree is called a subtree
 *
 * Properties:
 *     - An edge can be defined as the connection between two nodes. If a tree has N nodes then it will have (N-1)
 *       edges. There is only one path from each node to any other node of the tree
 *     - The depth of a node is defined as the length of the path from the root to that node. Each edge adds 1 unit
 *       of length to the path. So, it can also be defined as the number of edges in the path from the root of the
 *       tree to the node
 *     - The height of a node can be defined as the length of the longest path from the node to a leaf node of the tree
 *     - The height of a tree is the length of the longest path from the root of the tree to a leaf node of the tree
 *     - The total count of subtrees attached to that node is called the degree of the node. The degree of a leaf
 *       node must be 0. The degree of a tree is the maximum degree of a node among all the nodes in the tree
 *     - Traversing in a tree is done by depth first search and breadth first search algorithm
 *     - It has no loop and no circuit
 *     - It has no self-loop
 *     - Its hierarchical model
 *
 * Operations:
 *
 * Applications:
 *     - Trees can be used to store data which are in hierarchical form
 *     - Different types of trees are used in various fields like in databases, computer graphics, computer networks
 *     - Tree data structure are used by operating system to manage file directory
 *     - Databases use tree data structure for indexing
 *     - Tree data structure is used in file directory management
 *     - DNS uses tree data structure
 *     - Trees are used in severic games like moves in chess
 *     - Decision based algorithms in machine learning uses tree algorithms
 *
 * Algorithms:
 *
 * Advantages:
 *     - Trees provide hierarchical representation for the data
 *     - Trees are dynamic in nature so the number of nodes are not limited
 *     - Insertion and deletion in a tree can be done in moderate time
 *
 * Disadvantages:
 *     - Some trees can only be stored using sequential or chained storage
 *
 */

class GenericTreeNode {
    int data;
    List<GenericTreeNode> children;

    public GenericTreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(GenericTreeNode child) {
        this.children.add(child);
    }

    public List<GenericTreeNode> getChildren() {
        return this.children;
    }

    public int getData() {
        return this.data;
    }
}

public class TreeGeneric {
    public static void main(String[] args) {
        // Create nodes for the tree
        GenericTreeNode genericTreeRoot = new GenericTreeNode(1);
        GenericTreeNode genericTreeNode2 = new GenericTreeNode(2);
        GenericTreeNode genericTreeNode3 = new GenericTreeNode(3);
        GenericTreeNode genericTreeNode4 = new GenericTreeNode(4);
        GenericTreeNode genericTreeNode5 = new GenericTreeNode(5);

        // Build the tree structure
        genericTreeRoot.addChild(genericTreeNode2);
        genericTreeRoot.addChild(genericTreeNode3);
        genericTreeNode2.addChild(new GenericTreeNode(6));
        genericTreeNode2.addChild(new GenericTreeNode(7));
        genericTreeNode3.addChild(genericTreeNode4);
        genericTreeNode3.addChild(genericTreeNode5);

        // Print the tree using depth-first traversal
        System.out.println("Tree structure using depth-first traversal:");
        printTree(genericTreeRoot);
    }

    public static void printTree(GenericTreeNode genericTreeNode) {
        System.out.println(genericTreeNode.getData());

        for (GenericTreeNode child : genericTreeNode.getChildren()) {
            printTree(child);
        }
    }
}
