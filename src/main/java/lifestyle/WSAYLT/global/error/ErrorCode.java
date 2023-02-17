package lifestyle.WSAYLT.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ALREADY_EXIST_NICKNAME("이미 존재하는 닉네임입니다.", 400),
    NOT_SAME_PASSWORD("비밀번호가 일치하지 않습니다.", 400),
    USER_NOT_FOUND("사용자를 찾을 수 없습니다", 404),
    TOKEN_IS_EXPIRED("토큰이 만료 되었습니다.", 401),
    TOKEN_NOT_VALID("토큰이 유효 하지 않습니다.", 401),
    MISMATCH_MEMBER_PASSWORD("비밀번호가 일치하지 않습니다.", 400),
    REFRESH_TOKEN_NOT_FOUND("존재하지 않는 리프레시 토큰입니다.", 404);


    private final String message;
    private final int status;
}
