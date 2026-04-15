package wafflestudio.wapang;

import wafflestudio.wapang.domain.Grade;
import wafflestudio.wapang.domain.Member;
import wafflestudio.wapang.repository.MemberRepository;
import wafflestudio.wapang.repository.MemoryMemberRepository;
import wafflestudio.wapang.service.MemberService;
import wafflestudio.wapang.service.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberServiceImpl(memberRepository);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
