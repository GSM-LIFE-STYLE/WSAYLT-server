package lifestyle.WSAYLT.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@RequiredArgsConstructor
public class ChangePasswordRequest {
    @NotBlank(message = "기존 비밀번호를 입력해야 합니다")
    private String password;
    @NotBlank(message = "수정할 비밀번호를 입력해야 합니다")
    @Pattern(regexp = "(?=.*\\W)(?=\\S+$).{8,16}", message = "변경한 비밀번호는 특수문자가 1개 이상 포함되어야 하고 글자 수는 8 ~ 16자 이내로 입력해야 합니다.")
    private String newPassword;
}
