package lang.wrapper;

public class WrapperNullPointExceptionExample2 {

    public static void main(String[] args) {

        final String str1 = "str";
        final String str2 = null;

        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str1));



    }
}
