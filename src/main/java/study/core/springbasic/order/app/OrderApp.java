package study.core.springbasic.order.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.springbasic.config.AppConfig;
import study.core.springbasic.member.domain.Member;
import study.core.springbasic.member.service.MemberService;
import study.core.springbasic.order.domain.Order;
import study.core.springbasic.order.service.OrderService;
import study.core.springbasic.type.Grade;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        memberService.saveMember(new Member(1L, "윤성호", Grade.VIP));
        Member member = memberService.getMember(1L);

//        OrderService orderService = appConfig.orderService();
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.save(new Order(1L, member.getId(), "라면", 10000L));
        Order order = orderService.getOrder(1L);

        System.out.println(order.toString());
    }

}
