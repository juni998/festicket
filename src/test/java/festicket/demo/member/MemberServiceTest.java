package festicket.demo.member;

import festicket.demo.domain.member.Member;
import festicket.demo.domain.member.MemberDto;
import festicket.demo.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void save() {
        MemberDto memberDto = new MemberDto("test", "1234", "이름", "wo@naver.com", "0101234567");

        memberService.save(memberDto);

        Member findMember = memberService.findMember(memberDto.getAccount());

        assertThat(findMember.getAccount()).isEqualTo(memberDto.getAccount());
        assertThat(findMember.getPassword()).isEqualTo(memberDto.getPassword());
        assertThat(findMember.getName()).isEqualTo(memberDto.getName());
        assertThat(findMember.getEmail()).isEqualTo(memberDto.getEmail());
    }


}