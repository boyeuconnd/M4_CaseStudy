package codegym.repositories.blogs;


import codegym.models.blogs.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
    Page<Post> findAllByTitleContaining(String title, Pageable pageable);
}

