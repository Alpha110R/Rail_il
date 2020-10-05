package Rails_IL;

import java.io.Serializable;

public class Station implements Serializable {

	private String location;
	private String time;

	public Station(String location, String time) throws Exception {
		this.location = location;
		setTime(time);
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setTime(String time) throws Exception {
		if(isTimeValid(time)) {
			this.time = time;
		} else {
			throw new Exception("time entered is not valid.");
		}
	}

	public String getLocation() {
		return this.location;
	}

	// for example "10:47" ==> 1047
	public int getTimeAsInt() {
		String temp = time.substring(0, 2) + time.substring(3, 5);
		return Integer.parseInt(temp);
	}

	public boolean compareStationsChronologically(Station station) {
		if (getTimeAsInt() <= station.getTimeAsInt()) {
			return true;
		}
		return false;
	}
	
	public boolean isTimeValid(String time) {
		if((time.length() != 5) || (time.charAt(2) != ':')) {
			return false;
		}
		
		String firstPartNumericInput = time.substring(0, 2);
		String secondPartNumericInput = time.substring(3, 5);
		
		try {
			int firstPartNumericValue = Integer.parseInt(firstPartNumericInput);
			int secondPartNumericValue = Integer.parseInt(secondPartNumericInput); 
			
			if(firstPartNumericValue > 23 || secondPartNumericValue > 59) {
				return false;
			}	
			
		} catch(NumberFormatException exception) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(location);
		sb.append(", ");
		sb.append(time);
		sb.append(". ");
		return sb.toString();

	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Station)) {
			return false;
		}

		Station temp = (Station) other;
		return location.equals(temp.location) && time.equals(temp.time);
	}
}
