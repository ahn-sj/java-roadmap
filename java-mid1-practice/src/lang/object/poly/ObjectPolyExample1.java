package lang.object.poly;

import java.lang.reflect.InvocationTargetException;

public class ObjectPolyExample1 {

    public static void main(String[] args) {
        final Dog dog = new Dog();
        final Car car = new Car();

        action(dog);
        action(car);

        actionV2(dog);
        actionV2(car);
    }

    private static void action(final Object obj) {

        // obj.sound(); -> Object는 해당 메서드가 없음
        // obj.move();  -> Object는 해당 메서드가 없음

        if (obj instanceof Dog) {
            final Dog dog = (Dog) obj;
            dog.sound();
        } else if (obj instanceof Car car) {
            car.move();
        }
    }

    private static void actionV2(final Object obj) {

        final Class<?> clazz = obj.getClass();

        try {
            if(clazz == Dog.class) {
                clazz.getMethod("sound").invoke(obj);
            } else if (clazz == Car.class) {
                clazz.getMethod("move").invoke(obj);
            }
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
