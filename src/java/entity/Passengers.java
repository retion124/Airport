package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passengers {

    @Id
    private int PassengersId;
    private String PassengersName;
    private String Passport;
    private int Age;
    private int Phone;
    private int Tiskit;

    public int getPassengersId() {return PassengersId;}

    public void setPassengersId(int passengersId) {
        PassengersId = passengersId;
    }

    public int getPhone() {return Phone;}

    public void setPhone(int phone) {Phone = phone;}

    public int getAge() {return Age;}

    public void setAge(int age) {Age = age;}

    public String getPassport() {return Passport;}

    public void setPassport(String passport) {Passport = passport;}

    public int getTiskit() {return Tiskit;}

    public void setTiskit(int tiskit) {Tiskit = tiskit;}

    public String getPassengersName() {return PassengersName;}

    public void setPassengersName(String passengersName) {PassengersName = passengersName;}
}


