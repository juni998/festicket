package festicket.demo.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberForm {

    @NotEmpty(message = "아이디는 필수 입니다")
    private String account;

    @NotEmpty(message = "비밀번호는 필수 입니다")
    private String password;


    private String name;


    private String email;


    private String phoneNumber;

    public MemberForm(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public MemberForm(String account, String password, String name, String email, String phoneNumber) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
