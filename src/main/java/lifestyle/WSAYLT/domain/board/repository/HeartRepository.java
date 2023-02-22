package lifestyle.WSAYLT.domain.board.repository;

import lifestyle.WSAYLT.domain.board.entity.Board;
import lifestyle.WSAYLT.domain.board.entity.Heart;
import lifestyle.WSAYLT.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    boolean existsHeartByUserAndBoard(User user, Board board);
    void deleteHeartByUserAndBoard(User user, Board board);

}
