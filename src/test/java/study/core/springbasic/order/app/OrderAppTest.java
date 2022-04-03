package study.core.springbasic.order.app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.springbasic.config.AppConfig;
import study.core.springbasic.member.domain.Member;
import study.core.springbasic.member.service.MemberService;
import study.core.springbasic.order.domain.Order;
import study.core.springbasic.order.service.OrderService;
import study.core.springbasic.type.Grade;

class OrderAppTest {

    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    void setService() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        memberService.saveMember(new Member(1L, "윤성호", Grade.VIP));
        Member member = memberService.getMember(1L);

        orderService.save(new Order(1L, member.getId(), "상품", 20000L));
        Order order = orderService.getOrder(1L);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000L);

    }


}
