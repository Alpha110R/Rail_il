package Rails_IL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		boolean toContinue = true;
		Rails todaysRides = new Rails();

		do {
			System.out.println(
					"Type '1' to set ride, type '2' to view rides, type '3' to search a ride, type '4' to save rides, type '5' to exit menu.");
			int keyNum = input.nextInt();
			input.nextLine(); // clear the scanner buffer

			switch (keyNum) {
			case 1:
				// Adding departure station
				Ride rideEx = new Ride();
				System.out.println("enter departure location");
				String depLocation = input.nextLine();
				System.out.println("enter daparture time");
				String depTime = input.nextLine();
				rideEx.addStation(new Station(depLocation, depTime));

				// Adding midway stations
				boolean toContinue2 = true;
				do {
					System.out.println("would you like to add midway stations? y/n");
					if (input.nextLine().equals("y")) {
						System.out.println("enter stopping location");
						String midLocation = input.nextLine();
						System.out.println("enter stopping time");
						String midTime = input.nextLine();
						rideEx.addStation(new Station(midLocation, midTime));
					} else {
						toContinue2 = false;
					}

				} while (toContinue2);

				// Adding final station
				System.out.println("enter arrival location");
				String finLocation = input.nextLine();
				System.out.println("enter arrival time");
				String finTime = input.nextLine();
				rideEx.addStation(new Station(finLocation, finTime));

				todaysRides.addRide(rideEx);
				System.out.println("A ride has been created!\n");
				break;

			case 2:
				System.out.println("\nYou've chosen to display existent rides.");
				if(todaysRides.isEmpty()) {
					System.out.println("No rides to display.");
				} else {
					todaysRides.sortRides();
					System.out.println(todaysRides.toString());
				}
				break;

			case 3:
				System.out.println("\nYou've decided to search for a ride.");
				System.out.println("Enter start station location.");
				String start = input.nextLine();
				System.out.println("Enter time for start station");
				String time = input.nextLine();
				System.out.println("Enter end station.");
				String end = input.nextLine();
				System.out.println(todaysRides.searchRide(new Station(start, time), end));
				break;

			case 4:
				System.out.println("You've chosen to save the existing rides");
				// saving the existing rides as a binary file
				ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("todaysRides.dat"));
				outFile.writeObject(todaysRides);
				outFile.close();
				break;

			case 5:
				System.out.println("You've chosen to exit the menu.");
				toContinue = false;
				break;

			default:
				System.out.println("Invalid input!");
			}

		} while (toContinue);

		input.close();
	}
}
