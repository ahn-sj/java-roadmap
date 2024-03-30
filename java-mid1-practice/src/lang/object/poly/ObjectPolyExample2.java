package lang.object.poly;

public class ObjectPolyExample2 {

    public static void main(String[] args) {
        final Dog dog = new Dog();
        final Car car = new Car();
        final Object obj = new Object();

        Object[] objects = {dog, car, obj};

        size(objects);
    }

    private static void size(final Object[] objects) {
        System.out.println("objects.length = " + objects.length);
    }
}
