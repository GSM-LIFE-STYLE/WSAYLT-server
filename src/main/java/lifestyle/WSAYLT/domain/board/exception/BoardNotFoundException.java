package lifestyle.WSAYLT.domain.board.exception;


import lifestyle.WSAYLT.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoardNotFoundException extends RuntimeException{

    private final ErrorCode errorCode;

    public BoardNotFoundException(String message){
        super(message);
        this.errorCode = ErrorCode.BOARD_NOT_FOUND;
    }
}
