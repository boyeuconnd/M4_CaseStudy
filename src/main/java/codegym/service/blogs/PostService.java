package codegym.service.blogs;

import codegym.models.blogs.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<Post> findAll(Pageable pageable);

    Page<Post> findAllSummary(Pageable pageable);

    Post findById(Long id);

    Post save(Post post);

    void delete(Long id);

    Post addLike(Long id);

}
