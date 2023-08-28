package javatutorials;

public class FormatStrings {
    public static void main(String[] args) {
        float f = 1.5F;
        int i = 15;
        String s = "Fifteen";

        System.out.printf("The value of the float variable is " +
                            "%f, while the value of the integer " +
                            "variable is %d, and the string " +
                            "is %s", f, i, s);

        String formattedString = String.format("The value of the float variable is " +
                                                "%f, while the value of the integer " +
                                                "variable is %d, and the string " +
                                                "is %s", f, i, s);
        System.out.println("\n" + formattedString);
    }

}
