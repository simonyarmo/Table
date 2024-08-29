package SpringBoot.FirstSpringBoot;

import java.sql.*;
import java.util.ArrayList;

public class ClientController {
    private ArrayList<Client> clients = new ArrayList<>();
    public ClientController(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", "root", "Redcar123!");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CLIENT");

            while (resultSet.next()) {
                int i =0;
                String username = resultSet.getString("name");
                String password = resultSet.getString("password");
                Client x = new Client(username,password);
                clients.add(x);
                System.out.println((resultSet.getString("name")));
                System.out.println((resultSet.getString("age")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Client> getClients(){return clients;}
}
