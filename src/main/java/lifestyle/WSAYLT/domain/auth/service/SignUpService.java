package lifestyle.WSAYLT.domain.auth.service;

import lifestyle.WSAYLT.domain.auth.entity.User;
import lifestyle.WSAYLT.domain.auth.exception.ExistNicknameException;
import lifestyle.WSAYLT.domain.auth.exception.NotSamePasswordException;
import lifestyle.WSAYLT.domain.auth.presentation.dto.request.SignUpRequest;
import lifestyle.WSAYLT.domain.auth.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpRequest signUpRequest) {
        if (authRepository.existsByNickname(signUpRequest.getNickname())) {
            throw new ExistNicknameException("이미 존재하는 닉네임입니다.");
        }

            User user = User.builder()
                    .nickname(signUpRequest.getNickname())
                    .password(passwordEncoder.encode(signUpRequest.getPassword()))
                    .build();

            authRepository.save(user);
    }
}
