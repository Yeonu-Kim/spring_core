package wafflestudio.wapang;

import wafflestudio.wapang.domain.*;
import wafflestudio.wapang.repository.MemberRepository;
import wafflestudio.wapang.repository.MemoryMemberRepository;
import wafflestudio.wapang.service.MemberService;
import wafflestudio.wapang.service.MemberServiceImpl;
import wafflestudio.wapang.service.OrderService;
import wafflestudio.wapang.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        DiscountPolicy discountPolicy = new FixDiscountPolicy();
        MemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberServiceImpl(memberRepository);
        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.getTotalPrice = " + order.getTotalPrice());
    }
}
