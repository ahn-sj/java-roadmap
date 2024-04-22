package lang.wrapper;

import java.util.Map;

public class WrapperNullPointExceptionExample1 {

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("key", 10);

        Integer integer1 = map.get("key");
        System.out.println("integer1 = " + integer1);

        int i1 = map.get("keyy");
        System.out.println("i1 = " + i1);


    }
}
