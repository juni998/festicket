package festicket.demo.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

    private Long id;

    private String account;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;
}
