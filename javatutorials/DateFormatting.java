package javatutorials;

import java.util.*;
import java.text.*;

public class DateFormatting {
    public static void main(String[] args) {
        Date dNow = new Date( );
        SimpleDateFormat ft =
                new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println("Current Date: " + ft.format(dNow));


        // Instantiate a Date object
        Date date = new Date();

        // display time and date
        String str = String.format("Current Date/Time : %tc", date );

        System.out.printf(str);

        System.out.println();
        // display time and date
        System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);

        System.out.println();

        // display formatted date
        System.out.printf("%s %tB %<te, %<tY", "Due date:", date);
    }
}
