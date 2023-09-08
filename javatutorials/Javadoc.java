package javatutorials;

public class Javadoc {
    /**
     * This is a javadoc!
     * @param num1 is first number to  sum
     * @param num2 is second number to sum
     * @return sum
     */
    public static int addNum (int num1, int num2){
        return num1 + num2;
    }

    public static void main(String[] args) {
        int sum = addNum(3,5);
        System.out.println("Sum = " + sum);
    }
}
