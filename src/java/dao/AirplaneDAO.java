package dao;

import entity.Airplane;

import java.util.List;

public interface AirplaneDAO {

    void add(Airplane airplane);

    List<Airplane> getAll();

    void remove(int  AirplaneId);

}
