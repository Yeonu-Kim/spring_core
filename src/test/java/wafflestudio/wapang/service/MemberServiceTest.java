package wafflestudio.wapang.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wafflestudio.wapang.domain.Grade;
import wafflestudio.wapang.domain.Member;
import wafflestudio.wapang.domain.Order;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("VIP는 10% 할인이 적용된다")
    void vipDiscountTest() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    @DisplayName("일반 회원은 할인이 적용되지 않는다")
    void basicDiscountTest() {
        Member member = new Member(2L, "memberBasic", Grade.BASIC);
        memberService.join(member);

        Order order = orderService.createOrder(2L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(0);
    }
}
