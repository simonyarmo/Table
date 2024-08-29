package SpringBoot.FirstSpringBoot;

import java.util.ArrayList;

public class Client {
    private String username;
    private String password;

    public Client(String name, String password){
        this.username = name;
        this.password = password;
    }

    public void setUsername(String name){
        username=name;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public String getUsername(){return username;}
    public String getPassword(){return password;}

}
