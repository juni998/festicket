package festicket.demo.repository;

import festicket.demo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    /* 회원 가입 */
    public void save(Member member) {
        em.persist(member);
    }

    /* 회원 조회 */
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findByAccount(String account) {
        return em.createQuery("select m from Member m where m.account = :account", Member.class)
                .setParameter("account", account)
                .getResultList();
    }



}
