package WolfParkingSystem.APIs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import WolfParkingSystem.Classes.ParkingLot;
import WolfParkingSystem.DBConnection;
public class ParkingLotAPI {
    public ParkingLotAPI() {
        // Initialize the database connection or connection pool here
    }

    public List<ParkingLot> getAllParkingLots() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT LotID, Name, Address FROM ParkingLot";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ParkingLot parkingLot = new ParkingLot();
                parkingLot.setLotID(resultSet.getInt("LotID"));
                parkingLot.setName(resultSet.getString("Name"));
                parkingLot.setAddress(resultSet.getString("Address"));
                parkingLots.add(parkingLot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkingLots;
    }

    public ParkingLot getParkingLotById(int lotID) {
        ParkingLot parkingLot = null;
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT LotID, Name, Address FROM ParkingLot WHERE LotID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, lotID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                parkingLot = new ParkingLot();
                parkingLot.setLotID(resultSet.getInt("LotID"));
                parkingLot.setName(resultSet.getString("Name"));
                parkingLot.setAddress(resultSet.getString("Address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkingLot;
    }

    public boolean insertParkingLot(ParkingLot parkingLot) throws SQLException {
        String sql = "INSERT INTO ParkingLot (Name, Address) VALUES (?, ?)";
        Connection connection = DBConnection.getConnection();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, parkingLot.getName());
            stmt.setString(2, parkingLot.getAddress());
            int rowsAffected = stmt.executeUpdate();
            return (rowsAffected == 1);
        } catch (SQLException e) {
            throw e;
        }
    }

    public int updateParkingLot(int lotID, String name, String address) throws SQLException {
        String sql = "UPDATE ParkingLot SET Name = ?, Address = ? WHERE LotID = ?";
        Connection connection = DBConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2,  address);
            statement.setInt(3, lotID);
            return statement.executeUpdate();
        }
    }

    public boolean deleteParkingLot(int lotID) throws SQLException {
        String sql = "DELETE FROM ParkingLot WHERE LotID = ?";
        Connection connection = DBConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, lotID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }
}
