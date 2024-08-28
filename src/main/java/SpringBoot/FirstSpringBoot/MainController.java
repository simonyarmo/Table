package SpringBoot.FirstSpringBoot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class MainController {
    ArrayList<User> users = new ArrayList<>();
    @GetMapping
    public String showFriends(Model model){
        Demo x =new Demo();
        users = x.getUsers();
        model.addAttribute("users", users);
        return "printUsers";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        // Handle the logic for adding a new user
        return "addUserForm"; // Corresponds to addUserForm.html
    }

    @PostMapping("/processName")
    public String processName(@RequestParam("name") String name, String age, Model model) {
        String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Redcar123!");
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, age);

        }catch(SQLException e){
            System.out.println(e);
        }
        // Do something with the name in Java
        System.out.println("Received name: " + name);
        System.out.println("Received age: " + age);

        model.addAttribute("users", users);
        return "printUsers"; // Redirect to another view, like nameResult.html
    }


    public void addUser(String username, String password) {

    }

}
