package datastructuresalgorithms;

import java.util.ArrayList;
import java.util.List;

/***
 * Types:
 *     - Full Binary Tree: A Binary Tree is a full binary tree if every node has 0 or 2 children. We can also say a
 *       full binary tree is a binary tree in which all nodes except leaf nodes have two children. It is also known
 *       as a proper binary tree
 *     - Complete Binary Tree: A Binary Tree is a Complete Binary Tree if all the levels are completely filled except
 *       possibly the last level and the last level has all keys as left as possible.A complete binary tree is just
 *       like a full binary tree, but with two major differences.
 *           (I)  Every level must be completely filled.
 *           (II) All the leaf elements must lean towards the left
 *     - Perfect Binary Tree: A Binary tree is a Perfect Binary Tree in which all the internal nodes have two children
 *       and all leaf nodes are at the same level
 *     - Balanced Binary Tree: A binary tree is balanced if the height of the tree is O(Log n) where n is the number
 *       of nodes. For Example:
 *           - the AVL tree maintains O(Log n) height by making sure that the difference between the heights of the
 *             left and right subtrees is at most 1
 *           - Red-Black trees maintain O(Log n) height by making sure that the number of Black nodes on every root
 *             to leaf paths is the same and there are no adjacent red nodes
 *           - Balanced Binary Search trees are performance-wise good as they provide O(log n) time for search,
 *             insert and delete
 *     - A degenerate (or pathological) tree: A Tree where every internal node has one child. Such trees are
 *       performance-wise same as linked list.A degenerate or pathological tree is the tree having a single child
 *       either left or right
 *     - Skewed Binary Tree: A skewed binary tree is a pathological/degenerate tree in which the tree is either
 *       dominated by the left nodes or the right nodes. Thus, there are two types of skewed binary tree: left-skewed
 *       binary tree and right-skewed binary tree
 *
 * Properties:
 *     - The maximum number of nodes at level ‘l’ of a binary tree is 2**l
 *     - The Maximum number of nodes in a binary tree of height ‘h’ is 2**h – 1
 *     - In a Binary Tree with N nodes, minimum possible height or the minimum number of levels is Log2(N+1)
 *     - A Binary Tree with L leaves has at least | Log2L |+ 1 levels
 *     - In Binary tree where every node has 0 or 2 children, the number of leaf nodes is always one more than nodes
 *       with two children
 *     - In a non-empty binary tree, if n is the total number of nodes and e is the total number of edges,
 *       then e = n-1
 *
 * Operations:
 *
 * Applications:
 *     - Huffman coding tree is an application of binary trees that are used in data compression algorithms
 *     - In compilers, Expression Trees are used which are applications of binary trees
 *     - Priority Queue is another application of binary tree that is used to search maximum or minimum in O(log N)
 *       time complexity
 *     - Represent hierarchical data
 *     - Used in editing software like Microsoft Excel and spreadsheets
 *     - Useful for indexing segmented at the database is useful in storing cache in the system
 *     - Syntax trees are used for most famous compilers for programming like GCC, and AOCL to perform arithmetic
 *       operations
 *     - For implementing priority queues
 *     - Used to find elements in less time (binary search tree)
 *     - Used to enable fast memory allocation in computers
 *     - To perform encoding and decoding operations
 *     - DOM in HTML
 *     - File explorer
 *     - Used as the basic data structure in Microsoft Excel and spreadsheets
 *     - Routing Algorithms
 *     - Evaluate an expression
 *
 * Algorithms:
 *
 * Advantages:
 *     - The searching operation in a binary tree is very fast
 *     - The representation of a binary tree is simple and easy to understand
 *     - Traversing from a parent node to its child node and vice-versa is efficiently done
 *     - Simple to implement
 *     - Easy to understand
 *     - Reflect structural relationships that are present in the data set
 *     - Executions are fast
 *     - Store an arbitrary number of data values
 *
 * Disadvantages:
 *     - In binary tree traversals, there are many pointers that are null and hence useless
 *     - The access operation in a Binary Search Tree (BST) is slower than in an array
 *     - A basic option is dependent on the height of the tree
 *     - Deletion node not easy
 *     - A basic option is based on the height of tree
 *
 */

class BinaryTreeNode {
    int data;
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void addChild(BinaryTreeNode child) {
        if (this.leftChild == null){
            this.leftChild = child;
        }
        else if (this.rightChild == null){
            this.rightChild = child;
        }
        else{
            throw new IllegalStateException("Children capacity is full for this parent.");
        }

    }

    public List<BinaryTreeNode> getChildren() {
        List<BinaryTreeNode> children = new ArrayList<>();
        if (this.leftChild != null){
            children.add(this.leftChild);
        }
        if (this.rightChild != null){
            children.add(this.rightChild);
        }
        return children;
    }

    public int getData() {
        return this.data;
    }
}

public class TreeBinary {
    public static void main(String[] args) {
        // Create nodes for the tree
        BinaryTreeNode binaryTreeRoot = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);

        // Build the tree structure
        binaryTreeRoot.addChild(binaryTreeNode2);
        binaryTreeRoot.addChild(binaryTreeNode3);
        binaryTreeNode2.addChild(new BinaryTreeNode(6));
        binaryTreeNode2.addChild(new BinaryTreeNode(7));
        binaryTreeNode3.addChild(binaryTreeNode4);
        binaryTreeNode3.addChild(binaryTreeNode5);

        // Print the tree using depth-first traversal
        System.out.println("Binary Tree structure using depth-first traversal:");
        printTree(binaryTreeRoot);
    }

    public static void printTree(BinaryTreeNode binaryTreeNode) {
        System.out.println(binaryTreeNode.getData());

        for (BinaryTreeNode child : binaryTreeNode.getChildren()) {
            printTree(child);
        }
    }
}
