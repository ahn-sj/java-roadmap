package lang.string.builder;

public class LoopStringBuilderMain {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            sb.append("hello");
        }
        final long endTime = System.currentTimeMillis();

        System.out.println("execute time = " + (endTime - startTime) + "ms");

    }
}
