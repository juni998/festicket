package festicket.demo.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;
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
        Member member1 = new Member("test", "1234", "테스트", "test@test.com", "1234");
        Member member2 = new Member("test2", "1234", "테스트2", "test2@test.com", "1234");
        Member member3 = new Member("test3", "1234", "테스트3", "test3@test.com", "1234");
        Member member4 = new Member("test4", "1234", "테스트4", "test4@test.com", "1234");

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        //단건 조회 검증
        Member findAccount = memberRepository.findByAccount(member2.getAccount());
        assertThat(findAccount).isEqualTo(member2);

        //리스트 조회 검증
        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(4);

        //카운트 검증
        long count = memberRepository.count();
        assertThat(count).isEqualTo(4);

        //삭제 검증
        memberRepository.delete(member3);
        long deleteCount = memberRepository.count();
        assertThat(deleteCount).isEqualTo(3);
    }
}