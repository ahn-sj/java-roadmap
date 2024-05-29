package time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TestTime2 {

    public static void main(String[] args) {
        
        final int givenYear = 2024;
        final int givenMonth = 5;

        final LocalDate target = LocalDate.of(givenYear, givenMonth, 1);
        final DayOfWeek firstDayOfWeek = target.getDayOfWeek();
        final DayOfWeek lastDayOfWeek = target.plusMonths(1).minusDays(1).getDayOfWeek();

        System.out.println("firstDayOfWeek = " + firstDayOfWeek);
        System.out.println("lastDayOfWeek = " + lastDayOfWeek);

    }
}
