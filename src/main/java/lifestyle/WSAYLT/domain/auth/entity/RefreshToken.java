package lifestyle.WSAYLT.domain.auth.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "refreshToken")
public class RefreshToken {

    @Indexed
    private String nickname;
    @Id
    private String refreshToken;

    @TimeToLive
    private long expiredAt;

    public void exchangeRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
