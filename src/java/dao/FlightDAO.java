package dao;

import java.util.List;

import entity.Flight;

public interface FlightDAO {

    void add(Flight flight);

    List<Flight> getAll();

    void remove(int  FlightId);
}
