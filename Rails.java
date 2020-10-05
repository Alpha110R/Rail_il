package Rails_IL;

import java.io.Serializable;
import java.util.ArrayList;

public class Rails implements Serializable {

	private ArrayList<Ride> allRides;

	public Rails() {
		allRides = new ArrayList<Ride>();
	}

	public void addRide(Ride ride) {
		allRides.add(ride);
	}

	public void sortRides() {
		boolean hasChanged = true;

		for (int i = allRides.size() - 1; i > 0 && hasChanged; i--) {
			hasChanged = false;
			for (int j = 0; j < i; j++) {
				if (allRides.get(j).getDepartureStation().getTimeAsInt() > allRides.get(j + 1).getDepartureStation()
						.getTimeAsInt()) {
					swap(allRides, j, j + 1);
					hasChanged = true;
				}
			}
		}
	}

	public Rails searchRide(Station startStation, String endLocation) {
		int counter = 0;
		Rails result = new Rails();
		for (int i = 0; i < allRides.size(); i++) {
			if (allRides.get(i).stationsLocationExist(startStation.getLocation(), endLocation)) {
				if (startStation.compareStationsChronologically(
						allRides.get(i).getStationByLocation(startStation.getLocation()))) {
					if (counter < 3) {
						result.addRide(allRides.get(i).createSubRide(startStation.getLocation(), endLocation));
						counter++;
					}
				}
			}
		}
		result.sortRides();
		return result;
	}

	private void swap(ArrayList<Ride> arr, int i, int j) {
		Ride temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	public boolean isEmpty() {
		return allRides.isEmpty();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allRides.size(); i++) {
			sb.append(allRides.get(i));
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Rails)) {
			return false;
		}

		Rails temp = (Rails) other;
		return allRides.equals(temp.allRides);
	}

}
