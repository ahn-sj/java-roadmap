package nested.anonymous.ex;

import java.util.Random;
import java.util.stream.IntStream;

public class Ex4RefMainV4 {

    public static void hello(Process process) {
        System.out.println("프로그램 시작");
        process.run();
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        hello(() -> System.out.println("주사위 = " + (new Random().nextInt(6) + 1)));
        hello(() -> IntStream.range(0, 3).mapToObj(i -> "i = " + i).forEach(System.out::println));
    }

}
