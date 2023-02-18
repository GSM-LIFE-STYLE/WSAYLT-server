package lifestyle.WSAYLT.domain.auth.service;


import lifestyle.WSAYLT.domain.auth.entity.RefreshToken;
import lifestyle.WSAYLT.domain.auth.exception.RefreshTokenNotFoundException;
import lifestyle.WSAYLT.domain.auth.presentation.dto.response.NewTokenResponse;
import lifestyle.WSAYLT.domain.auth.repository.RefreshTokenRepository;
import lifestyle.WSAYLT.global.security.exception.TokenNotValidException;
import lifestyle.WSAYLT.global.security.jwt.TokenProvider;
import lifestyle.WSAYLT.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class TokenReissueService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenProvider tokenProvider;
    private final JwtProperties jwtProperties;

    @Transactional(rollbackFor = Exception.class)
    public NewTokenResponse execute(String reqToken){
        String nickname = tokenProvider.getUserNickname(reqToken,jwtProperties.getRefreshSecret());
        RefreshToken token = refreshTokenRepository.findById(nickname)
                .orElseThrow(()->new RefreshTokenNotFoundException("존재하지 않은 refreshToken 입니다."));

        if(!token.getRefreshToken().equals(reqToken)){
            throw new TokenNotValidException("토큰이 유효하지 않습니다.");
        }

        String accessToken = tokenProvider.generatedAccessToken(nickname);
        String refreshToken = tokenProvider.generatedRefreshToken(nickname);
        ZonedDateTime expiredAt = tokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret());
        token.exchangeRefreshToken(refreshToken);
        refreshTokenRepository.save(token);
        return NewTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(expiredAt)
                .build();


    }
}
