package wafflestudio.wapang;

import wafflestudio.wapang.domain.DiscountPolicy;
import wafflestudio.wapang.domain.RateDiscountPolicy;
import wafflestudio.wapang.repository.MemberRepository;
import wafflestudio.wapang.repository.MemoryMemberRepository;
import wafflestudio.wapang.service.MemberService;
import wafflestudio.wapang.service.MemberServiceImpl;
import wafflestudio.wapang.service.OrderService;
import wafflestudio.wapang.service.OrderServiceImpl;

public class AppConfig {
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
