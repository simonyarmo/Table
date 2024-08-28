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
//    @Id
//    @Column(name = "name")
    private String name;

//    @Column(name = "age")
    private String age;
    public User(String name, String age){
        this.name =name;
        this.age =age;
    }


}
