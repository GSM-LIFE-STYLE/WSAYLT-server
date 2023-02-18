package lifestyle.WSAYLT.domain.board.service;


import lifestyle.WSAYLT.domain.board.entity.Board;
import lifestyle.WSAYLT.domain.board.presentation.dto.request.BoardRequest;
import lifestyle.WSAYLT.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WriteBoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void execute(BoardRequest boardRequest){
        Board board = Board.builder()
                .title(boardRequest.getTitle())
                .musicUrl(boardRequest.getMusicUrl())
                .build();
        boardRepository.save(board);
    }
}
