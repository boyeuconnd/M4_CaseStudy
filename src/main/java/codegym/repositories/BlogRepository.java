package codegym.repositories;

import codegym.models.Blog;
import codegym.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog,Long> {
    Iterable<Blog> findAllByAccount(Users user);
    Page<Blog> findAllByTitle(String title, Pageable pageable);
}
