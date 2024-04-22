package lang.wrapper;

public class WrapperExample1 {
    public static void main(String[] args) {

        final boolean isSameNewIntWrapper = isSameNewIntWrapper();
        final boolean isSameLiteralIntWrapper = isSameLiteralIntWrapper();

        System.out.println("isSameNewIntWrapper = " + isSameNewIntWrapper);
        System.out.println("isSameLiteralIntWrapper = " + isSameLiteralIntWrapper);
    }

    private static boolean isSameLiteralIntWrapper() {
        final Integer int1 = 10;
        final Integer int2 = 10;

        return int1 == int2;
    }

    private static boolean isSameNewIntWrapper() {
        final Integer int1 = new Integer(10);
        final Integer int2 = new Integer(10);

        return int1 == int2;
    }
}
