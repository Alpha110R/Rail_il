
public class Ride {
	private String departureStation; 
	private String departureTime;
	private String arrivalStation;
	private String arrivalTime;
	
	public Ride(String departureStation, String departureTime, String arrivalStation, String arrivalTime) {
		this.departureStation = departureStation;
		this.departureTime = departureTime;
		this.arrivalStation = arrivalStation;
		this.arrivalTime = arrivalTime;
	}
	
	public String getDepartureStation() {
		return departureStation;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}
	
	public String getArrivalStation() {
		return arrivalStation;
	}
	
	public String getArrivalTime() {
		return arrivalTime;
	}
	
	//for example "10:47" ==> 1047
	public int departureTimeAsInt() {
		String temp = departureTime.substring(0, 2) + departureTime.substring(3, 5);
		return Integer.parseInt(temp);
	}
	
	public String toString() {
		return departureStation + ", " + departureTime + ", " + arrivalStation + ", " + arrivalTime + ".";
	}
}
