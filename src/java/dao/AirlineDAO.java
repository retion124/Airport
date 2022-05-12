package dao;

import entity.Airline;

import java.util.List;

public interface AirlineDAO {

    void add(Airline airline);

    List<Airline> getAll();


}
