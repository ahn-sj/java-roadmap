package lang.immutable.address;

public class MemberV2 {

    private String name;
    private ImmutableAddress address;

    public MemberV2(final String name, final ImmutableAddress address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public ImmutableAddress getAddress() {
        return address;
    }

    public void setAddress(final ImmutableAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MemberV2{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
