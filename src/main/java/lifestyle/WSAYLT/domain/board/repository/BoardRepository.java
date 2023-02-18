package lifestyle.WSAYLT.domain.board.repository;

import lifestyle.WSAYLT.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
