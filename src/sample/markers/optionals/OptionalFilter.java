package sample.markers.optionals;

import java.util.Optional;

public class OptionalFilter {

	void filterExample(String userId) {
		Optional<User> oUser = findById(userId);
		oUser.ifPresent(user -> {
			if (isSpecial(user)) {
				sendMail(user.getMail());
			}
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
}
