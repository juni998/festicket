package festicket.demo.domain.member;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@Entity
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String account;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private String role;


    public Member(Long id, String account, String password, String name, String email, String phoneNumber, String role) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public Member(String account, String password, String name, String email, String phoneNumber, String role) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;

    }

    public void changePassword(String password) {
        this.password = password;
    }

}
