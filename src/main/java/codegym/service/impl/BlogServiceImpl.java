package codegym.service.impl;

import codegym.models.Blog;
import codegym.models.Users;
import codegym.repositories.BlogRepository;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {

        return blogRepository.findOne(id);
    }

    @Override
    public Blog save(Blog blog) {
       return blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
       blogRepository.delete(id);
    }

    @Override
    public Blog addLike(Long blogId) {
        Blog blog = blogRepository.findOne(blogId);
        Long likes = blog.getLike() + 1;
        blog.setLike( likes  );
        return blogRepository.save(blog);
    }

    @Override
    public Iterable<Blog> findAllByAccount(Users user) {

        return blogRepository.findAllByAccount(user);
    }

    @Override
    public Page<Blog> findAllByTitle(String title, Pageable pageable) {
        return blogRepository.findAllByTitle(title,pageable);
    }
}
