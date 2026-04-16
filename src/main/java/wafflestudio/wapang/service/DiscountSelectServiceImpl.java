package wafflestudio.wapang.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import wafflestudio.wapang.domain.DiscountPolicy;
import wafflestudio.wapang.domain.Member;

import java.util.List;
import java.util.Map;

@Component
public class DiscountSelectServiceImpl implements DiscountSelectService {
    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policies;

    public DiscountSelectServiceImpl(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
        this.policyMap = policyMap;
        this.policies = policies;
    }

    @Override
    public int discount(Member member, int price, String discountCode) {
        DiscountPolicy discountPolicy = policyMap.get(discountCode);
        if (discountPolicy == null) {
            throw new IllegalArgumentException("존재하지 않는 할인 정책입니다: " + discountCode);
        }
        return discountPolicy.discount(member, price);
    }
}