package study.core.springbasic.member.service;

import study.core.springbasic.member.domain.Member;
import study.core.springbasic.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member getMember(Long id) {
        return memberRepository.getMember(id);
    }
}
