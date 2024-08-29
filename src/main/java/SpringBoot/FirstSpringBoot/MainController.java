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

    @PostMapping("/a")
    public String processName(@RequestParam("name") String name, String age, Model model) {
        String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "root", "Redcar123!");
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, age);
            int rowsInserted = pstmt.executeUpdate();
            User newU = new User(name,age);
            users.add(newU);
        }catch(SQLException e){
            System.out.println(e);
        }

        System.out.println("Received name: " + name);
        System.out.println("Received age: " + age);

        model.addAttribute("users", users);
        return "printUsers";
    }

    @PostMapping("/d")
    public String deleteName(@RequestParam("name") String name, String age, Model model) {
        String sql = "DELETE FROM users WHERE name = ? AND age = ?";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "root", "Redcar123!");
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2,age);


            int index = findUser(name,age);
            if(index!=-1){
                int rowsDeleted = pstmt.executeUpdate();
                users.remove(index);
            }
        }catch(SQLException e){
            System.out.println(e);
        }

        model.addAttribute("users", users);
        return "printUsers";
    }


    public int findUser(String name, String age){
        for(int i =0; i<users.size();i++){
            if(users.get(i).getName().equals(name) && users.get(i).getAge().equals(age)){
                return i;
            }
        }
        return -1;
    }

}
