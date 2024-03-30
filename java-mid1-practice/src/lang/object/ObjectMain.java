package lang.object;

public class ObjectMain {

    public static void main(String[] args) {
        System.out.println("### Before new Instance ###");
        final Child child = new Child();
        System.out.println("### After new Instance ###");
        child.childMethod();
        child.parentMethod();

        final String string = child.toString(); // 객체에 대한 정보
        System.out.println("string = " + string);
    }
}
