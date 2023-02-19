package lifestyle.WSAYLT.domain.board.service;

import lifestyle.WSAYLT.domain.auth.exception.UserNotFoundException;
import lifestyle.WSAYLT.domain.board.entity.Board;
import lifestyle.WSAYLT.domain.board.exception.AlreadyInsertHeartException;
import lifestyle.WSAYLT.domain.board.exception.BoardNotFoundException;
import lifestyle.WSAYLT.domain.board.presentation.dto.request.HeartRequest;
import lifestyle.WSAYLT.domain.board.repository.BoardRepository;
import lifestyle.WSAYLT.domain.board.entity.Heart;
import lifestyle.WSAYLT.domain.board.repository.HeartRepository;
import lifestyle.WSAYLT.domain.user.entity.User;
import lifestyle.WSAYLT.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class HeartInsertService {

    private final HeartRepository heartRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void execute(Long boardId, HeartRequest heartRequest){
        User user = userRepository.findByNickname(heartRequest.getNickname())
                .orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다"));

        Board currentBoard = boardRepository.findById(boardId)
                .orElseThrow(() -> new BoardNotFoundException("게시글이 존재하지 않습니다"));

        if(heartRepository.findByUserAndBoard(user,currentBoard).isPresent()){
            throw new AlreadyInsertHeartException("이미 좋아요를 누르셨습니다");
        }

        Heart heart = Heart.builder()
                .board(currentBoard)
                .user(user)
                .build();

        Board board = Board.builder()
                .boardId(currentBoard.getBoardId())
                .title(currentBoard.getTitle())
                .musicUrl(currentBoard.getMusicUrl())
                .heartCount(currentBoard.getHeartCount()+1)
                .build();

        heartRepository.save(heart);
        boardRepository.save(board);
    }
}
