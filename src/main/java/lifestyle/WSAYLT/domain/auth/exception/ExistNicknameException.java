package lifestyle.WSAYLT.domain.auth.exception;

import lifestyle.WSAYLT.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class ExistNicknameException extends RuntimeException {

    private final ErrorCode errorCode;
    public ExistNicknameException(String message) {
        super(message);
        this.errorCode = ErrorCode.ALREADY_EXIST_NICKNAME;
    }
}
