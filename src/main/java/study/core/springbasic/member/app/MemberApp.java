package study.core.springbasic.member.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.core.springbasic.config.AppConfig;
import study.core.springbasic.member.domain.Member;
import study.core.springbasic.member.service.MemberService;
import study.core.springbasic.type.Grade;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        memberService.saveMember(new Member(1L, "윤성호", Grade.BASIC));
        Member member = memberService.getMember(1L);
        System.out.println(member.toString());
    }

}
