package codegym.controller;

import codegym.models.Rank;
import codegym.models.Role;
import codegym.models.Staff;
import codegym.models.Status;
import codegym.service.RoleService;
import codegym.service.StaffService;
import codegym.service.staff.RankService;
import codegym.service.staff.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("staff")
public class StaffController {

    @Autowired
    RankService rankService;

    @Autowired
    StaffService staffService;
    @Autowired
    StatusService statusService;
    @Autowired
    RoleService roleService;


    @ModelAttribute("allRanks")
    public Iterable<Rank> callAllRank(){
        return rankService.showRanks();
    }

    @ModelAttribute("allStatus")
    public Iterable<Status> callAllStatus(){
        return statusService.showStatus();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView mv = new ModelAndView("staff/create");
        mv.addObject("staff",new Staff());
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView createStaff(@ModelAttribute Staff staff){
        ModelAndView mv = new ModelAndView("staff/create");
        Role staffRole = roleService.getRoleById(2L);
        staff.setRole(staffRole);
        if(staffService.save(staff)!=null){
            mv.addObject("staff",new Staff());
            mv.addObject("mess","Register Success");
        }else {
            mv.addObject("staff",staff);
            mv.addObject("mess","Register Not Finish");

        }
        return mv;
    }
}
