package festicket.demo.member;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        MemberForm memberForm = new MemberForm("test", "1234", "이름", "wo@naver.com", "0101234567");

        memberService.save(memberForm);

        Member findMember = memberService.findMember(memberForm.getAccount());

        assertThat(findMember.getAccount()).isEqualTo(memberForm.getAccount());
        assertThat(findMember.getPassword()).isEqualTo(memberForm.getPassword());
        assertThat(findMember.getName()).isEqualTo(memberForm.getName());
        assertThat(findMember.getEmail()).isEqualTo(memberForm.getEmail());
    }


}