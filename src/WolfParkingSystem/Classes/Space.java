package WolfParkingSystem.Classes;

public class Space {
    private int spaceNumber;
    private String zoneID;
    private int lotID;
    private String spaceID;
    private String spaceType;
    private boolean availabilityStatus;

    public Space() {
    }

    public Space(int spaceNumber, String zoneID, int lotID, String spaceType, boolean availabilityStatus) {
        this.spaceNumber = spaceNumber;
        this.zoneID = zoneID;
        this.lotID = lotID;
        this.spaceType = spaceType;
        this.availabilityStatus = availabilityStatus;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(int spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public String getZoneID() {
        return zoneID;
    }

    public void setZoneID(String zoneID) {
        this.zoneID = zoneID;
    }

    public int getLotID() {
        return lotID;
    }

    public void setLotID(int lotID) {
        this.lotID = lotID;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
