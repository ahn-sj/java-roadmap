package lang.immutable.address;

public class ImmutableAddress {

    private final String value;

    public ImmutableAddress(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "value='" + value + '\'' +
                '}';
    }
}
