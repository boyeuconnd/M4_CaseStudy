package codegym.repositories;

import codegym.models.Role;
import codegym.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<Users,Long> {
    Page<Users> findAllByRoleEquals(Role role, Pageable pageable);
}
