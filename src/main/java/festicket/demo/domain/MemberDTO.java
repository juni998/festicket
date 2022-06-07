package festicket.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
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
