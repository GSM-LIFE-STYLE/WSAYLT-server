package lifestyle.WSAYLT.domain.auth.exception;

import lifestyle.WSAYLT.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class MisMatchPasswordException extends RuntimeException {
    private final ErrorCode errorCode;
    public MisMatchPasswordException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_NICKNAME;
    }
}
