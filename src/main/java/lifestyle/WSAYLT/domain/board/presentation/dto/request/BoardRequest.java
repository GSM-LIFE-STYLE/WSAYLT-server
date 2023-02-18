package lifestyle.WSAYLT.domain.board.presentation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String musicUrl;
}
