package dao;


import entity.Passengers;

import java.util.List;

public interface PassengersDAO {

    void add(Passengers passengers);

    List<Passengers> getAll();

    void remove(int  PassengersId);
}
