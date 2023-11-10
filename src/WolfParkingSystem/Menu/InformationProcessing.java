package WolfParkingSystem.Menu;

import java.util.Scanner;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

import WolfParkingSystem.APIs.*;
import WolfParkingSystem.Classes.*;
import WolfParkingSystem.DBConnection;

public class InformationProcessing {
	
	public InformationProcessing() {
		//Constructor
	}
	
    public void operations() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        DriverAPI dr = null;
        ParkingLotAPI pk = null; 
        VehicleAPI v = null; 
        ZoneAPI z = null; 
        SpaceAPI s = null;
        PermitAPI p = null;
        CitationAPI c = null;
        while (!quit) {
            System.out.println("Select an option:");
            System.out.println("1) Add driver info");
            System.out.println("2) Update driver info");
            System.out.println("3) Delete driver info");
            System.out.println("4) Add parking lot info");
            System.out.println("5) Update parking lot info");
            System.out.println("6) Delete parking lot info");
            System.out.println("7) Add parking zone");
            System.out.println("8) Update zone info");
            System.out.println("9) Delete zone");
            System.out.println("10) Add space");
            System.out.println("11) Update space");
            System.out.println("12) Delete space");
            System.out.println("13) Add permit info");
            System.out.println("14) Update permit info");
            System.out.println("15) Delete permit info");
            System.out.println("16) Appeal a citation");
            System.out.println("17) Update Citation Payment status");
            System.out.println("18) Quit");

            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("You selected Add driver info");
                    dr = new DriverAPI();

                    System.out.println("Enter Driver Information:");
                    System.out.print("Driver ID: ");
                    String driverID = scanner.next();

                    System.out.print("Driver Name: ");
                    String driverName = scanner.next();

                    System.out.print("Status: ");
                    String status = scanner.next();

                    Driver newDriver = new Driver();
                    newDriver.setDriverID(driverID);
                    newDriver.setDriverName(driverName);
                    newDriver.setStatus(status);
                    
                    try {
                        boolean inserted = dr.insertDriver(newDriver);

                        if (inserted) {
                            System.out.println("Driver information inserted successfully.");
                        } else {
                            System.out.println("Failed to insert driver information.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }                   
                    
                    break;
                case 2:
                	dr = new DriverAPI();
                    System.out.println("You selected Update driver info");
                    System.out.println("Enter the driver ID for which you want to update the information");
                    String currentDriverID = scanner.next();
                    System.out.print("Driver ID: ");
                    String newDriverID = scanner.next();
                    System.out.print("New Driver Name: ");
                    String updateDriverName = scanner.next();
                    System.out.print("Status: ");
                    String updateStatus = scanner.next();
                    try {
                        int rowsAffected = dr.updateDriver(currentDriverID, newDriverID, updateDriverName, updateStatus);

                        if (rowsAffected > 0) {
                            System.out.println("Driver information updated successfully.");
                        } else {
                            System.out.println("Failed to update driver information. No records were affected.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                    
                case 3:
                    System.out.println("You selected Delete driver info");
                    System.out.println("Enter the driver ID that you want to delete: "); 
                    String deleteDriverID = scanner.next(); 
                    try {
                    	dr = new DriverAPI(); 
                    	boolean deletedDriver = dr.deleteDriver(deleteDriverID);
                    	if(deletedDriver) {
                    		System.out.println("Driver deleted successfully."); 
                    	} else {
                    		System.out.println("Error deleting driver with driverID: " + deleteDriverID + "."); 
                    	}
                    } catch (SQLException e) {
                    	e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("You selected Add parking lot info");
                    pk = new ParkingLotAPI(); 
                    System.out.println("Enter the name of the parking lot: "); 
                    String parkingLotName = scanner.next(); 
                    System.out.println("Enter the address of the parking lot: "); 
                    String parkingLotAddress = scanner.next(); 
                    ParkingLot newParkingLot = new ParkingLot();
                    newParkingLot.setName(parkingLotName);
                    newParkingLot.setAddress(parkingLotAddress);
                    try {
                        boolean inserted = pk.insertParkingLot(newParkingLot);

                        if (inserted) {
                            System.out.println("Parking Lot information inserted successfully.");
                        } else {
                            System.out.println("Failed to insert parking lot information.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }  
                    break;
                case 5:
                	pk = new ParkingLotAPI();
                    System.out.println("You selected Update parking lot info");
                    System.out.println("Enter the parking lot ID for which you want to update the information: ");
                    Integer parkingLotID = scanner.nextInt();
                    System.out.println("Enter the name of the parking lot: "); 
                    String updatedParkingLotName = scanner.next(); 
                    System.out.println("Enter the address of the parking lot: "); 
                    String updatedParkingLotAddress = scanner.next(); 
                    try {
                        int rowsAffected = pk.updateParkingLot(parkingLotID, updatedParkingLotName, updatedParkingLotAddress); 

                        if (rowsAffected > 0) {
                            System.out.println("Parking Lot information updated successfully.");
                        } else {
                            System.out.println("Failed to update parking lot information. No records were affected.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("You selected Delete parking lot info");
                    System.out.println("Enter the parking lot ID that you want to delete: "); 
                    Integer deleteParkingLotID = scanner.nextInt();
                    try {
                    	pk = new ParkingLotAPI(); 
                    	boolean deletedParkingLot = pk.deleteParkingLot(deleteParkingLotID); 
                    	if(deletedParkingLot) {
                    		System.out.println("Driver deleted successfully."); 
                    	} else {
                    		System.out.println("Error deleting driver with driverID: " + deleteParkingLotID + "."); 
                    	}
                    } catch (SQLException e) {
                    	e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("You selected Add parking zone");
                    z = new ZoneAPI();
                    System.out.println("Enter the Zone ID");
                    String zoneID = scanner.next();
                    System.out.println("Enter Lot ID");
                    Integer pkID = scanner.nextInt();
                    try {
                    	pk = new ParkingLotAPI();
                    	ParkingLot corrpk = pk.getParkingLotById(pkID);
                    	if(corrpk == null) {
                    		System.out.println("This parking lot ID does not exist");
                    	} else {
                    		Zone newZone = new Zone();
                    		newZone.setLotID(pkID);
                    		newZone.setZoneID(zoneID);
                    		boolean inserted = z.insertZone(newZone);
                    		if (inserted) {
                    			System.out.println("Zone added successfully to parking lot "+ pkID +".");
                    		} else {
                    			System.out.println("Error adding Zone to parking lot "+ pkID + ".");
                    		}
                    	}
                    } catch (SQLException e) {
                    	e.printStackTrace();
                    }
                    break;
                case 8:
                    System.out.println("You selected Update zone info");
                    System.out.println("Enter the parking lot ID");
                    Integer lotID = scanner.nextInt();
                    System.out.println("Enter the zone ID to update");
                    String currentZoneId = scanner.next();
                    System.out.println("Enter the new zone ID");
                    String newZoneId = scanner.next();
                    
                    try {
                    	pk = new ParkingLotAPI();
                    	ParkingLot corrpk = pk.getParkingLotById(lotID);
                    	if(corrpk == null) {
                    		System.out.println("This parking lot ID does not exist");
                    	} else {
	                    	z = new ZoneAPI();
	                    	boolean updatedZone = z.updateZone(currentZoneId, lotID, newZoneId);
	                    	if(updatedZone) {
	                    		System.out.println("Zone updated successfully");
	                    	}
	                    	else {
	                    		System.out.println("Error in updating zone");
	                    	}
                    	}
                    } catch (SQLException e){
                    	e.printStackTrace();
                    }                   
                    break;
                case 9:
                    System.out.println("You selected Delete zone");
                    System.out.println("Enter the parking lot ID");
                    Integer deleteLotID = scanner.nextInt();
                    System.out.println("Enter the zone ID to be deleted");
                    String deleteZoneId = scanner.next();
                    try {
                    	z = new ZoneAPI();
                    	boolean deleteZone = z.deleteZone(deleteZoneId, deleteLotID);
                    	if(deleteZone) {
                    		System.out.println("Zone deleted successfully");
                    	}
                    	else {
                    		System.out.println("Error in deleting zone");
                    	}
                    } catch (SQLException e){
                    	e.printStackTrace();
                    }                   
                    break;
                    
                case 10:
                    System.out.println("You selected Add space");
                    System.out.print("Enter Space Number: ");
                    int spaceNumber = scanner.nextInt();

                    System.out.print("Enter Zone ID: ");
                    String spaceZoneID = scanner.next();

                    System.out.print("Enter Parking Lot ID: ");
                    int spaceLotID = scanner.nextInt();

                    System.out.print("Enter Space Type (Default: Regular): ");
                    String spaceType = scanner.next();

                    System.out.print("Enter Availability Status (1 for True, 0 for False, Default: 1): ");
                    boolean availabilityStatus = scanner.nextInt() == 1;

                    try {
                        SpaceAPI spaceAPI = new SpaceAPI();
                        ParkingLotAPI parkingLotAPI = new ParkingLotAPI();
                        ParkingLot corrpk = parkingLotAPI.getParkingLotById(spaceLotID);

                        if (corrpk == null) {
                            System.out.println("This parking lot ID does not exist");
                            break;
                        }

                        ZoneAPI zoneAPI = new ZoneAPI();
                        Zone zone = zoneAPI.getZone(spaceZoneID, spaceLotID);

                        if (zone == null) {
                            System.out.println("Invalid Zone ID for the given Parking Lot.");
                            break;
                        }

                        Space newSpace = new Space(spaceNumber, spaceZoneID, spaceLotID, spaceType, availabilityStatus);
                        boolean success = spaceAPI.insertSpace(newSpace);

                        if (success) {
                            System.out.println("Space added successfully.");
                        } else {
                            System.out.println("Failed to add space. Please try again.");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                    
                case 11:

                    System.out.println("You selected Update space");
                    System.out.print("Enter Space Number to update: ");
                    int oldSpaceNumber = scanner.nextInt();

                    System.out.print("Enter Zone ID: ");
                    String oldSpaceZoneID = scanner.next();

                    System.out.print("Enter Parking Lot ID: ");
                    int oldSpaceLotID = scanner.nextInt(); 
                    
                    System.out.print("Enter new Space Number to update: ");
                    int spaceNumberToUpdate = scanner.nextInt();


                    System.out.print("Enter New Space Type: ");
                    String newSpaceType = scanner.next();

                    System.out.print("Enter New Availability Status (1 for True, 0 for False): ");
                    boolean newAvailabilityStatus = scanner.nextInt() == 1;

                    try {
                        SpaceAPI spaceAPI = new SpaceAPI();

                        boolean success = spaceAPI.updateSpace(oldSpaceNumber, oldSpaceZoneID, oldSpaceLotID, spaceNumberToUpdate, newSpaceType, newAvailabilityStatus);

                        if (success) {
                            System.out.println("Space updated successfully.");
                        } else {
                            System.out.println("Failed to update space. Please try again.");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;


                case 12:
                    System.out.println("You selected Delete space");
                    System.out.println("Enter the Space number");
                    Integer SpaceNumber = scanner.nextInt();
                    System.out.println("Enter the parking lot ID");
                    Integer SpaceLotID = scanner.nextInt();
                    System.out.println("Enter the zone ID to be deleted");
                    String SpaceZoneId = scanner.next();
                    try {
                    	s = new SpaceAPI();
                    	boolean deleteSpace = s.deleteSpace(SpaceNumber, SpaceZoneId, SpaceLotID);
                    	if(deleteSpace) {
                    		System.out.println("Space deleted successfully");
                    	}
                    	else {
                    		System.out.println("Error in deleting Space");
                    	}
                    } catch (SQLException e){
                    	e.printStackTrace();
                    }      
                    break;
                case 13:
                    System.out.println("You selected Add permit info");
                    
                    System.out.print("Enter Permit Type: ");
                    String permitType = scanner.next();
                    
                    System.out.print("Enter Expiration Date (YYYY-MM-DD): ");
                    String expirationDateString = scanner.next();
                    
                    System.out.print("Enter Expiration Time (HH:MM:SS): ");
                    String expirationTimeString = scanner.next();
                    
                    System.out.print("Enter Start Date (YYYY-MM-DD): ");
                    String startDateString = scanner.next();
                    
                    System.out.print("Enter Space Type: ");
                    String spacePermitType = scanner.next();
                    
                    try {
                        p = new PermitAPI();                      
                        Date expirationDate = Date.valueOf(expirationDateString);
                        Time expirationTime = Time.valueOf(expirationTimeString);
                        Date startDate = Date.valueOf(startDateString);
                        
                        boolean success = p.insertPermit(permitType, expirationDate, expirationTime, startDate, spacePermitType);
                        
                        if (success) {
                            System.out.println("Permit information added successfully.");
                        } else {
                            System.out.println("Failed to add permit information. Please try again.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 14:
                    System.out.println("You selected Update permit info");                                  
                    try {
                        p = new PermitAPI();
//                        Permit existingPermit = p.getPermitById(permitIDToUpdate);
//                        System.out.println(existingPermit);
//                        if (existingPermit == null) {
//                            System.out.println("Permit with Permit ID " + permitIDToUpdate + " does not exist.");
//                        } else {
                        System.out.println("Enter the permit ID");
                        Integer permitID = scanner.nextInt();
                        
                    	System.out.print("Enter New Permit Type: ");
                        String newPermitType = scanner.next();

                        System.out.print("Enter New Expiration Date (YYYY-MM-DD): ");
                        String newExpirationDateStr = scanner.next();
                        Date newExpirationDate = Date.valueOf(newExpirationDateStr);

                        System.out.print("Enter New Expiration Time (HH:MM:SS): ");
                        String newExpirationTimeStr = scanner.next();
                        Time newExpirationTime = Time.valueOf(newExpirationTimeStr);

                        System.out.print("Enter New Start Date (YYYY-MM-DD): ");
                        String newStartDateStr = scanner.next();
                        Date newStartDate = Date.valueOf(newStartDateStr);

                        System.out.print("Enter New Space Permit Type: ");
                        String newSpacePermitType = scanner.next();

                        boolean success = p.updatePermit(
                        		permitID,
                                newPermitType,
                                newExpirationDate,
                                newExpirationTime,
                                newStartDate,
                                newSpacePermitType);

                        if (success) {
                            System.out.println("Permit updated successfully.");
                        } else {
                            System.out.println("Failed to update permit. Please try again.");
                        }                       

                    } catch (SQLException e) {
                    	e.printStackTrace();
                    }
                    break;

                case 15:
                    System.out.println("You selected Delete permit info");
                    p = new PermitAPI();
                    System.out.println("Enter permit ID to be deleted");
                    Integer permitIDToDelete = scanner.nextInt();
                    try {
                    	boolean deletePermit = p.deletePermit(permitIDToDelete);
                    	if (deletePermit) {
                    		System.out.println("Permit deleted successfully");
                    	} else {
                    		System.out.println("Could not delete permit");
                    	}
                    } catch (SQLException e){
                    	e.printStackTrace();
                    }
                    break;
                case 16:
                    System.out.println("You selected Appeal a citation");
                    System.out.print("Enter Citation Number to appeal: ");
                    int citationNumberToAppeal = scanner.nextInt();
                    try {
                        c = new CitationAPI();
                        boolean success = c.appealCitation(citationNumberToAppeal);

                        if (success) {
                        	System.out.println("Citation applealed successfully");
                        } else {
                            System.out.println("Failed to appeal citation. Please try again.");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 17:
                    System.out.println("You selected Update Citation Payment status");
                    System.out.print("Enter Citation Number to update the payment status of: ");
                    int citationNumberToUpdate = scanner.nextInt();
                    try {
                    	c = new CitationAPI();
                    	boolean success = c.updateCitationPaymentStatus(citationNumberToUpdate);
                        if (success) {
                        	System.out.println("Citation payment status updated successfully");
                        } else {
                            System.out.println("Failed to update citation payment status. Please try again.");
                        }
                    	
                    } catch (SQLException e) {
                    	e.printStackTrace();
                    }
                    break;
                    
                case 18:
                    System.out.println("Goodbye!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }


    }
}
