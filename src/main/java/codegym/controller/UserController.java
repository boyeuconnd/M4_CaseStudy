package codegym.controller;


import codegym.models.Role;
import codegym.models.Staff;
import codegym.models.Users;
import codegym.repositories.UserRepository;
import codegym.service.RoleService;
import codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/create")
    public ModelAndView getRegisterForm(){
        ModelAndView mv = new ModelAndView("user/create");
        mv.addObject("newUser",new Users());
        return mv;
    }

    @PostMapping("create")
    public ModelAndView userRegister(@ModelAttribute Users user){
        ModelAndView mv = new ModelAndView("user/create");
        Role staffRole = roleService.getRoleById(3L);
        user.setRole(staffRole);
        if(userService.save(user)!=null){
            mv.addObject("newUser",new Users());
            mv.addObject("mess","Register Success");
        }else {
            mv.addObject("newUser",user);
            mv.addObject("mess","Register Not Finish");
        }
        return mv;
    }

}
