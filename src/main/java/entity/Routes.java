package entity;

public class Routes {
    private String Departures;
    private String Arrival;
    private String Time;
    private String Airline;

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String airline) {
        Airline = airline;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public String getDepartures() {
        return Departures;
    }

    public void setDepartures(String departures) {
        Departures = departures;
    }
}
