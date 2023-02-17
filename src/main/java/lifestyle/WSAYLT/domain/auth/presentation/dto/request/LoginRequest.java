package lifestyle.WSAYLT.domain.auth.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "닉네임은 공백을 허용하지 않습니다.")
    private String nickname;

    @NotBlank(message = "비밀번호는 공백을 허용하지 않습니다.")
    private String password;
}
