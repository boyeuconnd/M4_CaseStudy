package codegym.service;

import codegym.models.Blog;
import codegym.models.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService{
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    Blog save(Blog blog);

    void remove(Long id);

    Blog addLike(Long id);

    Page<Blog> findAllByTitle(String title, Pageable pageable);

}
