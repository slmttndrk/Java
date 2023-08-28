package javatutorials;

import java.util.*;
import java.text.*;

public class ParsingStringIntoDate {
    public static void main(String[] args) {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String input = "2023-08-25";

        System.out.print(input + " Parses as ");
        Date t;
        try {
            t = ft.parse(input);
            System.out.println(t);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }
    }
}
