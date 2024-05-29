package time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeExampleMain2 {

    public static void main(String[] args) {

        final LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        final LocalDateTime plus = now.plus(5, ChronoUnit.YEARS);
        final LocalDateTime plusYears = now.plusYears(5);

        System.out.println("plus = " + plus);
        System.out.println("plusYears = " + plusYears);
    }
}
