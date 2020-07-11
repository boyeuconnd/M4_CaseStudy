package codegym.repositories.blogs;


import codegym.models.blogs.Category;
import codegym.models.blogs.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
