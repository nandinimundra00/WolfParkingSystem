package WolfParkingSystem.Classes;
import java.sql.Date;

public class Driver {
    private String driverID;
    private String driverName;
    private String status;

    // Empty constructor
    public Driver() {
    }

    // Constructor with parameters
    public Driver(String driverID, String driverName, String status) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.status = status;
    }

    // Getters and Setters
    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
