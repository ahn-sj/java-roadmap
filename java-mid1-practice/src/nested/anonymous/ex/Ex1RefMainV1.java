package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV1 {

    public static void helloDice() {
        System.out.println("프로그램 시작");

        final int random = new Random().nextInt(6) + 1;
        System.out.println("주사위 = " + random);

        System.out.println("프로그램 종료");
    }

    public static void helloPrint() {
        System.out.println("프로그램 시작");

        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        helloDice();
        helloPrint();
    }

}
