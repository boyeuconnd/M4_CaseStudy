package codegym.repositories;

import codegym.models.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status,Long> {
}
