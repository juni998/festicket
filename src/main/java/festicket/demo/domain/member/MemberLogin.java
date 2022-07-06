package festicket.demo.domain.member;


import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class MemberLogin {

    @NotBlank(message = "아이디를 입력해주세요")
    private String account;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    public MemberLogin(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
