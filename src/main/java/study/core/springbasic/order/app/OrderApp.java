package study.core.springbasic.order.app;

import study.core.springbasic.config.AppConfig;
import study.core.springbasic.member.domain.Member;
import study.core.springbasic.member.service.MemberService;
import study.core.springbasic.order.domain.Order;
import study.core.springbasic.order.service.OrderService;
import study.core.springbasic.type.Grade;

public class OrderApp {

    public static MemberService memberService;
    public static OrderService orderService;

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        memberService = appConfig.memberService();
        memberService.saveMember(new Member(1L, "윤성호", Grade.VIP));
        Member member = memberService.getMember(1L);

        orderService = appConfig.orderService();
        orderService.save(new Order(1L, member.getId(), "라면", 10000L));
        Order order = orderService.getOrder(1L);

        System.out.println(order.toString());
    }

}
