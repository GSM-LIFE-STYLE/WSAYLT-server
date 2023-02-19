package lifestyle.WSAYLT.domain.board.exception;

import lifestyle.WSAYLT.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AlreadyInsertHeartException extends RuntimeException{

    private final ErrorCode errorCode;

    public AlreadyInsertHeartException(String message){
        super(message);
        this.errorCode = ErrorCode.ALREADY_INSERT_HEART;
    }
}
