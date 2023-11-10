package WolfParkingSystem.Menu;
import java.util.Scanner;

public class MaintainingCitations {
	public MaintainingCitations() {
		
	}
    public void operation() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        while (!quit) {
            System.out.println("Select an option:");
            System.out.println("1) Check a valid permit");
            System.out.println("2) Create citation information");
            System.out.println("3) Update citation payment status");
            System.out.println("4) Delete citation information");
            System.out.println("5) Create citation appeal");
            System.out.println("6) Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected Check a valid permit");
                    // Implement your code to check a valid permit here
                    break;
                case 2:
                    System.out.println("You selected Create citation information");
                    // Implement your code to create citation information here
                    break;
                case 3:
                    System.out.println("You selected Update citation payment status");
                    // Implement your code to update citation payment status here
                    break;
                case 4:
                    System.out.println("You selected Delete citation information");
                    // Implement your code to delete citation information here
                    break;
                case 5:
                    System.out.println("You selected Create citation appeal");
                    // Implement your code to create a citation appeal here
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
	
}




