package wafflestudio.wapang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wafflestudio.wapang.domain.DiscountPolicy;
import wafflestudio.wapang.domain.RateDiscountPolicy;
import wafflestudio.wapang.repository.MemberRepository;
import wafflestudio.wapang.repository.MemoryMemberRepository;
import wafflestudio.wapang.service.MemberService;
import wafflestudio.wapang.service.MemberServiceImpl;
import wafflestudio.wapang.service.OrderService;
import wafflestudio.wapang.service.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
