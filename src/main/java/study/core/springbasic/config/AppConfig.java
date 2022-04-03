package study.core.springbasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.core.springbasic.member.repository.MemoryMemberRepository;
import study.core.springbasic.member.service.MemberService;
import study.core.springbasic.member.service.MemberServiceImpl;
import study.core.springbasic.order.repository.MemoryOrderRepository;
import study.core.springbasic.order.service.*;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(this.getMemberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryOrderRepository(),
                this.getDiscountService(),
                this.getMemberRepository()
        );
    }

    @Bean
    public DiscountService getDiscountService() {
//        return new PercentDiscountRepository();
        return new FixedDiscountRepository();

    }

    @Bean
    public MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }
}
