package lang.wrapper;

public class WrapperVsPrimitive {

    public static void main(String[] args) {

        final int loop = 1_000_000_000;

        // primitive type
        long sumPrimitive = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            sumPrimitive += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sumPrimitive = " + sumPrimitive + ", time = " + (end - start) + " ms");

        // wrapper type
        Long sumWrapper = 0L;
        start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            sumWrapper += i;
        }
        end = System.currentTimeMillis();
        System.out.println("sumWrapper = " + sumWrapper + ", time = " + (end - start) + " ms");
    }
}
