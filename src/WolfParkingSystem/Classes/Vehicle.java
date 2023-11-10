package WolfParkingSystem.Classes;
public class Vehicle {
    private String carLicenseNumber;
    private String model;
    private String color;
    private String manufacturer;
    private int year;

    public Vehicle() {
        // Empty constructor
    }

    public Vehicle(String carLicenseNumber, String model, String color, String manufacturer, int year) {
        this.carLicenseNumber = carLicenseNumber;
        this.model = model;
        this.color = color;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    public String getCarLicenseNumber() {
        return carLicenseNumber;
    }

    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
