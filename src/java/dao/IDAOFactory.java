package dao;

public interface IDAOFactory {
    AirlineDAO getAirlineDAO();

    AirplaneDAO getAirplaneDAO();

    FlightDAO getFlightDAO();

    PassengersDAO getPassengersDAO();




}
