package wafflestudio.wapang.repository;

import wafflestudio.wapang.domain.Member;

public interface MemberRepository {
    void save(Member member);
    Member fingbyId(Long memberId);
}
