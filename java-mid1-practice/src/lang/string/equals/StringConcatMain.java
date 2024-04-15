package lang.string.equals;

public class StringConcatMain {
    public static void main(String[] args) {

        final String str1 = "hello";
        final String str2 = " world";
        final String result1 = str1.concat(str2);
        final String result2 = str1 + str2;
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
