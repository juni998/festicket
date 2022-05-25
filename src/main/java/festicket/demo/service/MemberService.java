package festicket.demo.service;

import festicket.demo.domain.Member;
import festicket.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /* 회원가입 */
    @Transactional
    public Long save(Member member) {

        validateDuplicateAccount(member);
        memberRepository.save(member);
        return member.getId();

    }

    /* 회원조회 */
    private Member findMember(Member member) {

        memberRepository.findOne(member.getId());
        return member;
    }
    /* 아이디 중복검사 */
    private void validateDuplicateAccount(Member member) {
        List<Member> findMembers = memberRepository.findByAccount(member.getAccount());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }




}
