package SpringBoot.FirstSpringBoot;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;


public class Controller {

    @GetMapping("/people")
    public String showFriends(Model model){
        Demo x =new Demo();
        ArrayList<User> users = x.getUsers();
        model.addAttribute("users", users);
        return "printUsers";
    }
}
