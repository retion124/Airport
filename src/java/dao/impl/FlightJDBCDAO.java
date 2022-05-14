package dao.impl;

import com.sun.jdi.connect.spi.Connection;
import dao.FlightDAO;
import entity.Flight;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightJDBCDAO implements FlightDAO {
    public FlightJDBCDAO(){

    }

    @Override
    public void add(Flight flight) {
        Connection connection = null;
        connection = (Connection) this.getConnection();
        try {
            int FlightId = this.getFlightId(flight.getFlightName(), (java.sql.Connection) connection);
            PreparedStatement statement;
            if (FlightId == -1) {
                statement = ((java.sql.Connection) connection).prepareStatement("INSERT INTO FlightId(flightId) VALUES (?)");
                statement.setInt(1, flight.getFlightId());
                statement.execute();
                statement = ((java.sql.Connection) connection).prepareStatement("SELECT MAX(id) FROM FlightId");
                ResultSet rs = statement.executeQuery();
                rs.next();
                FlightId = rs.getInt(1);
            }
            statement = ((java.sql.Connection) connection).prepareStatement("INSERT INTO Flight(FlightId,FlightName ,Routes, Time, Airline, Status, PassengersOk) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, FlightId);
            statement.setString(2, flight.getFlightName());
            statement.setString(3, flight.getRoutes());
            statement.setInt(4, flight.getTime());
            statement.setString(5, flight.getAirline());
            statement.setBoolean(6, flight.getStatus());
            statement.setInt(7, flight.getPassengersOk());
            statement.execute();
        } catch (SQLException var6) {
            var6.printStackTrace();
        }
    }


    private int getFlightId(String FlightName , java.sql.@NotNull Connection connection){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT FlightId FROM FlightNames WHERE FlightName = ? ");
                preparedStatement.setString(1, FlightName);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException var5) {
                var5.printStackTrace();
            }
            return -1;
        }


    @Override
    public List<Flight> getAll() {
        List<Flight> allFlight = new ArrayList();
        java.sql.Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.getConnection();
            statement = connection.prepareStatement("SELECT c.FlightId, m.FlightName, c.Routes, c.Time ,c.Airline , c.Status, c.PassengersOk FROM Flight as c INNER JOIN FlightName as m ON m.FlightId  = c.FlightName_FlightId  ");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                int FlightId  = rs.getInt(1);
                String FlightName = rs.getString(2);
                String Routes= rs.getString(3);
                int Time = rs.getInt(4);
                String Airline = rs.getString(5);
                Boolean Status = rs.getBoolean(6);
                int PassengersOk = rs.getInt(7);
                Flight  flight  = new  Flight();
                flight.setFlightId( FlightId);
                flight.setFlightName(FlightName);
                flight.setRoutes(Routes);
                flight.setAirline(Airline);
                flight.setStatus(Status);
                flight.setPassengersOk(PassengersOk);
                 allFlight.add(flight);
            }
        } catch (SQLException var11) {
            var11.printStackTrace();
        }

        return allFlight;
    }

    @Override
    public void remove(int FlightId) {

    }


    private java.sql.@Nullable Connection getConnection() {
        java.sql.Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Airport", "root", "12345");
            return connection;
        } catch (SQLException var3) {
            var3.printStackTrace();
            return null;
        }
    }
}
