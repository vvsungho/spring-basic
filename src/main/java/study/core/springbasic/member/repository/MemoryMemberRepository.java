package study.core.springbasic.member.repository;

import study.core.springbasic.member.domain.Member;

import java.util.HashMap;

public class MemoryMemberRepository implements MemberRepository{

    private static HashMap<Long, Member> savedMember = new HashMap<>();

    @Override
    public void save(Member member) {
        savedMember.put(member.getId(), member);
    }

    @Override
    public Member getMember(Long id) {
        return savedMember.get(id);
    }

}
