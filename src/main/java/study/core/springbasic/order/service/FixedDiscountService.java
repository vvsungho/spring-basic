package study.core.springbasic.order.service;

import study.core.springbasic.member.domain.Member;
import study.core.springbasic.type.Grade;

public class FixedDiscountService implements DiscountService {

    private Long fixedPrice = 1000L;

    @Override
    public Long getDiscountPrice(Member member, Long price) {
        if (member.getGrade() == Grade.BASIC) return fixedPrice;
        return 0L;
    }
}
