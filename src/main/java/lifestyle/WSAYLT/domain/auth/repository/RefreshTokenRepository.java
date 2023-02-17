package lifestyle.WSAYLT.domain.auth.repository;

import lifestyle.WSAYLT.domain.auth.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
