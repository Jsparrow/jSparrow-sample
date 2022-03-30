package sample.optional;

import java.util.Optional;

public class OptionalMapSamples {
	
	
	public void baseCase() {
		Optional<String> optional = Optional.of("value");
		optional.ifPresent(value -> {
			String test = value.replace("t", "o");
			System.out.print(test);
		});
	}

	public void multipleRemainingStatements() {
		Optional<String> optional = Optional.of("value");
		optional.ifPresent(value -> {
			String test = value.replace("t", "o");
			System.out.print(test);
			System.out.print(test);
		});
	}

	public void multipleExtractedStatements() {
		Optional<String> optional = Optional.of("value");
		optional.ifPresent(value -> {
			System.out.print(value);
			String test = value.replace("t", "o");
			System.out.print(test);
		});
	}
	
	public void multipleExtractedAndRemainingStatements() {
		Optional<String> optional = Optional.of("value");
		optional.ifPresent(value -> {
			System.out.print(value);
			String test = value.replace("t", "o");
			System.out.print(test);
			System.out.print(test);
		});
	}
	
	
	public void saveComments_multipleExtractedAndRemainingStatements() {
		Optional<String> optional = Optional.of("value");
		/* 1*/
		optional./* 2*/ ifPresent /* 3*/ ( /*4*/ value /* 5*/ -> /* 6*/ { /*7 */
			/* 8*/
			System.out./* 9*/print(value);
			/* 10*/
			String/*11 */ test /* 12*/= /* 13*/value./*14 */replace("t", "o");/* 15*/
			/*16 */
			System.out./* 17*/print(test);/*18 */
			System.out./* 19*/print(test);/* 20*/
			/* 21*/
		});
	}
	
	public void saveComments_singleExtractedAndRemainingStatements() {
		Optional<String> optional = Optional.of("value");
		/* 1*/
		optional./* 2*/ ifPresent /* 3*/ ( /*4*/ value /* 5*/ -> /* 6*/ { /*7 */
			/* 8*/
			String /* 9*/ test/* 10*/  = /* 11*/ value/* 12*/ . /* 13*/ replace /* 14*/ ("t", "o")/*15 */;
			/* 16*/
			System.out.print(test);
			/* 17*/
		});
	}
	
	public void primitiveTypes() {
		Optional<String> optional = Optional.of("value");
		optional.ifPresent(value -> {
			int length = value.length();
			if(length > 0) {
				System.out.println("Length is " + length);
			}
		});
	}
	
	public void usingParameterType() {
		Optional<String> optional = Optional.of("value");
		optional.ifPresent((String value) -> {
			String test = value.replace("t", "o"); 
			System.out.print(test);
		});
	}
	
	// Negative test cases 
	
	public void nonExtractableBody() {
		Optional<String> optional = Optional.of("value");
		optional.ifPresent(value -> {
			String test = value.replace("t", "o");
			System.out.print(test);
			System.out.print(value);
		});
	}
	
	public void singleStatementLambdaBlock() {
		Optional<String> optional = Optional.of("value");
		optional.ifPresent(value -> {
			if(value.length() > 1) {				
				System.out.print(value);
			}
		});
	}
	
	public void codeSample(String userId) {
		findById(userId).ifPresent(user -> {
			String email = user.getMail();
			sendMail(email);
		});
	}
	
	public void multipleStatementsInLambdaBody(String userId) {
		Optional<User> oUser = findById(userId);
		oUser.ifPresent(user -> {
			Address address = user.getAddress();
			sendGiftCard(address);
			sendAds(address);
		});
	}
	
	
	private void sendAds(Address address) {
		/*
		 * Do nothing! ;p
		 */
	}

	public void sendMail(String email) {
		/*
		 * Do nothing! ;p
		 */
	}
	
	public void sendGiftCard(Address address) {
		/*
		 * Do Nothing! ;p
		 */
	}
	
	private Optional<User> findById(String id) {
		return Optional.empty();
	}
	
	//TODO: test optional of boxed primitives


}
