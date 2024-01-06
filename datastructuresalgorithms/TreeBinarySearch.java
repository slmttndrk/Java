package datastructuresalgorithms;

/***
 * Types:
 *
 * Properties:
 *     - A binary search tree (BST), also called an ordered or sorted binary tree, is a rooted binary tree data
 *       structure with the key of each internal node being greater than all the keys in the respective node's left
 *       subtree and less than the ones in its right subtree. The time complexity of operations on the binary search
 *       tree is directly proportional to the height of the tree
 *     - The left subtree of a node contains only nodes with keys lesser than the node’s key
 *     - The right subtree of a node contains only nodes with keys greater than the node’s key
 *     - The left and right subtree each must also be a binary search tree
 *
 * Operations:
 *     - Searching in a BST: Searching in BST involves the comparison of the key values. If the key value is equal
 *       to root key then, search successful, if lesser than root key then search the key in the left subtree and
 *       if the key is greater than root key then search the key in the right subtree
 *     - Insertion in a BST: Insertion in BST involves the comparison of the key values. If the key value is lesser
 *       than or equal to root key then go to left subtree, find an empty space following to the search algorithm and
 *       insert the data and if the key is greater than root key then go to right subtree, find an empty space
 *       following to the search algorithm and insert the data
 *     - Deletion in a BST: Deletion in BST involves three cases.
 *           - Case 1- If the node to be deleted is leaf node: If the node to be deleted is a leaf node, then delete it.
 *           - Case 2- If the node to be deleted has one child: If the node to be deleted has one child then, delete
 *             the node and place the child of the node at the position of the deleted node.
 *           - Case 3- If the node to be deleted has two children: If the node to be deleted has two children then,
 *             find the inorder successor or inorder predecessor of the node according to the nearest capable value of
 *             the node to be deleted. Delete the inorder successor or predecessor using the above cases. Replace the
 *             node with the inorder successor or predecessor.
 *     - Traversals in a BST: There are 4 types of traversals of the Binary Search Tree.
 *          - (I) Level Order Traversal: Each node of the tree is traversed level by level in order of its appearance.
 *          - (II) Pre-order Traversal: The nodes are traversed in the format of root and then left subtree and then
 *            right subtree.
 *          - (III) Inorder Traversal: The nodes are traversed in the format of left subtree and then root and then
 *            right subtree.
 *          - (IV) Postorder Traversal: The nodes are traversed in the format of left subtree and then right subtree
 *            and then root
 *
 * Applications:
 *     - BSTs are used for indexing
 *     - It is also used to implement various searching algorithms
 *     - IT can be used to implement various data structures
 *     - BSTs are used for indexing in databases
 *     - BSTs are used to implement Huffman coding algorithm
 *     - It is also used to implement dictionaries
 *
 * Algorithms:
 *
 * Advantages:
 *     - BST is fast in insertion and deletion when balanced
 *     - BST is efficient
 *     - We can also do range queries – find keys between N and M (N <= M)
 *     - BST code is simple as compared to other data structures
 *
 * Disadvantages:
 *     - The main disadvantage is that we should always implement a balanced binary search tree. Otherwise the cost of operations may not be logarithmic and degenerate into a linear search on an array
 *     - Accessing the element in BST is slightly slower than array
 *     - A BST can be imbalanced or degenerated which can increase the complexity
 *
 */

import java.util.LinkedList;
import java.util.Queue;

class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private BSTNode insertRec(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(BSTNode root, int data) {
        if (root == null || root.data == data) {
            return root != null;
        }

        if (data < root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BSTNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(BSTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(BSTNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void levelOrderTraversal() {
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            levelOrderTraversalRec(root, i);
        }
    }

    private int getHeight(BSTNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void levelOrderTraversalRec(BSTNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            levelOrderTraversalRec(root.left, level - 1);
            levelOrderTraversalRec(root.right, level - 1);
        }
    }

    public void iterativeLevelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BSTNode current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public int countTotalNodes() {
        return countTotalNodes(root);
    }

    private int countTotalNodes(BSTNode root) {
        if (root == null)
            return 0;

        int counter = 1;
        counter += countTotalNodes(root.left);
        counter += countTotalNodes(root.right);
        return counter;
    }
}

public class TreeBinarySearch {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Perform in-order traversal (depth-first order)
        System.out.println("In-order traversal:");
        bst.inOrderTraversal();

        // Perform pre-order traversal (depth-first order)
        System.out.println("\nPre-order traversal:");
        bst.preOrderTraversal();

        // Perform post-order traversal (depth-first order)
        System.out.println("\nPost-order traversal:");
        bst.postOrderTraversal();

        // Perform level-order traversal (breadth-first order)
        System.out.println("\nLevel-order traversal:");
        bst.levelOrderTraversal();

        // Perform iterative level-order traversal (breadth-first order)
        System.out.println("\nIterative Level-order traversal:");
        bst.iterativeLevelOrderTraversal();

        // Search for a value in the BST
        int searchValue = 40;
        System.out.println("\nSearch for " + searchValue + ": " + bst.search(searchValue));

        // Count total nodes in the BST
        System.out.println("\nTotal number of nodes: " + bst.countTotalNodes());
    }
}
