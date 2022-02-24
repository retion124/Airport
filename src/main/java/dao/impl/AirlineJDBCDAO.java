package dao.impl;

import dao.DAOAirline;
import entity.Airline;
import org.jetbrains.annotations.NotNull;

import java.sql.*;

 public class AirlineJDBCDAO implements DAOAirline {
@Override
    public void add(@NotNull Airline airline) {
        Connection connection = null;

        connection = getConnection();
        PreparedStatement statement;


            statement = connection.prepareStatement("INSERT INTO Airline (name, airplane, rating) VALUES (?, ?, ?)");

            statement.setString(1,airline.getName());
            statement.setString(2, );
            statement.setInt(3, car.getPrice());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop", "root", "12345");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
