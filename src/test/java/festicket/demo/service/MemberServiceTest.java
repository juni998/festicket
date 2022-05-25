package festicket.demo.service;

import festicket.demo.domain.Member;
import festicket.demo.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired EntityManager em;

    @Autowired MemberRepository memberRepository;

    @Autowired MemberService memberService;
    
   @Test
   public void 회원가입() throws Exception {

       Member member = new Member();
       member.setAccount("test");
       member.setPassword("1234");
       member.setName("영준");
       member.setEmail("abc@naver.com");
       member.setPhoneNumber("01012345678");

       Long saveId = memberService.save(member);

       em.flush();
       assertEquals(member, memberRepository.findOne(saveId));

   }

    @Test
    public void 아이디_중복검사() throws Exception {
        Member member1 = new Member();
        member1.setAccount("test1");

        Member member2 = new Member();
        member2.setAccount("test1");

        memberService.save(member1);
        try {
            memberService.save(member2);
        } catch (IllegalStateException e) {
            return;
        }

        fail("예외가 발생해야 한다");

    }







}