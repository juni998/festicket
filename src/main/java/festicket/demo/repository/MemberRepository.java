package festicket.demo.repository;

import festicket.demo.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {


    Member findByAccount(@Param("account") String account);

    List<Member> findListByAccount(@Param("account") String account);

}
