package festicket.demo.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    public void testMember() {
        Member member = new Member("test", "1234", "테스트", "test@test.com", "1234");
        Member savedMember = memberRepository.save(member);

        Optional<Member> findMember = memberRepository.findById(savedMember.getId());

        assertThat(findMember.get().getId()).isEqualTo(member.getId());
        assertThat(findMember.get().getName()).isEqualTo(member.getName());
        assertThat(findMember.get()).isEqualTo(member);
    }

    @Test
    public void basicCRUD() {

        //단건 조획 검증

        //리스트 조회 검증

        //카운트 검증

        //삭제 검증
    }
}