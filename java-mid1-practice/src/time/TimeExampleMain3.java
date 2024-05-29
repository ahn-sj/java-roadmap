package time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeExampleMain3 {

    public static void main(String[] args) {

        final LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        final LocalDateTime with = now.with(ChronoField.YEAR, 2000);
        final LocalDateTime withYears = now.withYear(2000);

        System.out.println("with = " + with);
        System.out.println("withYears = " + withYears);
    }
}
