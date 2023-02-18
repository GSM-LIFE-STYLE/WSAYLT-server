package lifestyle.WSAYLT.domain.user.presentation.dto.request;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChangePasswordRequest {
    private final String password;
    private final String newPassword;
}
