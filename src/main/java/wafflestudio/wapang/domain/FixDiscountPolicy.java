package wafflestudio.wapang.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{
    final private int VIP_DISCOUNT_AMOUNT = 1000;
    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? VIP_DISCOUNT_AMOUNT: 0;
    }
}
