package SpringBoot.FirstSpringBoot;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "Student")

public class User {
    private String name;
    private String age;

    // Constructor
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public String getAge() {
        return age;
    }

    // Setter for age
    public void setAge(String age) {
        this.age = age;
    }
}
