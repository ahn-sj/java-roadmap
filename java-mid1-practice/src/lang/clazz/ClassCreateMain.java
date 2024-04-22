package lang.clazz;

import java.lang.reflect.InvocationTargetException;

public class ClassCreateMain {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        final Class<Hello> helloClazz = Hello.class;
        final Hello hello = helloClazz.getDeclaredConstructor().newInstance();

        final String result = hello.hello();
        System.out.println("result = " + result);
    }

}

class Hello {

    public String hello() {
        return "Hello";
    }
}
