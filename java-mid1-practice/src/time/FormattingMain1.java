package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingMain1 {

    public static void main(String[] args) {
        // date to string
        final LocalDate date = LocalDate.of(2024, 12, 31);
        System.out.println("before = " + date);

        final String format = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(date);
        System.out.println("after(formatted) = " + format);

        System.out.println("====================");

        // string to date
        final String text = "2024/12/31";
        System.out.println("before = " + text);

        final LocalDate parse = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("after(parsed) = " + parse);

    }
}
