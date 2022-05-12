package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airplane {
    @Id
    private int AirplaneId;
    private String Model;
    private int NumberPassengers;
    private String Airline;
    private String Pilot;
    private String Stewardess;

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getPilot() {
        return Pilot;
    }

    public void setPilot(String pilot) {
        Pilot = pilot;
    }

    public String getStewardess() {
        return Stewardess;
    }

    public void setStewardess(String stewardess) {
        Stewardess = stewardess;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public int getNumberPassengers() {
        return NumberPassengers;
    }

    public void setNumberPassengers(int numberPassengers) {
        NumberPassengers = numberPassengers;
    }
}
