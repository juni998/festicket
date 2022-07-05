package festicket.demo.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
@RequiredArgsConstructor
public class MemberDto {

    @NotBlank(message = "아이디를 입력해주세요")
    //@Size(min = 4, max = 16, message = "아이디는 4자 이상 16자 이하로 입력해주세요")
    private String account;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;



    private String name;

    @Email(message = "올바른 이메일 주소를 입력해주세요")
    private String email;

    private String phoneNumber;

    private String role;


    public MemberDto(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public MemberDto(String account, String password, String name, String email, String phoneNumber, String role) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
