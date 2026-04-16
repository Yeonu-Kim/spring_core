package wafflestudio.wapang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wafflestudio.wapang.domain.DiscountPolicy;
import wafflestudio.wapang.domain.Member;
import wafflestudio.wapang.domain.Order;
import wafflestudio.wapang.repository.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long id, String itemName, int itemPrice) {
        Member member = this.memberRepository.fingbyId(id);
        int discountPrice = this.discountPolicy.discount(member, itemPrice);
        return new Order(id, itemName, itemPrice, discountPrice);
    }
}
