package study.core.springbasic.order.service;

import study.core.springbasic.member.domain.Member;
import study.core.springbasic.member.repository.MemberRepository;
import study.core.springbasic.member.service.MemberService;
import study.core.springbasic.order.domain.Order;
import study.core.springbasic.order.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private DiscountService discountService;
    private MemberRepository memberRepository;

    public OrderServiceImpl(OrderRepository orderRepository, DiscountService discountService, MemberRepository memberRepository) {
        this.orderRepository = orderRepository;
        this.discountService = discountService;
        this.memberRepository = memberRepository;
    }

    @Override
    public void save(Order order) {
        Member member = memberRepository.getMember(order.getMemberId());
        Long discountPrice = discountService.getDiscountPrice(member, order.getPrice());
        orderRepository.save(new Order(order.getId(), order.getMemberId(), order.getProductName(), order.getPrice(), discountPrice));
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.getOrder(id);
    }
}
