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

    @Id
    private String nickname;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private long expiredAt;

    public void exchangeRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}
