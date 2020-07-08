package codegym.repositories;

import codegym.models.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<Users,Long> {
}
