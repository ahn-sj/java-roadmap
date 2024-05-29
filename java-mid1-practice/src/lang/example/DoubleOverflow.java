package lang.example;

public class DoubleOverflow {

    public static void main(String[] args) {
        double d = 1e308;  // 10의 308승, double의 최대값에 근접
        System.out.println("d: " + d);

        // d에 큰 수를 곱함
        d *= 100;  // 이 시점에서 오버플로우 발생
        System.out.println("d after overflow: " + d);

        System.out.println("=====");

        double f = 1e-308;  // 10의 -308승, double의 최소값에 근접
        System.out.println("d: " + f);

        // d를 매우 작은 수로 나눔
        f /= 1e308;  // 이 시점에서 언더플로우 발생
        System.out.println("d after underflow: " + f);
    }
}
