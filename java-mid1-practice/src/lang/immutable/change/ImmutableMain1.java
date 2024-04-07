package lang.immutable.change;

public class ImmutableMain1 {
    public static void main(String[] args) {
        ImmutableObject obj = new ImmutableObject(10);
        final ImmutableObject changedObject = obj.add(20);
        
        System.out.println("obj.getValue() = " + obj.getValue());
        System.out.println("changedObject.getValue() = " + changedObject.getValue());
    }
}
