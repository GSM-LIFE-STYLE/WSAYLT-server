package lifestyle.WSAYLT.domain.user.repository;

import lifestyle.WSAYLT.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByNickname(String nickname);
    Optional<User> findByNickname(String nickname);
}
