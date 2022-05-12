package dao.impl;

import com.sun.jdi.connect.spi.Connection;
import dao.AirlineDAO;
import entity.Airline;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineJDBCDAO implements AirlineDAO {
    public AirlineJDBCDAO(){

    }
   @Override
    public void add( Airline airline) {
        Connection connection = null;
        connection = (Connection) this.getConnection();
        try {
            int airlineId = this.getAirlineId(airline.getName(), (java.sql.Connection) connection);
            PreparedStatement statement;
            if (airlineId == -1) {
                statement = ((java.sql.Connection) connection).prepareStatement("INSERT INTO airlineId(airlineId) VALUES (?)");
                statement.setString(1, airline.getAirlineId());
                statement.execute();
                statement = ((java.sql.Connection) connection).prepareStatement("SELECT MAX(id) FROM airlineId");
                ResultSet rs = statement.executeQuery();
                rs.next();
                airlineId = rs.getInt(1);
            }
            statement = ((java.sql.Connection) connection).prepareStatement( "INSERT INTO airline(AirlineId, Name, Airplane, Rating) VALUES (?, ?, ?, ?)");
            statement.setInt(1, airlineId);
            statement.setString(2, airline.getName());
            statement.setString(3, airline.getAirplane());
            statement.setLong(4, airline.getRating());
            statement.execute();
        } catch (SQLException var6) {
            var6.printStackTrace();

        }
    }
    private int getAirlineId(String Name, java.sql.Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT AirlineId FROM Names WHERE Name = ? ");
            preparedStatement.setString(1, Name);
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
    public List<Airline> getAll() {
        List<Airline> allAirline = new ArrayList();
        java.sql.Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.getConnection();
            statement = connection.prepareStatement("SELECT c.AirlineId, m.Name, c.Airplane, c.Rating FROM Airline as c INNER JOIN Names as m ON m.AirlineId = c.Name_AirlinenId ");
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                int airlineId = rs.getInt(1);
                String Name  = rs.getString(2);
                String Airplane = rs.getString(3);
                long Rating = rs.getLong(4);
                Airline airline = new Airline();
                airline.setAirlineId(airlineId);
                airline.setName(Name);
                airline.setAirplane(Airplane);
                airline.setRating(Rating);
                        allAirline.add(airline);
            }
        } catch (SQLException var11) {
            var11.printStackTrace();
        }

        return allAirline;
    }

    private java.sql.Connection getConnection() {
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




