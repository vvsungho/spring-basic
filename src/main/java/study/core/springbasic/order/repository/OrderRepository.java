package study.core.springbasic.order.repository;

import study.core.springbasic.order.domain.Order;

public interface OrderRepository {
    void save(Order order);
    Order getOrder(Long id);
}
