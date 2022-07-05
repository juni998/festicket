package festicket.demo.service.impl;

import festicket.demo.domain.member.Member;
import festicket.demo.domain.member.MemberDto;
import festicket.demo.repository.MemberRepository;
import festicket.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void save(MemberDto memberDto) {
        Member member = Member.builder()
                .account(memberDto.getAccount())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .phoneNumber(memberDto.getPhoneNumber())
                .role(memberDto.getRole())
                .build();

        memberRepository.save(member);

    }

    public Member findMember(String account) {

        return memberRepository.findByAccount(account);
    }


}

