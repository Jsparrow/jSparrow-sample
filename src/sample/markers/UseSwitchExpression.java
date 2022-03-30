package sample.markers;

import java.time.Instant;

public class UseSwitchExpression {

	void initializingVariable() {
		int finished = 1;
		String medal;
		switch(finished) {
		case 1 : 
		    medal = "Gold";
		    break;
		case 2: 
		    medal = "Silver";
		    break;
		case 3: 
		    medal = "Bronze";
		    break;
		default:
		    medal = "None";
		}
	}
	
	String computingTheReturnedValue(int finished) {
	    switch(finished) {
	    case 1 : 
	        return "Gold";
	    case 2: 
	        return "Silver";
	    case 3: 
	        return "Bronze";
	    default:
	        return "None";
	    }
	}
	
	void labledSwitchStatement(int finished, String athlete) {
		switch(finished) {
		case 1 : 
		    sendMedal("Gold", athlete);
		    break;
		case 2: 
		    sendMedal("Silver", athlete);
		    break;
		case 3: 
		    sendMedal("Bronze", athlete);
		    break;
		default:
		    sendGratitude(athlete);
		}
	}
	
	void combineSwitchCases(String sport) {
		switch(sport) {
		case "diving":
		case "swimming":
		case "water polo": 
		    cleanUpPool(Instant.now());
		    break;
		case "weightlifting":
		case "gymnastic":
		    cleanUpGym(Instant.now());
		    break;
		default: 
		    cleanUpStadium(Instant.now());
		}
	}
	
	

	private void cleanUpStadium(Instant now) {
		
	}

	private void cleanUpGym(Instant now) {
		
	}

	private void cleanUpPool(Instant now) {
		
	}

	private void sendGratitude(String athlete) {
		
	}

	private void sendMedal(String string, String athlete) {
		
	}
}
