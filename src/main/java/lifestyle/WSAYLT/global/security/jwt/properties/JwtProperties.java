package lifestyle.WSAYLT.global.security.jwt.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "jwt") // yml 안에 jwt 설정 해줘야함
public class JwtProperties {
    private final String accessSecret;
    private final String refreshSecret;
}
