package lifestyle.WSAYLT.domain.auth.service;

import lifestyle.WSAYLT.domain.auth.entity.RefreshToken;
import lifestyle.WSAYLT.domain.auth.exception.MisMatchPasswordException;
import lifestyle.WSAYLT.domain.auth.exception.UserNotFoundException;
import lifestyle.WSAYLT.domain.auth.presentation.dto.request.LoginRequest;
import lifestyle.WSAYLT.domain.auth.presentation.dto.response.LoginResponse;
import lifestyle.WSAYLT.domain.auth.repository.RefreshTokenRepository;
import lifestyle.WSAYLT.domain.user.entity.User;
import lifestyle.WSAYLT.domain.user.repository.UserRepository;
import lifestyle.WSAYLT.global.security.jwt.TokenProvider;
import lifestyle.WSAYLT.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;


    public LoginResponse execute(LoginRequest loginRequest){
        User user = userRepository.findByNickname(loginRequest.getNickname())
                .orElseThrow(()->new UserNotFoundException("존재하지 않는 회원입니다."));

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new MisMatchPasswordException("비밀번호가 일치하지 않습니다.");
        }

        String accessToken = tokenProvider.generatedAccessToken(loginRequest.getNickname());
        String refreshToken = tokenProvider.generatedRefreshToken(loginRequest.getNickname());
        RefreshToken refreshTokenEntity = new RefreshToken(loginRequest.getNickname(), refreshToken,tokenProvider.getREFRESH_TOKEN_EXPIRE_TIME());

        refreshTokenRepository.save(refreshTokenEntity);

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(tokenProvider.getExpiredAtToken(accessToken,jwtProperties.getAccessSecret()))
                .build();
    }

}
