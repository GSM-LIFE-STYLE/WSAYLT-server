package lifestyle.WSAYLT.domain.auth.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "닉네임은 공백을 허용하지 않습니다.")
    @Pattern(regexp="[a-zA-Z1-9]{5,12}", message = "비밀번호는 영어또는 숫자를 포함해 5~12자 이내로 입력해야 합니다.")
    private String nickname;

    @NotBlank(message = "비밀번호는 공백을 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 특수문자가 1개 이상 포함되어야 하고 글자 수는 8 ~ 16자 이내로 입력해야 합니다.")
    private String password;

    private String passwordConfirm;
}
