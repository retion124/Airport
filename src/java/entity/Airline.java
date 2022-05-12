package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline {
@Id
    private int AirlineId;
    private String Name;
    private String Airplane;
    private long Rating;
    public Airline(){

    }

    public void setAirlineId(int airlineId) {AirlineId = airlineId;}

    public int getAirlineId() { return AirlineId; }

    public long getRating() {
        return Rating;
    }

    public void setRating(long rating) {
        Rating = rating;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAirplane() {
        return Airplane;
    }

    public void setAirplane(String airplane) {
        Airplane = airplane;
    }
}
