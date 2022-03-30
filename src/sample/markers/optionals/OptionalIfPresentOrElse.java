package sample.markers.optionals;

import java.util.Optional;

public class OptionalIfPresentOrElse {

	public void defaultUseCase_shouldTransform(Optional<String> input) {
	    if (input.isPresent()) {
	        String value = input.get();
	        System.out.println(value);
	    } else {
	    	System.out.print("No value found");
	    }
	}
	
	String value = "prefix" + "value" + "suffix";
	public void multipleInitializers_shouldTransform(Optional<String> input) {
	    if (input.isPresent()) {
	        String value = input.get(), second = "";
	        System.out.println(value);
	        System.out.println(second);
	    } else {
	    	System.out.print("No value found");
	    	consume("no value");
	    }
	}
	
	
	void consume(String value) {
		
	}
} 
