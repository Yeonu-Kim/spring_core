package wafflestudio.wapang.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wafflestudio.wapang.domain.Grade;
import wafflestudio.wapang.domain.Member;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DiscountSelectionTest {
    @Autowired
    DiscountSelectService discountSelectService;

    @Test
    void findAllBean(){
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountSelectService.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountSelectService).isInstanceOf(DiscountSelectService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountSelectService.discount(member,20000, "rateDiscountPolicy");
        assertThat(rateDiscountPrice).isEqualTo(2000);
    }
}
