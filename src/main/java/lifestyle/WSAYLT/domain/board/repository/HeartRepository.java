package lifestyle.WSAYLT.domain.board.repository;

import lifestyle.WSAYLT.domain.board.entity.Board;
import lifestyle.WSAYLT.domain.board.entity.Heart;
import lifestyle.WSAYLT.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface HeartRepository extends JpaRepository<Heart, Long> {
    Optional<Heart> findByUserAndBoard(User user, Board board);

}