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

    @NotEmpty(message = "이름은 필수 입니다")
    private String name;

    @NotEmpty(message = "이메일은 필수 입니다")
    private String email;

    @NotEmpty(message = "전화번호는 필수 입니다")
    private String phoneNumber;


    public MemberForm(String account, String password, String name, String email, String phoneNumber) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
