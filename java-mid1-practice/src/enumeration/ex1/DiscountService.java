package enumeration.ex1;

public class DiscountService {

    public int discount(final String grade) {
        // grade에 따른 할인율 적용

        return 0;
    }

    public int discount(final Grade grade) {
        // grade에 따른 할인율 적용

        return 0;
    }

    private enum Grade {
        VIP, VVIP

    }
}
