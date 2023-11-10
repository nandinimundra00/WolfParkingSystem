package WolfParkingSystem.APIs;

import WolfParkingSystem.Classes.VehiclePermitZone;
import WolfParkingSystem.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiclePermitZoneAPI {

    public VehiclePermitZone getVehiclePermitZone(String carLicenseNumber, String zoneID, int lotID) {
        VehiclePermitZone vehiclePermitZone = null;
        String sql = "SELECT CarLicenseNumber, PermitID, ZoneID, LotID FROM VehiclePermitZone WHERE CarLicenseNumber = ? AND ZoneID = ? AND LotID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, carLicenseNumber);
            statement.setString(2, zoneID);
            statement.setInt(3, lotID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                vehiclePermitZone = new VehiclePermitZone();
                vehiclePermitZone.setCarLicenseNumber(resultSet.getString("CarLicenseNumber"));
                vehiclePermitZone.setPermitID(resultSet.getInt("PermitID"));
                vehiclePermitZone.setZoneID(resultSet.getString("ZoneID"));
                vehiclePermitZone.setLotID(resultSet.getInt("LotID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiclePermitZone;
    }

    public List<VehiclePermitZone> getAllVehiclePermitZones() {
        List<VehiclePermitZone> vehiclePermitZones = new ArrayList<>();
        String sql = "SELECT CarLicenseNumber, PermitID, ZoneID, LotID FROM VehiclePermitZone";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                VehiclePermitZone vehiclePermitZone = new VehiclePermitZone();
                vehiclePermitZone.setCarLicenseNumber(resultSet.getString("CarLicenseNumber"));
                vehiclePermitZone.setPermitID(resultSet.getInt("PermitID"));
                vehiclePermitZone.setZoneID(resultSet.getString("ZoneID"));
                vehiclePermitZone.setLotID(resultSet.getInt("LotID"));
                vehiclePermitZones.add(vehiclePermitZone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiclePermitZones;
    }

    public boolean insertVehiclePermitZone(VehiclePermitZone vehiclePermitZone) throws SQLException {
        String sql = "INSERT INTO VehiclePermitZone (CarLicenseNumber, PermitID, ZoneID, LotID) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, vehiclePermitZone.getCarLicenseNumber());
            statement.setInt(2, vehiclePermitZone.getPermitID());
            statement.setString(3, vehiclePermitZone.getZoneID());
            statement.setInt(4, vehiclePermitZone.getLotID());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        }

    }

    public boolean updateVehiclePermitZone(VehiclePermitZone vehiclePermitZone) {
        String sql = "UPDATE VehiclePermitZone SET PermitID = ? WHERE CarLicenseNumber = ? AND ZoneID = ? AND LotID = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, vehiclePermitZone.getPermitID());
            statement.setString(2, vehiclePermitZone.getCarLicenseNumber());
            statement.setString(3, vehiclePermitZone.getZoneID());
            statement.setInt(4, vehiclePermitZone.getLotID());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteVehiclePermitZone(String carLicenseNumber, String zoneID, int lotID) {
        String sql = "DELETE FROM VehiclePermitZone WHERE CarLicenseNumber = ? AND ZoneID = ? AND LotID = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, carLicenseNumber);
            statement.setString(2, zoneID);
            statement.setInt(3, lotID);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

