package lang.immutable.change;

public class MutableMain {
    public static void main(String[] args) {
        final MutableObject obj = new MutableObject(10);
        obj.add(20);
        System.out.println("obj.getValue() = " + obj.getValue());
    }
}
