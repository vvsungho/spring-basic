package study.core.springbasic.member.service;

import study.core.springbasic.member.domain.Member;

public interface MemberService {
    void saveMember(Member member);
    Member getMember(Long id);
}
