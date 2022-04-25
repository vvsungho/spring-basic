package study.core.springbasic.order.service;

import study.core.springbasic.member.domain.Member;
import study.core.springbasic.type.Grade;

public class PercentDiscountService implements DiscountService {

    private Long percent = 10L;

    @Override
    public Long getDiscountPrice(Member member, Long price) {
        System.out.println(member.toString());
        if (member.getGrade() == Grade.VIP) return price * percent / 100L;
        return 0L;
    }
}
