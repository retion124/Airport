package entity;

public class Airline {
    private String Name;
    private String Airplane;
    private long Rating;

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
