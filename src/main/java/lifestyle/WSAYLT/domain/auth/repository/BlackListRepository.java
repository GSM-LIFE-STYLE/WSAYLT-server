package lifestyle.WSAYLT.domain.auth.repository;

import lifestyle.WSAYLT.domain.auth.entity.BlackList;
import org.springframework.data.repository.CrudRepository;

public interface BlackListRepository extends CrudRepository<BlackList, String> {
}
