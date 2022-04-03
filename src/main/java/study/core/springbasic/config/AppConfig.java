package study.core.springbasic.config;

import study.core.springbasic.member.repository.MemoryMemberRepository;
import study.core.springbasic.member.service.MemberService;
import study.core.springbasic.member.service.MemberServiceImpl;
import study.core.springbasic.order.repository.MemoryOrderRepository;
import study.core.springbasic.order.service.OrderService;
import study.core.springbasic.order.service.OrderServiceImpl;
import study.core.springbasic.order.service.PercentDiscountRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryOrderRepository(),
                new PercentDiscountRepository(),
                new MemoryMemberRepository()
        );
    }
}
