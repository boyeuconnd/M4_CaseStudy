package codegym.service.impl.blogs;


import codegym.models.blogs.Post;

import codegym.repositories.blogs.PostRepository;
import codegym.service.blogs.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {

        return postRepository.findAll(pageable);
    }

    @Override
    public Page<Post> findAllSummary(Pageable pageable) {

        return postRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {

        return postRepository.findOne(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Long id) {

        postRepository.delete(id);
    }

    @Override
    public Post addLike(Long blogId) {
        Post post = postRepository.findOne(blogId);
        Long likes = post.getLike() + 1;
        post.setLike( likes  );
        return postRepository.save(post);
    }
}
