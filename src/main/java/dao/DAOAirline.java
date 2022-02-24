package dao;

import entity.Airline;

import java.util.List;

public interface DAOAirline {

    void add(Airline airline);

    List<Airline> getAll();


}