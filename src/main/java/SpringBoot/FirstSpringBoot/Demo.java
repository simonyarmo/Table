package SpringBoot.FirstSpringBoot;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Demo {
    private ArrayList<User> users = new ArrayList<>();
    public Demo(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "root", "Redcar123!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            while (resultSet.next()) {
                int i =0;
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                User x = new User(name,age);
                users.add(x);
                System.out.println((resultSet.getString("name")));
                System.out.println((resultSet.getString("age")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers(){
        return users;
    }

}
