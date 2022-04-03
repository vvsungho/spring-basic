package study.core.springbasic.member.repository;

import study.core.springbasic.member.domain.Member;

public interface MemberRepository {
    void save(Member member);
    Member getMember(Long id);
}
