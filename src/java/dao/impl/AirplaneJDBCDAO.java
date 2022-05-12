package dao.impl;

import com.sun.jdi.connect.spi.Connection;
import dao.AirplaneDAO;
import entity.Airplane;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneJDBCDAO implements AirplaneDAO {
    public AirplaneJDBCDAO(){

    }

    @Override
    public void add( Airplane airplane) {
        Connection connection = null;
        connection = (Connection) this.getConnection();
        try {
            int AirplaneId = this.getAirplaneId(airplane.getModel(), (java.sql.Connection) connection);
            PreparedStatement statement;
            if (AirplaneId == -1) {
                statement = ((java.sql.Connection) connection).prepareStatement("INSERT INTO AirplaneId(airplaneId) VALUES (?)");
                statement.setInt(1, airplane.getAirplaneId());
                statement.execute();
                statement = ((java.sql.Connection) connection).prepareStatement("SELECT MAX(id) FROM AirplaneId");
                ResultSet rs = statement.executeQuery();
                rs.next();
                AirplaneId = rs.getInt(1);
            }
            statement = ((java.sql.Connection) connection).prepareStatement( "INSERT INTO airplane(AirplaneId,Model, NumberPassengers, Airline, Pilot, Stewardess) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, AirplaneId);
            statement.setString(2, airplane.getModel());
            statement.setInt(3, airplane.getNumberPassengers());
            statement.setString(4, airplane.getAirline());
            statement.setString(5, airplane.getPilot());
            statement.setString(6, airplane.getStewardess());
            statement.execute();
        } catch (SQLException var6) {
            var6.printStackTrace();

        }
    }
    private int getAirplaneId(String Model, java.sql.@NotNull Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT AirplaneId FROM Models WHERE Model = ? ");
            preparedStatement.setString(1,Model);
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
    public List<Airplane> getAll() {
        List<Airplane> allAirplane = new ArrayList();
        java.sql.Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = this.getConnection();
            statement = connection.prepareStatement("SELECT c.AirplaneId, m.Mode, c.NumberPassengers, c.Airline ,c.Pilot , c.PilotStewardess FROM Airplane as c INNER JOIN Models as m ON m.AirplaneId = c.Model_AirplaneId ");
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                int AirplaneId = rs.getInt(1);
                String Model  = rs.getString(2);
                int NumberPassengers= rs.getInt(3);
                String Airline = rs.getString(4);
                String Pilot = rs.getString(5);
                String Stewardess= rs.getString(6);
                Airplane airplane = new Airplane();
                airplane.setAirplaneId(AirplaneId);
                airplane.setModel(Model);
                airplane.setNumberPassengers(NumberPassengers);
                airplane.setAirline(Airline);
                airplane.setPilot(Pilot);
                airplane.setStewardess(Stewardess);
                allAirplane.add(airplane);
            }
        } catch (SQLException var11) {
            var11.printStackTrace();
        }

        return allAirplane;
    }

    @Override
    public void remove(int AirplaneId) {

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
