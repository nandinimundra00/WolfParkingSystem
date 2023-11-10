package WolfParkingSystem.Classes;

public class VehiclePermitZone {
    private String carLicenseNumber;
    private int permitID;
    private String zoneID;
    private int lotID;

    public VehiclePermitZone() {
    }

    public VehiclePermitZone(String carLicenseNumber, int permitID, String zoneID, int lotID) {
        this.carLicenseNumber = carLicenseNumber;
        this.permitID = permitID;
        this.zoneID = zoneID;
        this.lotID = lotID;
    }

    public String getCarLicenseNumber() {
        return carLicenseNumber;
    }

    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    public int getPermitID() {
        return permitID;
    }

    public void setPermitID(int permitID) {
        this.permitID = permitID;
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
