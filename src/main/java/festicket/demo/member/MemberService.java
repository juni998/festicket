package festicket.demo.member;

public interface MemberService {

    void save(MemberForm memberForm);

    Member findMember(String account);


}
