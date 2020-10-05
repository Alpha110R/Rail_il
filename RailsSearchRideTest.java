package Rails_IL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RailsSearchRideTest {

	@Test
	void test() throws Exception {
		Rails testingRails = new Rails();
		
		//fill the testingRails with rides
		Ride rideExample1 = new Ride();
		rideExample1.addStation(new Station("destination1", "00:00"));
		rideExample1.addStation(new Station("destination2", "00:30"));
		rideExample1.addStation(new Station("destination3", "01:00"));
		
		Ride rideExample2 = new Ride();
		rideExample2.addStation(new Station("destination1", "10:00"));
		rideExample2.addStation(new Station("destination2", "10:30"));
		rideExample2.addStation(new Station("destination3", "11:00"));
		
		Ride rideExample3 = new Ride();
		rideExample3.addStation(new Station("destination1", "13:00"));
		rideExample3.addStation(new Station("destination2", "13:30"));
		rideExample3.addStation(new Station("destination3", "14:00"));
		
		Ride rideExample4 = new Ride();
		rideExample4.addStation(new Station("destination1", "22:00"));
		rideExample4.addStation(new Station("destination2", "22:30"));
		rideExample4.addStation(new Station("destination3", "23:00"));
		
		testingRails.addRide(rideExample1);
		testingRails.addRide(rideExample2);
		testingRails.addRide(rideExample3);
		testingRails.addRide(rideExample4);
		
		//creating what the actual output would be
		String startingLocation = "destination2";
		String startingTime = "01:00";
		String finalLocation = "destination3";
		
		Rails actualOutput = testingRails.searchRide(new Station(startingLocation, startingTime), finalLocation);
		
		//creating what the desired output should be
		Rails desiredOutput = new Rails();

		
		Ride desiredRide1 = new Ride();
		desiredRide1.addStation(new Station("destination2", "10:30"));
		desiredRide1.addStation(new Station("destination3", "11:00"));
		
		Ride desiredRide2 = new Ride();
		desiredRide2.addStation(new Station("destination2", "13:30"));
		desiredRide2.addStation(new Station("destination3", "14:00"));
		
		Ride desiredRide3 = new Ride();
		desiredRide3.addStation(new Station("destination2", "22:30"));
		desiredRide3.addStation(new Station("destination3", "23:00"));
		
		desiredOutput.addRide(desiredRide1);
		desiredOutput.addRide(desiredRide2);
		desiredOutput.addRide(desiredRide3);
		
		//testing 
		assertEquals(desiredOutput, actualOutput);		
	}

}
