package lifestyle.WSAYLT.global.error.handler;

import lifestyle.WSAYLT.domain.auth.exception.ExistNicknameException;
import lifestyle.WSAYLT.domain.auth.exception.NotSamePasswordException;
import lifestyle.WSAYLT.global.error.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExistNicknameException.class)
    public ResponseEntity<ErrorMessage> handleExistNicknameException(HttpServletRequest request , ExistNicknameException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotSamePasswordException.class)
    public ResponseEntity<ErrorMessage> handleNotSamePasswordException(HttpServletRequest request , NotSamePasswordException e) {
        printError(request, e, e.getErrorCode().getMessage());
        ErrorMessage errorMessage = new ErrorMessage(e.getErrorCode().getMessage(), e.getErrorCode().getStatus());
        return new ResponseEntity<>(errorMessage, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    private void printError(HttpServletRequest request, RuntimeException ex, String message) {
        log.error(request.getRequestURI());
        log.error(message);
        ex.printStackTrace();
    }
}
