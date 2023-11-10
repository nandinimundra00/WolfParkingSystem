package WolfParkingSystem.APIs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import WolfParkingSystem.DBConnection;
import WolfParkingSystem.Classes.Driver;

public class DriverAPI {
    public DriverAPI() {   	
    	//constructor
    }

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        String sql = "SELECT * FROM Driver";
    	Connection connection = DBConnection.getConnection();        
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String driverID = rs.getString("DriverID");
                String driverName = rs.getString("DriverName");
                String status = rs.getString("Status");
                drivers.add(new Driver(driverID, driverName, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    public Driver getDriverById(String driverID) {
        String sql = "SELECT * FROM Driver WHERE DriverID = ?";
        Connection connection = DBConnection.getConnection();  
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, driverID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String driverName = rs.getString("DriverName");
                    String status = rs.getString("Status");
                    return new Driver(driverID, driverName, status);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateDriver(String currentdriverID, String newdriverID, String driverName, String status) throws SQLException {
        String sql = "UPDATE Driver SET DriverID = ?, DriverName = ?, Status = ? WHERE DriverID = ?";
        Connection connection = DBConnection.getConnection();  
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setString(1, newdriverID);
            statement.setString(2, driverName);
            statement.setString(3, status);
            statement.setString(4, currentdriverID);
            return statement.executeUpdate();
        }
    }

    public boolean insertDriver(Driver driver) throws SQLException {
        String sql = "INSERT INTO Driver (DriverID, DriverName, Status) VALUES (?, ?, ?)";
        Connection connection = DBConnection.getConnection();  
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, driver.getDriverID());
            stmt.setString(2, driver.getDriverName());
            stmt.setString(3, driver.getStatus());
            int rowsAffected = stmt.executeUpdate();
            return (rowsAffected == 1);
        }
    }

    public boolean deleteDriver(String driverID) throws SQLException {
        String sql = "DELETE FROM Driver WHERE DriverID = ?";
        Connection connection = DBConnection.getConnection();  
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, driverID);
            int rowsAffected = stmt.executeUpdate();
            return (rowsAffected > 0);
        }
    }
}
