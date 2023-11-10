package WolfParkingSystem.APIs;

import WolfParkingSystem.Classes.Permit;
import WolfParkingSystem.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class PermitAPI {
    public List<Permit> getAllPermits() {
        List<Permit> permits = new ArrayList<>();
        String sql = "SELECT PermitID, PermitType, ExpirationDate, ExpirationTime, StartDate, SpaceType FROM Permit";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Permit permit = new Permit();
                permit.setPermitID(resultSet.getInt("PermitID"));
                permit.setPermitType(resultSet.getString("PermitType"));
                permit.setExpirationDate(resultSet.getDate("ExpirationDate"));
                permit.setExpirationTime(resultSet.getTime("ExpirationTime"));
                permit.setStartDate(resultSet.getDate("StartDate"));
                permit.setSpaceType(resultSet.getString("SpaceType"));
                permits.add(permit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permits;
    }

    public Permit getPermitById(int permitID) {
        Permit permit = null;
        String sql = "SELECT PermitID, PermitType, ExpirationDate, ExpirationTime, StartDate, SpaceType FROM Permit WHERE PermitID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, permitID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                permit = new Permit();
                permit.setPermitID(resultSet.getInt("PermitID"));
                permit.setPermitType(resultSet.getString("PermitType"));
                permit.setExpirationDate(resultSet.getDate("ExpirationDate"));
                permit.setExpirationTime(resultSet.getTime("ExpirationTime"));
                permit.setStartDate(resultSet.getDate("StartDate"));
                permit.setSpaceType(resultSet.getString("SpaceType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permit;
    }

    public boolean insertPermit(String permitType, Date expirationDate, Time expirationTime, Date startDate, String spaceType) throws SQLException {
        String sql = "INSERT INTO Permit (PermitType, ExpirationDate, ExpirationTime, StartDate, SpaceType) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, permitType);
            statement.setDate(2, expirationDate);
            statement.setTime(3, expirationTime);
            statement.setDate(4, startDate);
            statement.setString(5, spaceType);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
        	throw e;
        }
    }

//    public boolean updatePermit(int permitID, String permitType, Date expirationDate, Time expirationTime, Date startDate, String spaceType) throws SQLException {
//        String sql = "UPDATE Permit SET PermitType = ?, ExpirationDate = ?, ExpirationTime = ?, StartDate = ?, SpaceType = ? WHERE PermitID = ?";
//        try (Connection connection = DBConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql)) {
//
//            statement.setString(1, permitType);
//            statement.setDate(2, expirationDate);
//            statement.setTime(3, expirationTime);
//            statement.setDate(4, startDate);
//            statement.setString(5, spaceType);
//            statement.setInt(6, permitID);
//
//            int rowsAffected = statement.executeUpdate();
//            return rowsAffected == 1;
//        } catch (SQLException e) {
//        	throw e;
//        }
//    }
    public boolean updatePermit(int permitID, String permitType, Date expirationDate, Time expirationTime, Date startDate, String spaceType) throws SQLException {
        String sql = "UPDATE Permit SET PermitType = ?, ExpirationDate = ?, ExpirationTime = ?, StartDate = ?, SpaceType = ? WHERE PermitID = ?";
        Connection connection = DBConnection.getConnection();
        
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, permitType);
            statement.setDate(2, expirationDate);
            statement.setTime(3, expirationTime);
            statement.setDate(4, startDate);
            statement.setString(5, spaceType);
            statement.setInt(6, permitID);
            System.out.println("3 " + DBConnection.getConnection());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch  (SQLException e)  {
        	System.out.println("Error updating permit information: " + e.getMessage());
        	throw e;
        }
    }

    public boolean deletePermit(int permitID) throws SQLException {
        String sql = "DELETE FROM Permit WHERE PermitID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, permitID);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
