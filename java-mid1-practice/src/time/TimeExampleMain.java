package time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class TimeExampleMain {

    public static void main(String[] args) {

        final LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        final int getYear = now.getYear();
        final int get = now.get(ChronoField.YEAR);

        System.out.println("getYear = " + getYear);
        System.out.println("get = " + get);
    }
}
