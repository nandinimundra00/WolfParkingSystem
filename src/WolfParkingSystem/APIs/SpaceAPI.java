package WolfParkingSystem.APIs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import WolfParkingSystem.Classes.Space;
import WolfParkingSystem.DBConnection;

public class SpaceAPI {

    public List<Space> getAllSpaces() {
        List<Space> spaces = new ArrayList<>();
        String sql = "SELECT SpaceNumber, ZoneID, LotID, SpaceType, AvailabilityStatus FROM Space";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Space space = new Space();
                space.setSpaceNumber(resultSet.getInt("SpaceNumber"));
                space.setZoneID(resultSet.getString("ZoneID"));
                space.setLotID(resultSet.getInt("LotID"));
                space.setSpaceType(resultSet.getString("SpaceType"));
                space.setAvailabilityStatus(resultSet.getBoolean("AvailabilityStatus"));
                spaces.add(space);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spaces;
    }
    
    public Space getSpace(int spaceNumber, String zoneID, int lotID) {
        Space space = null;
        String sql = "SELECT SpaceNumber, ZoneID, LotID, SpaceType, AvailabilityStatus FROM Space WHERE SpaceNumber = ? AND ZoneID = ? AND LotID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, spaceNumber);
            statement.setString(2, zoneID);
            statement.setInt(3, lotID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                space = new Space();
                space.setSpaceNumber(resultSet.getInt("SpaceNumber"));
                space.setZoneID(resultSet.getString("ZoneID"));
                space.setLotID(resultSet.getInt("LotID"));
                space.setSpaceType(resultSet.getString("SpaceType"));
                space.setAvailabilityStatus(resultSet.getBoolean("AvailabilityStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return space;
    }


    // Insert space into the database
    public boolean insertSpace(Space space) throws SQLException {
        String sql = "INSERT INTO Space (SpaceNumber, ZoneID, LotID, SpaceType, AvailabilityStatus) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, space.getSpaceNumber());
            statement.setString(2, space.getZoneID());
            statement.setInt(3, space.getLotID());
            statement.setString(4, space.getSpaceType());
            statement.setBoolean(5, space.isAvailabilityStatus());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        }
    }
    // Update space in the database
    public boolean updateSpace(Space space) throws SQLException {
        String sql = "UPDATE Space SET SpaceNumber = ?, ZoneID = ?, LotID = ?, SpaceType = ?, AvailabilityStatus = ? WHERE SpaceNumber = ? AND ZoneID = ? AND LotID = ?";
        Connection connection = DBConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

        	statement.setInt(1, space.getSpaceNumber());
            statement.setString(2, space.getZoneID());
            statement.setInt(3, space.getLotID());
            statement.setString(4, space.getSpaceType());
            statement.setBoolean(5, space.isAvailabilityStatus());
            statement.setInt(6, space.getSpaceNumber());
            statement.setString(7, space.getZoneID());
            statement.setInt(8, space.getLotID());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        }
    }

    // Delete space from the database
    public boolean deleteSpace(int spaceNumber, String zoneID, int lotID) throws SQLException {
        String sql = "DELETE FROM Space WHERE SpaceNumber = ? AND ZoneID = ? AND LotID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, spaceNumber);
            statement.setString(2, zoneID);
            statement.setInt(3, lotID);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
