package sample.optional;

import java.util.Optional;

public class OptionalFilterSamples {

	public void baseCase(String userId) {
		Optional<User> oUser = findById(userId);
		oUser.ifPresent(user -> {
			if (isSpecial(user)) {
				sendPresent(user);
			}
			sendMail(user.getMail());
		});

		Optional<String> optional = Optional.empty();
		optional.ifPresent(value -> {
			if (!value.isEmpty()) {
				System.out.println(value);
			}
		});
	}
	
	private boolean isSpecial(User user) {
		return true;
	}
	
	private Optional<User> findById(String userId) {
		return Optional.empty();
	}
	
	public void visit_usingExplicitTypes_shouldTransform() {
		Optional<String> optional = Optional.empty();
		optional.ifPresent((String value) -> {
			if (!value.isEmpty()) {
				System.out.println(value);
			}
		});
	}

	public void baseCase_expected() {

		Optional<String> optional = Optional.empty();
		optional.filter(value -> !value.isEmpty()).ifPresent(value -> {
			System.out.println(value);
		});
	}
	
	public void visit_unrelatedIfCondition_shouldNotTransform() {
		Optional<String> optional = Optional.empty();
		optional.ifPresent(value -> {
			if (optional.isPresent()) {
				System.out.println(value);
			}
		});
	}
	
	public void visit_emptyIfStatement_shouldNotTransform() {
		Optional<String> optional = Optional.empty();
		optional.ifPresent(value -> {
			if (optional.isPresent()) {

			}
		});
	}
	
	public void ifThenElseStatement() {

		Optional<String> optional = Optional.empty();
		optional.ifPresent(value -> {
			if (!value.isEmpty()) {
				System.out.println(value);
			} else {
				
			}
		});
	}


	public void savingComments() {

		Optional<User> optional = Optional.empty();
		/* 1 */
		optional/* 2 */./* 3 */ifPresent/* 4 */(/* 5 */user/* 6 */ -> /* 7 */ { /* 8 */
			/* 9 */
			if (/* 10 */!user.getMail().isEmpty()/* 11 */) /* 12 */ {
				/* 13 */
				sendMail(user.getMail());
				/* 14 */
			}
			/* 15 */
		});
	}
	
	public void visit_commentsWhenUsingExplicitTypes_shouldTransform() {
		Optional<String> optional = Optional.empty();
		optional/* 1 */./* 2 */ifPresent/* 3 */(/* 4 */(/* 5 */String /* 6 */value/* 7 */)/* 8 */ ->/* 9 */ {
			if (!value.isEmpty()) {
				System.out.println(value);
			}
		});
	}
	
	

	public void sendMail(String email) {
		/*
		 * Do nothing! ;p
		 */
	}
	
	public void sendPresent(User user) {
		/*
		 * Do nothing! ;p
		 */
	}

}
