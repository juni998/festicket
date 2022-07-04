package festicket.demo.service.impl;

import festicket.demo.domain.member.Member;
import festicket.demo.domain.member.MemberDto;
import festicket.demo.repository.MemberRepository;
import festicket.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberDto memberDto) {

        ModelMapper modelMapper = new ModelMapper();
        Member member = modelMapper.map(memberDto, Member.class);

        memberRepository.save(member);

    }

    public Member findMember(String account) {
        return memberRepository.findByAccount(account);
    }


}

