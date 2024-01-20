package datastructuresalgorithms;

/***
 * AVL(Adelson-Velskii and Landis) Tree
 *
 * An AVL tree in data structure is a binary tree that is self-balanced by checking the balance factor
 * of every node. It means that the height of the left subtree and the right subtree is balanced. The
 * balance factor should either be -1, 0, or 1. The maximum height difference between the left and
 * right subtrees can only be 1. In case, the difference is greater than 1, then we must re-balance
 * the tree to make it valid using rotation techniques
 *
 * Properties:
 *
 * Operations:
 *
 * Applications:
 *     - In-memory sorts of sets and dictionaries
 *     - Database applications that require frequent lookups for data
 *
 * Algorithms:
 *
 * Advantages:
 *     - AVL trees provide faster lookups than Red-Black Trees because they are more strictly balanced
 *     - AVL trees are used in databases where faster retrievals are required
 *     - The height of the AVL tree is always balanced. The height never grows beyond log N, where N
 *       is the total number of nodes in the tree
 *     - It gives better search time complexity when compared to simple Binary Search trees
 *     - AVL trees have self-balancing capabilities
 *
 * Disadvantages:
 *     - AVL trees provide complex insertion and removal operations as more rotations are done due to
 *       relatively relaxed balancing
 *     - Take more processing for balancing
 *
 */

class NodeAVL {
    int key, height;
    NodeAVL left, right;

    NodeAVL(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class TreeAVL {
    private NodeAVL root;

    // Get height of a node
    private int height(NodeAVL node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Get balance factor of a node
    private int getBalance(NodeAVL node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Rotate right subtree rooted with y
    private NodeAVL rightRotate(NodeAVL y) {
        NodeAVL x = y.left;
        NodeAVL T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Rotate left subtree rooted with x
    private NodeAVL leftRotate(NodeAVL x) {
        NodeAVL y = x.right;
        NodeAVL T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a key into the tree
    public void insert(int key) {
        root = insert(root, key);
    }

    private NodeAVL insert(NodeAVL node, int key) {
        // Perform standard BST insert
        if (node == null)
            return new NodeAVL(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate keys are not allowed

        // Update height of current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Print the tree in-order
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(NodeAVL node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        TreeAVL avlTree = new TreeAVL();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);

        System.out.println("In-order traversal of AVL tree:");
        avlTree.inOrder();
    }
}
