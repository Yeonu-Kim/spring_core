package wafflestudio.wapang.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    void vip_discount() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    void vip_normal() {
        Member member = new Member(1L, "memberVIP", Grade.BASIC);
        int discount = discountPolicy.discount(member, 100000);

        assertThat(discount).isEqualTo(0);
    }
}
