package lifestyle.WSAYLT.domain.board.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class HeartRequest {

    @NotNull
    private String nickname;
}
