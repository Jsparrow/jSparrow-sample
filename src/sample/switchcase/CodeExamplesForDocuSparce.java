package sample.switchcase;

import java.time.Instant;
import java.util.Date;

public class CodeExamplesForDocuSparce {
	
	/**
	 * Assigning variables
	 */
	void assigningVariable(int finished) {
		
		
		
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
	
	
	
	
	
	/**
	 * Assigning variables
	 */
	String findMedal(int finished) {
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
	
	void sendMedal(int finished, String athlete) {
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
	
	void combineCases(String sport) {
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
		// TODO Auto-generated method stub
		
	}

	private void cleanUpGym(Instant now) {
		// TODO Auto-generated method stub
		
	}

	private void cleanUpPool(Instant now) {
		// TODO Auto-generated method stub
		
	}

	void sendMedal(String medal, String athlete) {}
	void sendGratitude(String athlete) {}

}
