package festicket.demo.service;

import festicket.demo.domain.member.Member;
import festicket.demo.domain.member.MemberDto;

public interface MemberService {

    void save(MemberDto memberDto);

    Member findMember(String account);

    void changePasswordByAccount(String account, String newPassword);



}
