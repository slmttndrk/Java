package datastructuresalgorithms;

/***
 * Trie: (pronounced "try")
 *
 * Trie is a sorted tree-based data-structure that stores the set of strings. It has the number of
 * pointers equal to the number of characters of the alphabet in each node. It can search a word
 * in the dictionary with the help of the word's prefix. For example, if we assume that all strings
 * are formed from the letters 'a' to 'z' in the English alphabet, each trie node can have a maximum
 * of 26 points.
 * Trie is also known as the digital tree or prefix tree. The position of a node in the Trie
 * determines the key with which that node is connected.
 *
 * Properties:
 *     - The root node of the trie always represents the null node
 *     - Each child of nodes is sorted alphabetically
 *     - Each node can have a maximum of 26 children (A to Z)
 *     - Each node (except the root) can store one letter of the alphabet
 *
 * Operations:
 *     - Insertion of a node:
 *     - Every letter of the input key (word) is inserted as an individual in the Trie_node.
 *       Note that children point to the next level of Trie nodes.
 *     - The key character array acts as an index of children.
 *     - If the present node already has a reference to the present letter, set the present
 *       node to that referenced node. Otherwise, create a new node, set the letter to be equal
 *       to the present letter, and even start the present node with this new node.
 *     - The character length determines the depth of the trie
 *     - Searching a node in Trie: The searching operation is similar to the insertion operation.
 *       The search operation is used to search a key in the trie
 *     - Deletion of a node in the Trie:
 *          - If the key is not found in the trie, the delete operation will stop and exit it.
 *          - If the key is found in the trie, delete it from the trie.
 *
 * Applications:
 *     - Spell Checker: Spell checking is a three-step process. First, look for that word in a
 *       dictionary, generate possible suggestions, and then sort the suggestion words with the
 *       desired word at the top.
 *       Trie is used to store the word in dictionaries. The spell checker can easily be applied
 *       in the most efficient way by searching for words on a data structure. Using trie not only
 *       makes it easy to see the word in the dictionary, but it is also simple to build an
 *       algorithm to include a collection of relevant words or suggestions
 *     - Auto-complete: Auto-complete functionality is widely used on text editors, mobile
 *       applications, and the Internet. It provides a simple way to find an alternative word to
 *       complete the word
 *     - Browser history: It is also used to complete the URL in the browser. The browser keeps a
 *       history of the URLs of the websites you've visited
 *
 * Algorithms:
 *
 * Advantages:
 *     - It can be insert faster and search the string than hash tables and binary search trees
 *     - It provides an alphabetical filter of entries by the key of the node
 *
 * Disadvantages:
 *     - It requires more memory to store the strings
 *     - It is slower than the hash table
 *
 */

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26]; // Assuming only lowercase English letters
        this.isEndOfWord = false;
    }

    // Print words in the trie starting from this node
    public void printTrie(String prefix) {
        if (isEndOfWord) {
            System.out.println(prefix);
        }

        for (int i = 0; i < 26; i++) {
            if (children[i] != null) {
                char ch = (char) ('a' + i);
                children[i].printTrie(prefix + ch);
            }
        }
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEndOfWord = true;
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (node.children[index] == null) {
                return false;
            }

            node = node.children[index];
        }

        return node != null && node.isEndOfWord;
    }

    // Print all words in the trie
    public void printTrie() {
        root.printTrie("");
    }

    // Example usage
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");

        System.out.println("Search 'app': " + trie.search("app")); // true
        System.out.println("Search 'appl': " + trie.search("appl")); // false
        System.out.println("Search 'orange': " + trie.search("orange")); // false

        System.out.println("Words in the Trie:");
        trie.printTrie();
    }
}
