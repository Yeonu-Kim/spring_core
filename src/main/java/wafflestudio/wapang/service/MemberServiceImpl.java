package wafflestudio.wapang.service;

import wafflestudio.wapang.domain.Member;
import wafflestudio.wapang.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        this.memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return this.memberRepository.fingbyId(memberId);
    }
}
