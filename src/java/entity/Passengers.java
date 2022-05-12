package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passengers {
    @Id
    private int Id;
    private String Name;
    private String Passport;
    private int Age;
    private int Phone;
    private int Tiskit;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPassport() {
        return Passport;
    }

    public void setPassport(String passport) {
        Passport = passport;
    }

    public int getTiskit() {
        return Tiskit;
    }

    public void setTiskit(int tiskit) {
        Tiskit = tiskit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}


