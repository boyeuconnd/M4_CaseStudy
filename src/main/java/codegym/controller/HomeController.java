package codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }

    @GetMapping("/contact")
    public String getContactPage(){return "contact";}


    @GetMapping("/reservation")
    public String getReservationPage(){
        return "/reservation";
    }
}
