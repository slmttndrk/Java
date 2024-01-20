package datastructuresalgorithms.datastructures;

public class LinearSearch
{
    public static void main(String[] args) {
        int[] numbersToSearch = {3, 2, 5, 23, 8};
        int searchNumber = 23;

        int index = linearSearchAlgorithm(numbersToSearch, searchNumber);

        if (index != -1)
            System.out.println("Search number is present at index " + index);
        else
            System.out.println("Search number is not present!");
    }

    private static int linearSearchAlgorithm(int[] numbersToSearch, int searchNumber)
    {
        for (int i = 0; i < numbersToSearch.length; i ++)
            if (numbersToSearch[i] == searchNumber)
                return i;

        return -1;
    }
}
