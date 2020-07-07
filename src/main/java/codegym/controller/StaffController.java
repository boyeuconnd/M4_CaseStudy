package codegym.controller;

import codegym.models.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("staff")
public class StaffController {

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView mv = new ModelAndView("staff/create");
        mv.addObject("staff",new Staff());
        return mv;
    }
}
