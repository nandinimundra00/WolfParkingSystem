package WolfParkingSystem.Menu;
import java.util.Scanner;
import java.sql.SQLException;

import WolfParkingSystem.APIs.*;
import WolfParkingSystem.Classes.*;
import WolfParkingSystem.DBConnection;

public class MaintainingMetadata {
	
	public MaintainingMetadata() {
		
	}
	
	public void operations() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
//        DriverAPI dr = null;
//        ParkingLotAPI pk = null; 
//        VehicleAPI v = null; 
//        ZoneAPI z = null; 
//        SpaceAPI s = null;
//        PermitAPI p = null;
//        CitationAPI c = null;
        VehiclePermitZoneAPI vpz = null;
        while (!quit) {
            System.out.println("Select an option:");
            System.out.println("1) Assign/Enter vehicle and permit information");
            System.out.println("2) Update permit information");
            System.out.println("3) Add vehicle information");
            System.out.println("4) Add vehicle ownership information");
            System.out.println("5) Remove vehicle ownership information");
            System.out.println("6) Update vehicle information");
            System.out.println("7) Delete vehicle information");
            System.out.println("8) Quit");

            int choice = scanner.nextInt();

            switch (choice) {
//                case 1:
//                    System.out.println("You selected Assign/Enter vehicle and permit information");
//                    vpz = new VehiclePermitZone();
//                    
//                    break;
	            case 1:
	                System.out.println("You selected Assign/Enter vehicle and permit information");
	
	                System.out.print("Enter Car License Number: ");
	                String carLicenseNumber = scanner.next();
	
	                System.out.print("Enter Permit ID: ");
	                int permitID = scanner.nextInt();
	
	                System.out.print("Enter Zone ID: ");
	                String zoneID = scanner.next();
	
	                System.out.print("Enter Parking Lot ID: ");
	                int lotID = scanner.nextInt();
	
	                try {
	                    vpz = new VehiclePermitZoneAPI();
	                    VehiclePermitZone vehiclePermitZone = new VehiclePermitZone(carLicenseNumber, permitID, zoneID, lotID);
	                    boolean success = vpz.insertVehiclePermitZone(vehiclePermitZone);
	
	                    if (success) {
	                        System.out.println("Vehicle and permit information assigned successfully.");
	                    } else {
	                        System.out.println("Failed to assign vehicle and permit information. Please try again.");
	                    }
	
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	                break;

                case 2:
                    System.out.println("You selected Update permit information");
                    // Implement your code for updating permit information here
                    break;
                case 3:
                    System.out.println("You selected Add vehicle information");
                    // Implement your code for adding vehicle information here
                    break;
                case 4:
                    System.out.println("You selected Add vehicle ownership information");
                    // Implement your code for adding vehicle ownership information here
                    break;
                case 5:
                    System.out.println("You selected Remove vehicle ownership information");
                    // Implement your code for removing vehicle ownership information here
                    break;
                case 6:
                    System.out.println("You selected Update vehicle information");
                    // Implement your code for updating vehicle information here
                    break;
                case 7:
                    System.out.println("You selected Delete vehicle information");
                    // Implement your code for deleting vehicle information here
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
