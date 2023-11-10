package WolfParkingSystem.Classes;

import java.sql.Date;
import java.sql.Time;

public class Permit {
    private int permitID;
    private String permitType;
    private Date expirationDate;
    private Time expirationTime;
    private Date startDate;
    private String spaceType;

    public Permit() {
    }

    public Permit(int permitID, String permitType, Date expirationDate, Time expirationTime, Date startDate, String spaceType) {
        this.permitID = permitID;
        this.permitType = permitType;
        this.expirationDate = expirationDate;
        this.expirationTime = expirationTime;
        this.startDate = startDate;
        this.spaceType = spaceType;
    }

    public int getPermitID() {
        return permitID;
    }

    public void setPermitID(int permitID) {
        this.permitID = permitID;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Time getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Time expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }
}
