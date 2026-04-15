package wafflestudio.wapang.service;

import wafflestudio.wapang.domain.Order;

public interface OrderService {
    Order createOrder(Long id, String itemName, int itemPrice);
}
