package lifestyle.WSAYLT.domain.board.presentation;


import lifestyle.WSAYLT.domain.board.presentation.dto.request.BoardRequest;
import lifestyle.WSAYLT.domain.board.presentation.dto.request.HeartRequest;
import lifestyle.WSAYLT.domain.board.service.HeartInsertService;
import lifestyle.WSAYLT.domain.board.service.WriteBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final WriteBoardService writeBoardService;
    private final HeartInsertService heartInsertService;

    @PostMapping
    public void write(@RequestBody @Valid BoardRequest boardRequest){
        writeBoardService.execute(boardRequest);
    }

    @PostMapping("/{boardId}/like")
    public ResponseEntity<Void> insert(@PathVariable("boardId") Long boardId, @RequestBody HeartRequest heartRequest){
        heartInsertService.execute(boardId,heartRequest);
        return ResponseEntity.ok().build();
    }
}
