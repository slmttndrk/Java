package datastructuresalgorithms.algorithms;

/***
 * The process in which a function calls itself directly or indirectly is called recursion and the
 * corresponding function is called a recursive function. Using a recursive algorithm, certain
 * problems can be solved quite easily. Examples of such problems are Towers of Hanoi (TOH),
 * Inorder/Preorder/Postorder Tree Traversals, DFS of Graph, etc. A recursive function solves a
 * particular problem by calling a copy of itself and solving smaller sub-problems of the original
 * problems. Many more recursive calls can be generated as and when required. It is essential to
 * know that we should provide a certain case in order to terminate this recursion process. So we
 * can say that every time the function calls itself with a simpler version of the original problem
 *
 * Types:
 *     - Tail Recursion: A recursive function is tail recursive when a recursive call is the last
 *       thing executed by the function. The tail recursive functions considered better than non-tail
 *       recursive functions as tail-recursion can be optimized by the compiler. Compilers usually
 *       execute recursive procedures by using a stack. This stack consists of all the pertinent
 *       information, including the parameter values, for each recursive call. When a procedure is
 *       called, its information is pushed onto a stack, and when the function terminates the
 *       information is popped out of the stack. Thus for the non-tail-recursive functions, the
 *       stack depth (maximum amount of stack space used at any time during compilation) is more.
 *       The idea used by compilers to optimize tail-recursive functions is simple, since the
 *       recursive call is the last statement, there is nothing left to do in the current function,
 *       so saving the current function’s stack frame is of no use
 *     - Non-tail Recursion: A recursive function is said to be non-tail recursive in case the
 *       recursion call isn’t the final thing performed by the function. After reverting, there’s
 *       another thing still there to assess
 *
 * Properties:
 *     - Performing the same operations multiple times with different inputs
 *     - In every step, we try smaller inputs to make the problem smaller
 *     - Base condition is needed to stop the recursion otherwise infinite loop will occur
 *
 * How are recursive functions stored in memory?:
 *     - Recursion uses more memory, because the recursive function adds to the stack with each
 *       recursive call, and keeps the values there until the call is finished. The recursive
 *       function uses LIFO (LAST IN FIRST OUT) Structure just like the stack data structure. A
 *       recursive function calls itself, the memory for a called function is allocated on top of
 *       memory allocated to the calling function and a different copy of local variables is created
 *       for each function call. When the base case is reached, the function returns its value to the
 *       function by whom it is called and memory is de-allocated and the process
 *
 * Summary of Recursion:
 *     - There are two types of cases in recursion i.e. recursive case and a base case
 *     - The base case is used to terminate the recursive function when the case turns out to be true
 *     - Each recursive call makes a new copy of that method in the stack memory
 *     - Infinite recursion may lead to running out of stack memory
 *     - Examples of Recursive algorithms: Merge Sort, Quick Sort, Tower of Hanoi, Fibonacci Series,
 *       Factorial Problem, etc
 *     - QuickSort is also tail recursive (Note that MergeSort is not tail recursive, this is also
 *       one of the reasons why QuickSort performs better)
 *
 * What are the advantages of recursive programming over iterative programming?:
 *     - Recursion provides a clean and simple way to write code. Some problems are inherently
 *       recursive like tree traversals, Tower of Hanoi, etc. For such problems, it is preferred to
 *       write recursive code. We can write such codes also iteratively with the help of a stack data
 *       structure. For example refer Inorder Tree Traversal without Recursion, Iterative Tower of
 *       Hanoi.
 *
 * What are the disadvantages of recursive programming over iterative programming?:
 *     - Note that both recursive and iterative programs have the same problem-solving powers, i.e.,
 *       every recursive program can be written iteratively and vice versa is also true. The recursive
 *       program has greater space requirements than the iterative program as all functions will
 *       remain in the stack until the base case is reached. It also has greater time requirements
 *       because of function calls and returns overhead.
 *     - Moreover, due to the smaller length of code, the codes are difficult to understand and hence
 *       extra care has to be practiced while writing the code. The computer may run out of memory if
 *       the recursive calls are not properly checked
 *
 */

import java.util.Stack;

public class Recursive {
}

class TowerOfHanoiRecursive {

    public static void main(String[] args) {
        int n = 3; // Number of disks
        char source = 'A', auxiliary = 'B', destination = 'C';

        System.out.println("Steps to solve Tower of Hanoi with " + n + " disks:");
        towerOfHanoi(n, source, auxiliary, destination);
    }

    static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move n-1 disks from source to auxiliary peg
        towerOfHanoi(n - 1, source, destination, auxiliary);

        // Move the nth disk from source to destination peg
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move the n-1 disks from auxiliary peg to destination peg
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
}

class TowerOfHanoiIterative {

    public static void main(String[] args) {
        int n = 3; // Number of disks
        char source = 'A', auxiliary = 'B', destination = 'C';

        System.out.println("Steps to solve Tower of Hanoi with " + n + " disks:");
        towerOfHanoiIterative(n, source, auxiliary, destination);
    }

    static void towerOfHanoiIterative(int n, char source, char auxiliary, char destination) {
        // Create three stacks to represent the three pegs
        Stack<Integer> sourceStack = new Stack<>();
        Stack<Integer> auxiliaryStack = new Stack<>();
        Stack<Integer> destinationStack = new Stack<>();

        // Initialize the source stack with disks
        for (int i = n; i > 0; i--) {
            sourceStack.push(i);
        }

        // Total number of moves required
        int totalMoves = (int) Math.pow(2, n) - 1;

        // Determine the direction of each move
        char[] moves = new char[totalMoves];
        for (int i = 0; i < totalMoves; i++) {
            if (i % 3 == 0) {
                moves[i] = 'A';
            } else if (i % 3 == 1) {
                moves[i] = 'B';
            } else {
                moves[i] = 'C';
            }
        }

        // Perform the moves
        for (int i = 0; i < totalMoves; i++) {
            char move = moves[i];
            switch (move) {
                case 'A':
                    moveDisk(sourceStack, destinationStack, source, destination);
                    break;
                case 'B':
                    moveDisk(sourceStack, auxiliaryStack, source, auxiliary);
                    break;
                case 'C':
                    moveDisk(auxiliaryStack, destinationStack, auxiliary, destination);
                    break;
            }
        }
    }

    static void moveDisk(Stack<Integer> source, Stack<Integer> destination, char sourcePeg, char destinationPeg) {
        if (!source.isEmpty() && (destination.isEmpty() || source.peek() < destination.peek())) {
            int disk = source.pop();
            destination.push(disk);
            System.out.println("Move disk " + disk + " from " + sourcePeg + " to " + destinationPeg);
        }
    }
}
