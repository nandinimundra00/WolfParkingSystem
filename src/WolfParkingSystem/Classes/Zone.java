package WolfParkingSystem.Classes;
public class Zone {
    private String zoneID;
    private int lotID;

    public Zone() {
    }

    public Zone(String zoneID, int lotID) {
        this.zoneID = zoneID;
        this.lotID = lotID;
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
}
