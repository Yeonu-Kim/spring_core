package wafflestudio.wapang.service;

import wafflestudio.wapang.domain.Member;

public interface DiscountSelectService {
    int discount(Member member, int price, String discountCode);
}