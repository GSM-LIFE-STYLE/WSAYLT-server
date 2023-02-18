package lifestyle.WSAYLT.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ChangePasswordRequest {
    private final String password;
    private final String newPassword;
}
