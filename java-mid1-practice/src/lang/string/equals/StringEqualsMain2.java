package lang.string.equals;

public class StringEqualsMain2 {

    public static void main(String[] args) {
        final String str1 = new String("hello");
        final String str2 = new String("hello");

        final boolean isSame = isSame(str1, str2);
        System.out.println("isSame = " + isSame);
    }

    private static boolean isSame(final String str1, final String str2) {
        return str1 == str2;
    }
}
