package WolfParkingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;
  
    static
    {
        String url = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/nmundra";
        String user = "nmundra";
        String password = "200475534";
        try {
        connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to database", e);
        }
    }

    public static Connection getConnection()
    {
        return connection;
    }

    public static void close() {
       try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
       }

}
}