package dao.impl;

import com.sun.jdi.connect.spi.Connection;

import dao.PassengersDAO;
import entity.Passengers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengersJDBCDAO implements PassengersDAO {
    public PassengersJDBCDAO(){

        }

        @Override
        public void add(Passengers passengers) {
            Connection connection = null;
            connection = (Connection) this.getConnection();
            try {
                int PassengersId = this.getPassengersId(passengers.getPassengersName(), (java.sql.Connection) connection);
                PreparedStatement statement;
                if (PassengersId == -1) {
                    statement = ((java.sql.Connection) connection).prepareStatement("INSERT INTO PassengersId(passengersId) VALUES (?)");
                    statement.setInt(1, passengers.getPassengersId());
                    statement.execute();
                    statement = ((java.sql.Connection) connection).prepareStatement("SELECT MAX(id) FROM PassengersId");
                    ResultSet rs = statement.executeQuery();
                    rs.next();
                    PassengersId= rs.getInt(1);
                }
                statement = ((java.sql.Connection) connection).prepareStatement("INSERT INTO Passengers(PassengersId ,PassengersName ,Passport , Age, Phone, Tiskit, VALUES (?, ?, ?, ?, ?, ?, )");
                statement.setInt(1, PassengersId);
                statement.setString(2,passengers.getPassengersName());
                statement.setString(3,passengers.getPassport());
                statement.setInt(4, passengers.getAge());
                statement.setInt(5, passengers.getPhone());
                statement.setInt(6, passengers.getTiskit());
                statement.execute();
            } catch (SQLException var6) {
                var6.printStackTrace();
            }
        }


        private int getPassengersId(String PassengersName , java.sql.@NotNull Connection connection){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT PassengersId FROM PassengersNames WHERE PassengersName = ? ");
                preparedStatement.setString(1, PassengersName);
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
        public List<Passengers> getAll() {
            List<Passengers> allPassengers = new ArrayList();
            java.sql.Connection connection = null;
            PreparedStatement statement = null;

            try {
                connection = this.getConnection();
                statement = connection.prepareStatement("SELECT c.PassengersId, m.PassengersName, c.Passport, c.Age ,c.Phone , c.Tiskit FROM Passengers as c INNER JOIN PassengersName as m ON m.PassengersId  = c.PassengersName_PassengersId  ");
                ResultSet rs = statement.executeQuery();
                while(rs.next()) {
                    int PassengersId  = rs.getInt(1);
                    String PassengersName = rs.getString(2);
                    String Passport = rs.getString(3);
                    int Age = rs.getInt(4);
                    int Phone = rs.getInt(5);
                    int Tiskit = rs.getInt(6);
                    Passengers  passengers  = new  Passengers();
                    passengers.setPassengersId(PassengersId);
                    passengers.setPassengersName(PassengersName);
                    passengers.setPassport(Passport);
                    passengers.setAge(Age);
                    passengers.setPhone(Phone);
                    passengers.setTiskit(Tiskit);
                    allPassengers.add(passengers);
                }
            } catch (SQLException var11) {
                var11.printStackTrace();
            }

            return allPassengers;
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
