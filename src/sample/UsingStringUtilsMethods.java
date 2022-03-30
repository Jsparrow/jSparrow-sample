package sample;

import sample.optional.User;

public class UsingStringUtilsMethods {
	
	public boolean checkingEmpty(String value) {
	    return  value.isEmpty();
	}

	public String testTrim(String value) {
	    return value.trim();
	}

	public boolean testEqualsIgnoreCase(User user, String  expectedEmail) {
	    String email = user.getMail();
	    return email.equalsIgnoreCase(expectedEmail);
	}
	
	public String findingSubstring(String value, int index) {
		return value.substring(index);
	}
	
	public int findingIndexOf(String value, String suffix) {
		return value.indexOf(suffix);
	}
	
	public boolean comparingSuffix(String value, String suffix) {
		return value.endsWith(suffix);
	}
	
	public boolean comparingPrefix(String value, String prefix) {
		return value.startsWith(prefix);
	}
	
	public boolean containsValue(String value, String sequence) {
		return value.contains(sequence);
	}
	
	public void changeCapitalization(String value) {
		String upper = value.toUpperCase();
		String lowwer = value.toLowerCase();
	}

}
