package lang.immutable.address;

public class MemberMainV1 {
    public static void main(String[] args) {

        Address address = new Address("서울");

        MemberV1 memberA = new MemberV1("홍길동", address);
        MemberV1 memberB = new MemberV1("김길동", address);

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        final Address memberBAddress = memberB.getAddress();
        System.out.println("==============");
        memberBAddress.setValue("부산");
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }

}
