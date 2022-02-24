package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connect {

    private static final String URL = "jdbc:mysql://localhost:3306/Airport";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "12345";

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void connection() {
        Connection connection;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Correct connection to db!");
            }

            connection.close();

            if (connection.isClosed()) {
                System.out.println("Connection closed :(");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

