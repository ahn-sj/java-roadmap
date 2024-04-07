package lang.immutable.change;

public class MutableObject {

    private int value;

    public MutableObject(final int value) {
        this.value = value;
    }

    public void add(int addValue) {
        value = value + addValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }
}
