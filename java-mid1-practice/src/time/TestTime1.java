package time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TestTime1 {

    public static void main(String[] args) {

        final LocalDate startDate = LocalDate.of(2024, 5, 7);
        final LocalDate endDate = LocalDate.of(2024, 5, 30);

        final Period period = Period.between(startDate, endDate);
        final long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        System.out.println("시작 날짜: " + startDate + ", 목표 날짜: " + endDate);
        System.out.println("남은 기간: " + period.getYears() + "년 " + period.getMonths() + "개월 " + period.getDays() + "일 ");
        System.out.println("디데이: " + daysBetween + "일 남음");
    }
}
