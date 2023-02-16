package lifestyle.WSAYLT.domain.auth.repository;

import lifestyle.WSAYLT.domain.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User, Long> {
    boolean existsByNickname(String nickname);
}
