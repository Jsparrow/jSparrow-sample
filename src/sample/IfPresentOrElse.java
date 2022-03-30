package sample;

import java.util.Optional;

public class IfPresentOrElse {
	
	
	public void baseCase() {
		Optional<String> optional = Optional.empty();
		
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
		} else {
			consume("No value");
		}
		
//		optional.ifPresentOrElse(value -> consume(value), () -> consume("No value"));
	}
	
	public void throwStatements() {
		Optional<String> optional = Optional.empty();
		
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
			return;
		} else {
			consume("No value");
		}
		
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
		} else {
			consume("No value");
			throw new RuntimeException();
		}
		
//		optional.ifPresentOrElse(value -> consume(value), () -> consume("No value"));
	}
	
	public void nonFinalVariables() {
		Optional<String> optional = Optional.empty();
		int i = 0;
		i++;
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
			i++;
		} else {
			consume("No value");
		}
		
		int j = 0;
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
		} else {
			consume("No value");
			j++;
		}
		
//		optional.ifPresentOrElse(value -> consume(value), () -> consume("No value"));
	}
	
	public void multiple_ifThenElse(boolean t) {
		Optional<String> optional = Optional.empty();
		
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
		} else if (t) {
			consume("t");
		} else {
			consume("No value");
		}
		
//		optional.ifPresentOrElse(value -> consume(value), () -> consume("No value"));
	}
	
	public void ifThenElseIf(boolean t) {
		Optional<String> optional = Optional.empty();
		
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
		} else if(t) {
			consume("No value");
		}
		
//		optional.ifPresentOrElse(value -> consume(value), () -> consume("No value"));
	}
	
	public void compoundIfCondition() {
		Optional<String> optional = Optional.empty();
		final int i = 0;
		if(optional.isPresent() ||  i >= 0) {
			String value = optional.get();
			consume(value);
		} else {
			consume("No value");
		}
		
//		optional.ifPresentOrElse(value -> consume(value), () -> consume("No value"));
	}
	
	public void missingOptionalGet() {
		Optional<String> optional = Optional.empty();
		if(optional.isPresent()) {
			String value = optional.orElse("");
			consume(value);
		} else {
			consume("No value");
		}
		
//		optional.ifPresentOrElse(value -> consume(value), () -> consume("No value"));
	}
	
	
	public void emptyElseBlock() {
		Optional<String> optional = Optional.empty();
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
		} else {
			
		}
		
//		optional.ifPresentOrElse(value -> consume(value), () -> {});
	}
	
	public void singleStatementElse() {
		Optional<String> optional = Optional.empty();
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
		} else 
			consume("No value");
//		optional.ifPresentOrElse(value -> consume(value), () -> consume("No value"));
	}
	
	public void illegalElseExpression() {
		Optional<String> optional = Optional.empty();
		if(optional.isPresent()) {
			String value = optional.get();
			consume(value);
		} else 
			for(int i =0; i <10; i++) {
				System.out.println(i);
			}
	}
	
	
	public void sample(String id) {
		Optional<User> optional = findById(id);
		if(optional.isPresent()) {
			User user = optional.get();
			consume(user);
		} else {
			noUserFound();
		}
	}
	
	public void multipleStatementsLambdaBody(String id) {
		Optional<User> optional = findById(id);
		if(optional.isPresent()) {
			User user = optional.get();
			consume(user);
			consume(user);
		} else {
			System.out.println();
			noUserFound();
		}
	}
	
	
	public void consume(User user) {
		
	}
	
	public void consume(String value) {
		
	}
	
	public void noUserFound() {
		
	}
	
	Optional<User> findById(String id) {
		return Optional.empty();
	}
	
	class User {
		
	}
}
