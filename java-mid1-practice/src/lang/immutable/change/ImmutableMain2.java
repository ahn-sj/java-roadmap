package lang.immutable.change;

public class ImmutableMain2 {
    public static void main(String[] args) {
        ImmutableObject obj = new ImmutableObject(10);
        obj.add(20);
        System.out.println("obj.getValue() = " + obj.getValue());
    }
}
