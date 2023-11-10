package WolfParkingSystem.Classes;
public class ParkingLot {
    private int lotID;
    private String name;
    private String address;

    public ParkingLot() {
        // Empty constructor
    }

    public ParkingLot(int lotID, String name, String address) {
        this.lotID = lotID;
        this.name = name;
        this.address = address;
    }

    public int getLotID() {
        return lotID;
    }

    public void setLotID(int lotID) {
        this.lotID = lotID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
