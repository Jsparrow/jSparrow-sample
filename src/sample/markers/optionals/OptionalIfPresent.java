package sample.markers.optionals;

import java.util.Optional;

public class OptionalIfPresent {

	public void defaultUseCase_shouldTransform(Optional<String> input) {
	    if (input.isPresent()) {
	        String value = input.get();
	        System.out.println(value);
	    }
	}
	
	String value = "prefix" + "value" + "suffix";
	public void multipleInitializers_shouldTransform(Optional<String> input) {
	    if (input.isPresent()) {
	        String value = input.get(), second = "";
	        System.out.println(value);
	        System.out.println(second);
	    }
	}
}
