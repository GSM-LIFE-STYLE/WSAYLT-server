package lifestyle.WSAYLT.domain.board.presentation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequest {

    private String title;
    private String url;
}
