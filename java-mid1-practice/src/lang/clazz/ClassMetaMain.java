package lang.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMetaMain {

    public static void main(String[] args) throws ClassNotFoundException {
        final Class<String> clazz1 = String.class;
        final Class<? extends String> clazz2 = new String().getClass();
        final Class<?> clazz3 = Class.forName("java.lang.String");

        System.out.println("clazz1 = " + clazz1);
        System.out.println("clazz2 = " + clazz2);
        System.out.println("clazz3 = " + clazz3);

        System.out.println("====================================");

        System.out.println("#### 모든 필드 출력 ####");
        final Field[] fields = clazz1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getType() + " " + field.getName());
        }

        System.out.println("#### 모든 메서드 출력 ####");
        final Method[] methods = clazz1.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.getReturnType() + " " + method.getName());
        }

        System.out.println("#### 상위 클래스 정보 출력 ####");
        final String superClazz = clazz1.getSuperclass().getName();
        System.out.println("superClazz = " + superClazz);

        System.out.println("#### 인터페이스 정보 출력 ####");
        final Class<?>[] interfaces = clazz1.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("anInterface = " + anInterface.getName());
        }

    }
}
