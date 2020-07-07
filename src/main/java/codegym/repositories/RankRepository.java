package codegym.repositories;

import codegym.models.Rank;
import org.springframework.data.repository.CrudRepository;

public interface RankRepository extends CrudRepository<Rank,Long> {
}
