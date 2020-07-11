package codegym.controller;


import codegym.models.Role;
import codegym.models.Users;
import codegym.models.UsersForm;
import codegym.service.RoleService;
import codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    Environment env;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    @GetMapping("create")
    public ModelAndView getRegisterForm(){
        ModelAndView mv = new ModelAndView("user/create");
        mv.addObject("newUser",new UsersForm());
        return mv;
    }

    @PostMapping("create")
    public ModelAndView userRegister(@Validated @ModelAttribute("newUser") UsersForm usersForm, BindingResult bindingResult){

        ModelAndView mv = null;
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("user/create");
        }else {
            Users newUser = cloneFromUserformToUser(usersForm);

            //create direct file path to new avatar file
            MultipartFile multipartFile = usersForm.getAvatar();
            String filepath = env.getProperty("file_upload").toString();
            String fileName = newUser.getUserName() + "-" + multipartFile.getOriginalFilename();


            mv = new ModelAndView("user/create");
            Role staffRole = roleService.getRoleById(3L);

            //set avatar avatar link and set default role user
            newUser.setAvatar(fileName);
            newUser.setRole(staffRole);
            if (userService.save(newUser) != null) {
                try {
                    FileCopyUtils.copy(usersForm.getAvatar().getBytes(), new File(filepath + fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mv.addObject("newUser", new UsersForm());
                mv.addObject("mess", "Register Success");
            } else {
                mv.addObject("newUser", usersForm);
                mv.addObject("mess", "Register Not Finish");
            }
        }
        return mv;
    }

    private Users cloneFromUserformToUser(@ModelAttribute UsersForm usersForm) {
        return new Users(usersForm.getFirstName(),
                    usersForm.getLastName(),usersForm.getUserName(),
                    usersForm.getEmail(),usersForm.getPassword(),
                    null);
    }

}
