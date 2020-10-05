package Rails_IL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean toContinue = true;
		Rails todaysRides = new Rails();

		do {
			System.out.println("Type '1' to set ride, type '2' to view rides, type '3' to search a ride, type '4' to save rides, type '5' to exit menu.");
			
			try {	
				
				int keyNum = input.nextInt();
				input.nextLine(); // clear the scanner buffer
				
				switch (keyNum) {
				case 1:
					caseNo1(input, todaysRides);
					break;
	
				case 2:
					caseNo2(todaysRides);
					break;
	
				case 3:
					caseNo3(input, todaysRides);
					break;
	
				case 4:
					caseNo4(todaysRides);
					break;
	
				case 5:
					System.out.println("You've chosen to exit the menu.");
					toContinue = false;
					break;
	
				default:
					System.out.println("Invalid input!");
				}
				
			} catch(InputMismatchException exception) {
				System.out.println("invalid input.");
				toContinue = false;
				
			} catch(Exception exception) {
				System.out.println(exception.getMessage());
			}

		} while (toContinue);
		
		input.close();
	}
	
	
	public static void caseNo1(Scanner scanner, Rails todaysRides) throws Exception {
		// Adding departure station
		Ride rideEx = new Ride();
		System.out.println("enter departure location");
		String depLocation = scanner.nextLine();
		System.out.println("enter daparture time");
		String depTime = scanner.nextLine();
		rideEx.addStation(new Station(depLocation, depTime));

		// Adding midway stations
		boolean toContinue2 = true;
		do {
			System.out.println("would you like to add midway stations? y/n");
			String yesOrNo = scanner.nextLine();
			if (yesOrNo.equalsIgnoreCase("y")) {
				System.out.println("enter stopping location");
				String midLocation = scanner.nextLine();
				System.out.println("enter stopping time");
				String midTime = scanner.nextLine();
				rideEx.addStation(new Station(midLocation, midTime));
			}else if(yesOrNo.equalsIgnoreCase("n")) {
				toContinue2 = false;
			} else {
				System.out.println("error has accurred");
				return;
			}

		} while (toContinue2);

		// Adding final station
		System.out.println("enter arrival location");
		String finLocation = scanner.nextLine();
		System.out.println("enter arrival time");
		String finTime = scanner.nextLine();
		rideEx.addStation(new Station(finLocation, finTime));

		todaysRides.addRide(rideEx);
		System.out.println("A ride has been created!\n");
	}
	
	public static void caseNo2(Rails todaysRides) {
		System.out.println("\nYou've chosen to display existent rides.");
		if(todaysRides.isEmpty()) {
			System.out.println("No rides to display.");
		} else {
			todaysRides.sortRides();
			System.out.println(todaysRides.toString());
		}
	}
	
	public static void caseNo3(Scanner scanner, Rails todaysRides) throws Exception {
		System.out.println("\nYou've decided to search for a ride.");
		System.out.println("Enter start station location.");
		String start = scanner.nextLine();
		System.out.println("Enter time for start station");
		String time = scanner.nextLine();
		System.out.println("Enter end station.");
		String end = scanner.nextLine();
		System.out.println(todaysRides.searchRide(new Station(start, time), end));
	}
	
	public static void caseNo4(Rails todaysRides) throws FileNotFoundException, IOException {
		System.out.println("You've chosen to save the existing rides");
		// saving the existing rides as a binary file
		ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("todaysRides.dat"));
		outFile.writeObject(todaysRides);
		outFile.close();
	}
}

