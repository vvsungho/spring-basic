package study.core.springbasic.order.repository;

import study.core.springbasic.order.domain.Order;

import java.util.HashMap;

public class MemoryOrderRepository implements OrderRepository {

    private static HashMap<Long, Order> savedOrder = new HashMap<>();

    @Override
    public void save(Order order) {
        savedOrder.put(order.getId(), order);
    }

    @Override
    public Order getOrder(Long id) {
        return savedOrder.get(id);
    }
}
