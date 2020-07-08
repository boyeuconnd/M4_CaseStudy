package codegym.controller;


import codegym.models.Blog;
import codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("")
    public ModelAndView getBlogPage(@ModelAttribute Blog blog){
        ModelAndView mv = new ModelAndView("blogs/blog");
        mv.addObject("post",blog);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView getFormCreate(@ModelAttribute Blog blog){
        ModelAndView mv = new ModelAndView("blogs/create");
        mv.addObject("post",blog);
        if(blogService.save(blog)!=null){
            mv.addObject("blog",new Blog());
            mv.addObject("mess","Register Success");
        }else {
            mv.addObject("blog",blog);
            mv.addObject("mess","Register Not Finish");

        }
        return mv;
    }

}
