package lang.object.equals;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsMainV1 {
    public static void main(String[] args) {

        Set<Object> set1 = new HashSet<>();
        set1.add(new BoxV1("A"));
        set1.add(new BoxV1("A"));
        System.out.println("set1 = " + set1);

        Set<Object> set2 = new HashSet<>();
        set2.add(new BoxV2("A"));
        set2.add(new BoxV2("A"));
        System.out.println("set2 = " + set2);

        Set<Object> set = new HashSet<>();
        set.add(new BoxV3("A"));
        set.add(new BoxV3("A"));
        System.out.println("set = " + set);
    }
}

class BoxV1 {
    private final String value;

    public BoxV1(final String value) {
        this.value = value;
    }
}

class BoxV2 {
    private final String value;

    public BoxV2(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BoxV2 boxV2 = (BoxV2) o;
        return Objects.equals(value, boxV2.value);
    }

}

class BoxV3 {
    private final String value;

    public BoxV3(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BoxV3 boxV3 = (BoxV3) o;
        return Objects.equals(value, boxV3.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
