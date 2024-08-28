package SpringBoot.FirstSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@SpringBootApplication
public class FirstSpringBootApplication {

//	@RequestMapping("/")
//	String home() {
//		return "Hello World!";
//	}
//	@GetMapping("/people")
//	public String showFriends(Model model){
//		Demo x =new Demo();
//		ArrayList<User> users = x.getUsers();
//		model.addAttribute("users", users);
//		return "printUsers";
//	}
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("message", "Hello, Thymeleaf!");
		return "test";
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

}
