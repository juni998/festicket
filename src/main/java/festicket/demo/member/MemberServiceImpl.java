package festicket.demo.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberForm memberForm) {
        Member member = new Member();

        member.setAccount(memberForm.getAccount());
        member.setPassword(memberForm.getPassword());
        member.setName(memberForm.getName());
        member.setEmail(memberForm.getEmail());
        member.setPhoneNumber(memberForm.getPhoneNumber());

        memberRepository.save(member);

    }

    public Member findMember(String account) {
        return memberRepository.findByAccount(account);
    }


}

