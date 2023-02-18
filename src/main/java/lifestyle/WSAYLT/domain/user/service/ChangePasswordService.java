package lifestyle.WSAYLT.domain.user.service;

import lifestyle.WSAYLT.domain.auth.exception.NotSamePasswordException;
import lifestyle.WSAYLT.domain.user.entity.User;
import lifestyle.WSAYLT.domain.user.presentation.dto.request.ChangePasswordRequest;
import lifestyle.WSAYLT.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {
    private final UserUtil userUtil;
    private final PasswordEncoder passwordEncoder;

    public void changePassword(ChangePasswordRequest request) {
        User user = userUtil.currentUser();
        checkPassword(user.getPassword(), request.getPassword());
        user.updatePassword(request.getPassword());
    }

    private void checkPassword(String currentPassword, String password) {
        if(currentPassword.equals(passwordEncoder.encode(password)))
            throw new NotSamePasswordException("비밀번호가 일치하지 않습니다");
    }
}
