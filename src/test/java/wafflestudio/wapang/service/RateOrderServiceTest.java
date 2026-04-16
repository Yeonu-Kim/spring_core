package wafflestudio.wapang.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wafflestudio.wapang.config.AppConfig;
import wafflestudio.wapang.domain.*;

@SpringBootTest
public class RateOrderServiceTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private OrderService orderService;

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 100000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(10000);
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(90000);
    }
}
