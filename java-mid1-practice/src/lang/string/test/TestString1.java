package lang.string.test;

public class TestString1 {
    public static void main(String[] args) {
        final String url = "http://www.google.com";
        final boolean isUrl = url.startsWith("http://");
        System.out.println(isUrl);
    }
}
