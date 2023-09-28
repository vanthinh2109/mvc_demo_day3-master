package mvc.controller;

import mvc.formregistration.Gender;
import mvc.formregistration.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private  static final String[] countries = {"Vietnam", "United States", "Germany"};

    @RequestMapping(value = "/registers")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("countries", countries);

        return "registration/userForm";
    }
    @RequestMapping(value = "/result")
    public String processUser(User user){
        return "registration/userResult";
    }
}
