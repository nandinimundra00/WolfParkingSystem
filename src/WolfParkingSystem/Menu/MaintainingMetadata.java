package WolfParkingSystem.Menu;
import java.util.Scanner;
public class MaintainingMetadata {
	
	public MaintainingMetadata() {
		
	}
	
	public void operations() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            System.out.println("Select an option:");
            System.out.println("1) Enter permit information");
            System.out.println("2) Update permit information");
            System.out.println("3) Add vehicle information");
            System.out.println("4) Add vehicle ownership information");
            System.out.println("5) Remove vehicle ownership information");
            System.out.println("6) Update vehicle information");
            System.out.println("7) Delete vehicle information");
            System.out.println("8) Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected Enter permit information");
                    
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
