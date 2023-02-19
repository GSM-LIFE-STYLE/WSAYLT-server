package lifestyle.WSAYLT.domain.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;


@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "blackList")
public class BlackList {

    @Id
    private String accessToken;

    private String nickName;

    @TimeToLive
    private Long timeToLive;
}