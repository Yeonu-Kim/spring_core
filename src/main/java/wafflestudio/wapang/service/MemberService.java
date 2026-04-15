package wafflestudio.wapang.service;

import wafflestudio.wapang.domain.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
