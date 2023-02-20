package lifestyle.WSAYLT.domain.board.service;


import lifestyle.WSAYLT.domain.board.entity.Board;
import lifestyle.WSAYLT.domain.board.presentation.dto.request.BoardRequest;
import lifestyle.WSAYLT.domain.board.repository.BoardRepository;
import lifestyle.WSAYLT.domain.user.entity.User;
import lifestyle.WSAYLT.global.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WriteBoardService {

    private final BoardRepository boardRepository;
    private final UserUtil userUtil;

    @Transactional
    public void execute(BoardRequest boardRequest){
        User user = userUtil.currentUser();
        Board board = Board.builder()
                .title(boardRequest.getTitle())
                .musicUrl(boardRequest.getMusicUrl())
                .user(user)
                .heartCount(0)
                .build();
        boardRepository.save(board);
    }

}
