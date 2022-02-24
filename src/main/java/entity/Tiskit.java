package entity;

import javax.persistence.Entity;

@Entity
public class Tiskit {
    private int Id;
    private int Place;
    private String Flight;
    private String Passengers;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPlace() {
        return Place;
    }

    public void setPlace(int place) {
        Place = place;
    }

    public String getFlight() {
        return Flight;
    }

    public void setFlight(String flight) {
        Flight = flight;
    }

    public String getPassengers() {
        return Passengers;
    }

    public void setPassengers(String passengers) {
        Passengers = passengers;
    }
}
