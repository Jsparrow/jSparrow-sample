package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpressionEvaluationInLoggers {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpressionEvaluationInLoggers.class);
	
	public void sampleMethod(String someValue, String param2, String param3) {
		// Parenthesized expression
		logger.debug("Literal" + (someValue  + " --" +( this.getClass().getName() )+ " other value") + ".");
		logger.debug("Literal {}{}.", (someValue  + " --" + this.getClass().getName() ) + " other value"		);
		
		
		
		logger.debug("Literal " + (someValue  + " --" +( this.getClass().getName())) + " other value" + ".");
		
		logger.debug("Literal {} other value .", 
				(someValue  + " --" +( this.getClass().getName())));
		
		logger.debug("Literal {}{}{}", 
				someValue  + " --" +( this.getClass().getName()), "other value", ".");
		
		String evaluatedExp = someValue  + " --" +( this.getClass().getName());
		
		
		
		logger.debug("Literal {} somethingHere {} {}", 
				evaluatedExp, param2);
		
		// prefix expression
		double a = 0;
		logger.debug("Literal" + ++a + ".");
		
		// Arithmetic expression
		logger.debug("Literal" + 5 + 3 + ".");
		logger.debug("Literal" + (8 * 4) + ".");
		
		// new instance creation
		logger.debug("Some value" + new ExpressionEvaluationInLoggers());
		
		// Single expression
		logger.debug(someValue);
		
		logger.debug(someValue + " Some value");
		logger.debug("{} Some value", someValue);
		logger.debug("{}{}",  someValue , " Some value");
		
		
	}

}
