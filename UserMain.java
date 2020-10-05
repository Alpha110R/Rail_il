package Rails_IL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UserMain {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// reading today's rides from the first main class
		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("todaysRides.dat"));
		Rails todaysRides = (Rails)inFile.readObject();
		inFile.close();

		System.out.println("Hello! Welcome to searching rides program.");
		String startLocation = args[0];
		String startTime = args[1];
		String endLocation = args[2];
		
		Rails res  = todaysRides.searchRide(new Station(startLocation, startTime), endLocation);
		
		if(res.isEmpty()) {
			System.out.println("Sorry, there are no rides to show.");
		} else {
			System.out.println(res.toString());
		}
	}

}
