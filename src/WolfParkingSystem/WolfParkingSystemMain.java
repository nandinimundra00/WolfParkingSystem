package WolfParkingSystem;

import java.util.Scanner;
import WolfParkingSystem.Menu.*;
import WolfParkingSystem.DBConnection;

public class WolfParkingSystemMain {
    public static void main(String[] args) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            System.out.println("Select an option:");
            System.out.println("1) Information Processing");
            System.out.println("2) Maintaining permits and vehicle information for each driver");
            System.out.println("3) Generating and maintaining citations");
            System.out.println("4) Reports");
            System.out.println("5) Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected Information Processing");
                    InformationProcessing ip = new InformationProcessing();
                    ip.operations();
                    break;
                case 2:
                    System.out.println("You selected Maintaining permits and vehicle information for each driver");
                    MaintainingMetadata mm = new MaintainingMetadata();
                    
                    break;
                case 3:
                    System.out.println("You selected Generating and maintaining citations");
                    MaintainingCitations mc = new MaintainingCitations();
                    break;
                case 4:
                    System.out.println("You selected Reports");
                    Reports r = new Reports();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    DBConnection.close();
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        scanner.close();
    }
}
