package lang.immutable.address;

public class MemberMainV2 {
    public static void main(String[] args) {

        ImmutableAddress address = new ImmutableAddress("서울");

        MemberV2 memberA = new MemberV2("홍길동", address);
        MemberV2 memberB = new MemberV2("김길동", address);

        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        final ImmutableAddress memberBAddress = memberB.getAddress();
        System.out.println("==============");
        // memberBAddress.setValue("부산"); -> 컴파일 에러
        memberB.setAddress(new ImmutableAddress("부산"));
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }

}
