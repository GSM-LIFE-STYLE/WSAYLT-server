package lifestyle.WSAYLT.global.security.exception;

import lifestyle.WSAYLT.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class TokenExpirationException extends RuntimeException {
    private final ErrorCode errorCode;
    public TokenExpirationException(String message) {
        super(message);
        this.errorCode = ErrorCode.TOKEN_IS_EXPIRED;
    }
}
