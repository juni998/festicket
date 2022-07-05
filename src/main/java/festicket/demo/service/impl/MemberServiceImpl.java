package festicket.demo.service.impl;

import festicket.demo.domain.member.Member;
import festicket.demo.domain.member.MemberDto;
import festicket.demo.repository.MemberRepository;
import festicket.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberDto memberDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Member member = new Member();

        member.setAccount(memberDto.getAccount());
        member.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());
        member.setPhoneNumber(memberDto.getPhoneNumber());
        member.setRole(memberDto.getRole());

        memberRepository.save(member);

    }

    public Member findMember(String account) {
        return memberRepository.findByAccount(account);
    }


}

