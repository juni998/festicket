package festicket.demo.member;

import festicket.demo.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByAccount(@Param("account") String account);

}
