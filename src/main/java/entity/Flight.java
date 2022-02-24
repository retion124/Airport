package entity;

import javax.persistence.Entity;

@Entity
public class Flight {
    private String Routes;
    private String Time;
    private String Airline;
    private Boolean Status;
    private int PassengersOk;

    public String getRoutes() {
        return Routes;
    }

    public void setRoutes(String routes) {
        Routes = routes;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public int getPassengersOk() {
        return PassengersOk;
    }

    public void setPassengersOk(int passengersOk) {
        PassengersOk = passengersOk;
    }
}