package lifestyle.WSAYLT.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ALREADY_EXIST_NICKNAME("이미 존재하는 닉네임입니다.", 400),
    NOT_SAME_PASSWORD("비밀번호가 일치하지 않습니다.", 400);

    private final String message;
    private final int status;
}
