package wafflestudio.wapang.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import wafflestudio.wapang.domain.*;
import wafflestudio.wapang.repository.MemberRepository;
import wafflestudio.wapang.repository.MemoryMemberRepository;

public class FixedOrderServiceTest {
    DiscountPolicy discountPolicy = new FixDiscountPolicy();
    MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberServiceImpl(memberRepository);
    OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(9000);
    }
}
