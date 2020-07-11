package codegym.service.blogs;



import codegym.models.blogs.Category;

public interface CategoryService {

    Iterable<Category> findAll();


    Category findById(Long id);

    Category save(Category category);

    void delete(Long id);

}
