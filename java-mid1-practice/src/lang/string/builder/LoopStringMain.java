package lang.string.builder;

public class LoopStringMain {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 100_000; i++) {
            result += "hello";
        }
        final long endTime = System.currentTimeMillis();

        System.out.println("execute time = " + (endTime - startTime) + "ms");

    }
}
