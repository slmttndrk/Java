package datastructuresalgorithms.datastructures;

/***
 * Properties:
 *     - It is a derived data type, compose of a collection of various primitive data types
 *     - Elements of an array are stored in contiguous blocks in prime memory
 *     - The name of the array stored the base address of the array. It acts as a pointer to the memory block where the first element has been stored
 *
 * Operations:
 *     - Insertion
 *     - Deletion
 *     - Updating
 *     - Searching
 *     - Sorting
 *
 * Applications:
 *     - Longest consecutive subsequence
 *
 * Algorithms:
 *     - Kadn`s
 *     - Flody cycle detection
 *     - KMPC
 *     - Quick select
 *     - Boyer-more majority vote
 *
 * Advantages:
 *     - Arrays store multiple elements of the same type with the same name
 *     - You can randomly access elements in the array using an index number
 *     - Array memory is predefined, so there is no extra memory loss
 *     - Arrays avoid memory overflow
 *     - 2D arrays an efficiently represent the tabular data
 *
 * Disadvantages:
 *     - The number of elements in the array should be predefined
 *     - An array is static it can not alter its size after declaration
 *     - Insertion and deletion operations in the array is quite tricky as the array stores elements in continuous form
 *     - Allocating excess memory than required may lead to memory wastage
 *
 */
public class Array
{
    public static void main(String[] args) {
        int[][] twoDimArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < twoDimArray.length ; i++)
            for (int j = 0; j < twoDimArray[i].length ; j++)
                System.out.print(twoDimArray[i][j] + " ");
    }
}
