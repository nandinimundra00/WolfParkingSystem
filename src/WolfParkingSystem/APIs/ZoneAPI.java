package WolfParkingSystem.APIs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import WolfParkingSystem.Classes.Zone;
import WolfParkingSystem.DBConnection;

public class ZoneAPI {
    public ZoneAPI() {
        // Initialize the database connection or connection pool here
    }

    public List<Zone> getAllZones() {
        List<Zone> zones = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT ZoneID, LotID FROM Zone";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Zone zone = new Zone();
                zone.setZoneID(resultSet.getString("ZoneID"));
                zone.setLotID(resultSet.getInt("LotID"));
                zones.add(zone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zones;
    }

    public Zone getZone(String zoneID, int lotID) {
        Zone zone = null;
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT ZoneID, LotID FROM Zone WHERE ZoneID = ? AND LotID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, zoneID);
            statement.setInt(2, lotID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                zone = new Zone();
                zone.setZoneID(resultSet.getString("ZoneID"));
                zone.setLotID(resultSet.getInt("LotID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zone;
    }

    public boolean insertZone(Zone zone) throws SQLException {
        String sql = "INSERT INTO Zone (ZoneID, LotID) VALUES (?, ?)";
        Connection connection = DBConnection.getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, zone.getZoneID());
            stmt.setInt(2, zone.getLotID());
            int rowsAffected = stmt.executeUpdate();
            return (rowsAffected == 1);
        } catch (SQLException e) {
            throw e;
        }
    }

    public boolean updateZone(String oldZoneID, int lotID, String newZoneID) throws SQLException {
        String sql = "UPDATE Zone SET ZoneID = ? WHERE ZoneID = ? AND LotID = ?";
        Connection connection = DBConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newZoneID);
            statement.setString(2, oldZoneID);
            statement.setInt(3, lotID);
            int rowsAffected = statement.executeUpdate();
            return (rowsAffected == 1);
        }
    }


    //we need to delete space as well here?
    public boolean deleteZone(String zoneID, int lotID) throws SQLException {
        String sql = "DELETE FROM Zone WHERE ZoneID = ? AND LotID = ?";
        Connection connection = DBConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, zoneID);
            statement.setInt(2, lotID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
