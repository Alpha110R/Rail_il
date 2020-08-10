import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean toContinue = true;
		ArrayList<Ride> rides = new ArrayList<Ride>();
		
		do {
			System.out.println("Type '1' to set ride, type '2' to view rides, type '9' to exit menu.");
			int keyNum = input.nextInt();
			input.nextLine(); //clear the scanner buffer
			switch (keyNum) {
			case 1:
				System.out.println("Set departure station.");
				String s1 = input.nextLine();
				System.out.println("Set departure time. (hh:mm format)");
				String s2 = input.nextLine();
				System.out.println("Set arrival station.");
				String s3 = input.nextLine();
				System.out.println("Set arrival time. (hh:mm format)");
				String s4 = input.nextLine();
				rides.add(new Ride(s1, s2, s3, s4));
				break;

			case 2:
				sortArrayList(rides);
				printArrayList(rides);
				break;
				
			case 9:
				System.out.println("You've chosen to exit the menu.");
				toContinue = false;
				break;
				
			default:
				System.out.println("Invalid input!");
			}
			
		} while (toContinue);
		
		input.close();
}
	
	//sub method for sortArrsyList()
	public static void swap(ArrayList<Ride> arr, int i, int j) {
		Ride temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	public static void sortArrayList(ArrayList<Ride> arr) {
		boolean hasChanged = true;
		
		for(int i = arr.size() - 1; i > 0 && hasChanged; i--) {
			hasChanged = false;
			for(int j = 0; j < i; j++) {
				if(arr.get(j).departureTimeAsInt() > arr.get(j + 1).departureTimeAsInt()) {
					swap(arr, j, j + 1);
					hasChanged = true;
				}
			}
		}
	}
	
	public static void printArrayList(ArrayList<Ride> arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + "\n");
		}
		System.out.println();
	}
	public static void 

	

}
