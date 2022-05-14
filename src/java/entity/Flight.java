package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
    @Id
    private int FlightId ;
    private String FlightName;
    private String Routes;
    private int Time;
    private String Airline;
    private Boolean Status;
    private int PassengersOk;


    public int getFlightId(){return FlightId; }

    public void setFlightId(int flightId){FlightId = flightId;}

    public String getFlightName(){return FlightName;}

    public void setFlightName(String flightName){FlightName = flightName;}

    public String getRoutes() {
        return Routes;
    }

    public void setRoutes(String routes) {
        Routes = routes;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int  time) {
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