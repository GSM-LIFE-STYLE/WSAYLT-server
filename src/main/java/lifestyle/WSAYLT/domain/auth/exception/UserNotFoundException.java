package lifestyle.WSAYLT.domain.auth.exception;

import lifestyle.WSAYLT.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;
    public UserNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.USER_NOT_FOUND;
    }
}
