package lang.immutable.change;

public class ImmutableObject {

    private final int value;

    public ImmutableObject(final int value) {
        this.value = value;
    }

    public ImmutableObject add(int addValue) {
        return new ImmutableObject(value + addValue);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ImmutableObject{" +
                "value=" + value +
                '}';
    }
}
