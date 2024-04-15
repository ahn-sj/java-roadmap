package lang.string.equals;

public class StringEqualsMain1 {

    public static void main(String[] args) {

        final String str1 = new String("hello");
        final String str2 = new String("hello");
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1.equals(str2): " + str1.equals(str2));

        final String str3 = "hello";
        final String str4 = "hello";
        System.out.println("str3 == str4: " + (str3 == str4));
        System.out.println("str3.equals(str4): " + str3.equals(str4));
    }
}
