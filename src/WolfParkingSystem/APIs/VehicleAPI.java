package WolfParkingSystem.APIs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import WolfParkingSystem.Classes.Vehicle;
import WolfParkingSystem.DBConnection;

public class VehicleAPI {
    private Connection connection;

    public VehicleAPI(Connection connection) {
        this.connection = connection;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String carLicenseNumber = rs.getString("CarLicenseNumber");
                String model = rs.getString("Model");
                String color = rs.getString("Color");
                String manufacturer = rs.getString("Manufacturer");
                int year = rs.getInt("Year");
                vehicles.add(new Vehicle(carLicenseNumber, model, color, manufacturer, year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public Vehicle getVehicleByLicenseNumber(String carLicenseNumber) {
        String sql = "SELECT * FROM Vehicle WHERE CarLicenseNumber = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, carLicenseNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String model = rs.getString("Model");
                    String color = rs.getString("Color");
                    String manufacturer = rs.getString("Manufacturer");
                    int year = rs.getInt("Year");
                    return new Vehicle(carLicenseNumber, model, color, manufacturer, year);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertVehicle(Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO Vehicle (CarLicenseNumber, Model, Color, Manufacturer, Year) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getCarLicenseNumber());
            stmt.setString(2, vehicle.getModel());
            stmt.setString(3, vehicle.getColor());
            stmt.setString(4, vehicle.getManufacturer());
            stmt.setInt(5, vehicle.getYear());
            int rowsAffected = stmt.executeUpdate();
            return (rowsAffected == 1);
        }
    }

    public int updateVehicle(String carLicenseNumber, String model, String color, String manufacturer, int year) throws SQLException {
        String sql = "UPDATE Vehicle SET Model = ?, Color = ?, Manufacturer = ?, Year = ? WHERE CarLicenseNumber = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, model);
            stmt.setString(2, color);
            stmt.setString(3, manufacturer);
            stmt.setInt(4, year);
            stmt.setString(5, carLicenseNumber);
            return stmt.executeUpdate();
        }
    }

    public boolean deleteVehicle(String carLicenseNumber) {
        String sql = "DELETE FROM Vehicle WHERE CarLicenseNumber = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, carLicenseNumber);
            int rowsAffected = stmt.executeUpdate();
            return (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
