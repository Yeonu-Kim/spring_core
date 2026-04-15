package wafflestudio.wapang.domain;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
