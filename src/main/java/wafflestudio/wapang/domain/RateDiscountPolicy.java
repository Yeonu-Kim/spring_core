package wafflestudio.wapang.domain;

public class RateDiscountPolicy implements DiscountPolicy {
    private int DISCOUNT_RATE = 10;

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? price * DISCOUNT_RATE / 100: 0;
    }
}
