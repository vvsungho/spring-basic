package study.core.springbasic.member;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.springbasic.config.AppConfig;
import study.core.springbasic.member.domain.Member;
import study.core.springbasic.member.service.MemberService;
import study.core.springbasic.type.Grade;

public class MemberTest {

    private MemberService memberService;

    @BeforeEach
    public void settingMember() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    public void memberLogicTest() {
        // given
        memberService.saveMember(new Member(1L, "윤성호", Grade.BASIC));

        // when
        Member member = memberService.getMember(1L);

        // test
        Assertions.assertThat(member.getName()).isEqualTo("윤성호");
//        Assertions.assertThat(member.getName()).isEqualTo("윤성순");
    }

}
