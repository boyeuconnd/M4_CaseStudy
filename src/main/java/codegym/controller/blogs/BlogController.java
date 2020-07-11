//package codegym.controller.blogs;
//
//
//import codegym.models.blogs.Post;
//import codegym.service.blogs.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("blog")
//public class BlogController {
//
//    @Autowired
//    PostService postService;
//
//    @GetMapping("")
//    public ModelAndView getBlogPage(@ModelAttribute Post post){
//        ModelAndView mv = new ModelAndView("blogs/blog");
//        mv.addObject("post", post);
//        return mv;
//    }
//
//    @GetMapping("/create")
//    public String getFormCreate(){
//        return "blogs/create";
//    }
//
//    @PostMapping("/create")
//    public ModelAndView createPost(@ModelAttribute Post post){
//        ModelAndView mv = new ModelAndView("blogs/create");
//        mv.addObject("post", post);
//        if(postService.save(post)!=null){
//            mv.addObject("blog",new Post());
//            mv.addObject("mess","Register Success");
//        }else {
//            mv.addObject("blog", post);
//            mv.addObject("mess","Register Not Finish");
//
//        }
//        return mv;
//    }
//
//}
