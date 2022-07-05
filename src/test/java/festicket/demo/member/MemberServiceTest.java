package festicket.demo.member;

import festicket.demo.domain.member.Member;
import festicket.demo.domain.member.MemberDto;
import festicket.demo.domain.member.MemberRole;
import festicket.demo.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void save() {
        MemberDto memberDto = new MemberDto("test", "1234", "이름", "wo@naver.com", "0101234567", "USER");

        memberService.save(memberDto);

        Member findMember = memberService.findMember(memberDto.getAccount());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        assertThat(findMember.getAccount()).isEqualTo(memberDto.getAccount());
        assertTrue(passwordEncoder.matches(memberDto.getPassword(), findMember.getPassword()));
        assertThat(findMember.getName()).isEqualTo(memberDto.getName());
        assertThat(findMember.getEmail()).isEqualTo(memberDto.getEmail());
    }


}