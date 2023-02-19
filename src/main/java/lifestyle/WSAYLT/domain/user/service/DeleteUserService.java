package lifestyle.WSAYLT.domain.user.service;

import lifestyle.WSAYLT.domain.auth.exception.MisMatchPasswordException;
import lifestyle.WSAYLT.domain.user.entity.User;
import lifestyle.WSAYLT.domain.user.presentation.dto.request.DeleteUserRequest;
import lifestyle.WSAYLT.domain.user.repository.UserRepository;
import lifestyle.WSAYLT.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteUserService {
    private final UserUtil userUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(DeleteUserRequest deleteUserRequest) {
        User user = userUtil.currentUser();
        if(!user.getPassword().equals(passwordEncoder.encode(deleteUserRequest.getPassword())))
            throw new MisMatchPasswordException("비밀번호가 일치하지 않습니다");

            userRepository.delete(user);
    }
}
