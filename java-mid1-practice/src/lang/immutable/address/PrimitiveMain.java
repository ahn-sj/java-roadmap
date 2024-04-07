package lang.immutable.address;

public class PrimitiveMain {

    public static void main(String[] args) {

        int a = 10;
        int b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("===========");

        b = 20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
