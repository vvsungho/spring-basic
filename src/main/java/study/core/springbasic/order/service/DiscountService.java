package study.core.springbasic.order.service;

import study.core.springbasic.member.domain.Member;

public interface DiscountService {
    Long getDiscountPrice(Member member, Long price);
}
