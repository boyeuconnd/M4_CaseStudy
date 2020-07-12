package codegym.controller;

import codegym.models.*;
import codegym.service.RoleService;
import codegym.service.UserService;
import codegym.service.staff.RankService;
import codegym.service.staff.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("staff")
public class StaffController {

    @Autowired
    RankService rankService;

    @Autowired
    StatusService statusService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @ModelAttribute("allRanks")
    public Iterable<Rank> callAllRank(){
        return rankService.showRanks();
    }

    @ModelAttribute("allStatus")
    public Iterable<Status> callAllStatus(){
        return statusService.showStatus();
    }

    @GetMapping("/register")
    public ModelAndView showPromoteForm(){
        ModelAndView mv = new ModelAndView("staff/create");
        mv.addObject("staff",new UsersForm());
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView becomeStaff(@ModelAttribute Users staff){
        ModelAndView mv = new ModelAndView("staff/create");
        Role staffRole = roleService.getRoleById(2L);
        staff.setRole(staffRole);
        if(userService.save(staff)!=null){
            mv.addObject("staff",new UsersForm());
            mv.addObject("mess","Register Success");
        }else {
            mv.addObject("staff",staff);
            mv.addObject("mess","Register Not Finish");

        }
        return mv;
    }

    @GetMapping("")
    public ModelAndView showStaffList(Pageable pageable){
        Page<Users> staffList;
        ModelAndView mv = new ModelAndView("menu");
        staffList = userService.findAllByRoleEquals(roleService.getRoleById(2L),pageable);
        mv.addObject("staffList",staffList);
        return mv;
    }

    @GetMapping("view/{id}")
    public ModelAndView showStaffDetail(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("staff/detail");
        Users user = userService.findOne(id);
        mv.addObject("userStaff",user);
        return mv;
    }

    @GetMapping("{id}/edit")
    public String showEditForm(@PathVariable Long id){
        return "staff/update";
    }
}
