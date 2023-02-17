package lifestyle.WSAYLT.domain.auth.service;

import lifestyle.WSAYLT.domain.user.entity.User;
import lifestyle.WSAYLT.domain.auth.exception.ExistNicknameException;
import lifestyle.WSAYLT.domain.auth.presentation.dto.request.SignUpRequest;
import lifestyle.WSAYLT.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignUpRequest signUpRequest) {
        if (userRepository.existsByNickname(signUpRequest.getNickname())) {
            throw new ExistNicknameException("이미 존재하는 닉네임입니다.");
        }

        User user = User.builder()
                .name(signUpRequest.getName())
                .nickname(signUpRequest.getNickname())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();

        userRepository.save(user);
    }
}
