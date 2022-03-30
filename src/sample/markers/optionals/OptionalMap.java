package sample.markers.optionals;

import java.util.Optional;

public class OptionalMap {

	void baseCase(String userId) {
		findById(userId)
	    .ifPresent(user -> {
	        String email = user.getMail();
	        sendMail(email);
	    });
	}
	
	void multipleStatementsInBody(String userId) {
		Optional<User> oUser = findById(userId);
		oUser.ifPresent(user -> {
		    Address address = user.getAddress();
		    sendGiftCard(address);
		    sendAds(address);
		});
	}
	
	Optional<User> findById(String userId) {
		return Optional.empty();
	}
	
	boolean isSpecial(User user) {
		return false;
	}
	
	void sendMail(String email) {
		
	}
	
	void sendGiftCard(Address address) {
		
	}
	
	void sendAds(Address address) {
		
	}
}
