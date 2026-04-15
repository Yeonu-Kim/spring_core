package wafflestudio.wapang.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wafflestudio.wapang.domain.Grade;
import wafflestudio.wapang.domain.Member;
import wafflestudio.wapang.repository.MemberRepository;
import wafflestudio.wapang.repository.MemoryMemberRepository;

public class MemberServiceTest {
    MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberServiceImpl(memberRepository);

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertEquals(member.getName(), findMember.getName());
        Assertions.assertEquals(member.getGrade(), findMember.getGrade());
    }
}
