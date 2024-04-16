package lang.string.builder;

public class StringBuilderMain1_1 {

    public static void main(String[] args) {
        final StringBuilder builder = new StringBuilder();
        builder.append("hello");
        builder.append(" world");
        System.out.println("builder = " + builder);

        builder.insert(11, " !!");
        System.out.println("insert = " + builder);

        builder.delete(0, 6);
        System.out.println("delete = " + builder);

        builder.reverse();
        System.out.println("reverse = " + builder);

        final String string = builder.toString();
        System.out.println("builder.toString() = " + string);
    }
}
