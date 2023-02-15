package lifestyle.WSAYLT.domain.auth.service;

import lifestyle.WSAYLT.domain.auth.entity.User;
import lifestyle.WSAYLT.domain.auth.exception.ExistNicknameException;
import lifestyle.WSAYLT.domain.auth.exception.NotSamePasswordException;
import lifestyle.WSAYLT.domain.auth.presentation.dto.request.SignUpRequest;
import lifestyle.WSAYLT.domain.auth.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final AuthRepository authRepository;

    public void signUp(SignUpRequest signUpRequest) throws Exception {
        if (authRepository.findByNickname(signUpRequest.getNickname()).isPresent()) {
            throw new ExistNicknameException("이미 존재하는 닉네임입니다.");
        }

            User user = User.builder()
                    .nickname(signUpRequest.getNickname())
                    .password(signUpRequest.getPassword())
                    .build();

        if(!signUpRequest.getPassword().equals(signUpRequest.getPasswordConfirm())) {
            throw new NotSamePasswordException("비밀번호가 일치하지 않습니다.");
        } else {
            authRepository.save(user);

        }

    }
}
