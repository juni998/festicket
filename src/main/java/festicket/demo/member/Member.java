package festicket.demo.member;

import festicket.demo.time.TimeEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String account;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    public Member(String account, String password, String name, String email, String phoneNumber) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
