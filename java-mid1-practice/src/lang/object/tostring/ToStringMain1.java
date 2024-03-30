package lang.object.tostring;

public class ToStringMain1 {

    public static void main(String[] args) {
        final Object obj = new Object();

        final String name = obj.getClass().getName();
        final int hashCode = obj.hashCode();
        final String hex = Integer.toHexString(hashCode);

        System.out.println("name = " + name);
        System.out.println("hashCode = " + hashCode);
        System.out.println("hex = " + hex);

        System.out.println("===== toString =====");
        System.out.println(name + "@" + hex);
        System.out.println(obj.toString());
    }
}
