package WolfParkingSystem.APIs;

import WolfParkingSystem.DBConnection;
import WolfParkingSystem.Classes.Citation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitationAPI {

    public List<Citation> getAllCitations() {
        List<Citation> citations = new ArrayList<>();
        String sql = "SELECT * FROM Citation";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Citation citation = mapResultSetToCitation(resultSet);
                citations.add(citation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citations;
    }

    public Citation getCitationByNumber(int citationNumber) {
        Citation citation = null;
        String sql = "SELECT * FROM Citation WHERE CitationNumber = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, citationNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                citation = mapResultSetToCitation(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citation;
    }

    public boolean insertCitation(Citation citation) {
        String sql = "INSERT INTO Citation (CitationDate, CitationTime, Amount, PaymentStatus) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, citation.getCitationDate());
            statement.setTime(2, citation.getCitationTime());
            statement.setDouble(3, citation.getAmount());
            statement.setString(4, citation.getPaymentStatus());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCitation(Citation citation) {
        String sql = "UPDATE Citation SET CitationDate = ?, CitationTime = ?, Amount = ?, PaymentStatus = ? WHERE CitationNumber = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, citation.getCitationDate());
            statement.setTime(2, citation.getCitationTime());
            statement.setDouble(3, citation.getAmount());
            statement.setString(4, citation.getPaymentStatus());
            statement.setInt(5, citation.getCitationNumber());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCitation(int citationNumber) {
        String sql = "DELETE FROM Citation WHERE CitationNumber = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, citationNumber);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Citation mapResultSetToCitation(ResultSet resultSet) throws SQLException {
        Citation citation = new Citation();
        citation.setCitationNumber(resultSet.getInt("CitationNumber"));
        citation.setCitationDate(resultSet.getDate("CitationDate"));
        citation.setCitationTime(resultSet.getTime("CitationTime"));
        citation.setAmount(resultSet.getDouble("Amount"));
        citation.setPaymentStatus(resultSet.getString("PaymentStatus"));
        return citation;
    }
    
    public boolean appealCitation(int citationNumber) throws SQLException {
        String sql = "UPDATE Citation SET PaymentStatus = 'Invalid Citation' WHERE CitationNumber = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, citationNumber);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        }
    }
 
    public boolean updateCitationPaymentStatus(int citationNumber) throws SQLException {
        String sql = "UPDATE Citation SET PaymentStatus = 'Paid' WHERE CitationNumber = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, citationNumber);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        }
    }

    
}
