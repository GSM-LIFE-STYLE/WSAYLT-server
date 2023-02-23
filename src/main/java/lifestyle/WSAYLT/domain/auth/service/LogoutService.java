package lifestyle.WSAYLT.domain.auth.service;

import lifestyle.WSAYLT.domain.auth.entity.BlackList;
import lifestyle.WSAYLT.domain.auth.entity.RefreshToken;
import lifestyle.WSAYLT.domain.auth.exception.BlackListAlreadyExistException;
import lifestyle.WSAYLT.domain.auth.exception.RefreshTokenNotFoundException;
import lifestyle.WSAYLT.domain.auth.repository.BlackListRepository;
import lifestyle.WSAYLT.domain.auth.repository.RefreshTokenRepository;
import lifestyle.WSAYLT.domain.user.entity.User;
import lifestyle.WSAYLT.global.security.jwt.TokenProvider;
import lifestyle.WSAYLT.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogoutService {

    private final BlackListRepository blackListRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserUtil userUtil;
    private final TokenProvider tokenProvider;


    @Transactional
    public void execute(String accessToken) {
        User user = userUtil.currentUser();
        String nickName = user.getNickname();
        RefreshToken refreshToken = refreshTokenRepository.findById(nickName)
                .orElseThrow(() -> new RefreshTokenNotFoundException("존재하지 않는 리프레시 토큰입니다."));
        refreshTokenRepository.delete(refreshToken);
        saveBlackList(user.getNickname(), accessToken);
    }

    private void saveBlackList(String nickName, String accessToken) {

        if(blackListRepository.existsById(accessToken))
            throw new BlackListAlreadyExistException("블랙리스트에 이미 등록되어있습니다.");

        long expiredTime = tokenProvider.getACCESS_TOKEN_EXPIRE_TIME();

        BlackList blackList = BlackList.builder()
                .nickName(nickName)
                .accessToken(accessToken)
                .timeToLive(expiredTime)
                .build();
        blackListRepository.save(blackList);
    }
}
