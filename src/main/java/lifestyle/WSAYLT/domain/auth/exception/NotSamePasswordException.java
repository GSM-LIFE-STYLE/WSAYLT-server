package lifestyle.WSAYLT.domain.auth.exception;

import lifestyle.WSAYLT.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class NotSamePasswordException extends RuntimeException {

    private final ErrorCode errorCode;
    public NotSamePasswordException(String message) {
        super(message);
        this.errorCode = ErrorCode.NOT_SAME_PASSWORD;
    }
}
