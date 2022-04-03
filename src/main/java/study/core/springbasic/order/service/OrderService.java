package study.core.springbasic.order.service;

import study.core.springbasic.order.domain.Order;

public interface OrderService {
    void save(Order order);
    Order getOrder(Long id);
}
