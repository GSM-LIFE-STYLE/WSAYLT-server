package lifestyle.WSAYLT.domain.board.presentation;


import lifestyle.WSAYLT.domain.board.presentation.dto.request.BoardRequest;
import lifestyle.WSAYLT.domain.board.service.WriteBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final WriteBoardService writeBoardService;

    @PostMapping
    public void write(@RequestBody BoardRequest boardRequest){
        writeBoardService.execute(boardRequest);
    }
}
