package sample;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RemoveToStringOnString {
	
	private void toStringExampleInForEach(List<String>values) {
		values.forEach(value -> value.toString()); 
		
		Consumer<String> consumer = (String value) -> value.toString();
		Consumer<String> consumer2 = this::getStringValue;
		Consumer<String> consumer3 = (String value) -> value.toString();
		
		Consumer<String> consumer4 = (String value) -> this.getClass().getName();
		Consumer<String> consumer5 = String::new;
		Consumer<String> consumer6 = String::new;
		
		Supplier<String> supplier = () -> "";
		Function<String, String> function = (String value) -> value;
		Predicate<String> predicate = String::isEmpty;
	}
	
	private void useString(String value) {
		
	}
	
	private String getStringValue(String value) {
		return "";
	}
	
	private void distinguishConsumerAndSupplier() {
		Supplier<String> supplier = () -> "";
		String string = "";
		useOverloadedMethod(supplier);
		useOverloadedMethod(() -> string);
		useOverloadedMethod((String value) -> this.getClass().getName());
		useOverloadedMethod((String value) -> this.getClass().getName());
		useOverloadedMethod((String value) -> value);
		useOverloadedMethod((String value) -> value);
		useOverloadedMethod(this::useString);
		
	}
	
	
	private void useOverloadedMethod(Supplier<String> supplier) {
		System.out.println("In Supplier");
	}
	
	private void useOverloadedMethod(Consumer<String> supplier) {
		System.out.println("In Consumer");
	}
	
	private void useOverloadedMethod(Function<String, String> function) {
		System.out.println("In Function");
	}
	
	public static void main(String[]args) {
		RemoveToStringOnString rtsos = new RemoveToStringOnString();
		rtsos.distinguishConsumerAndSupplier();
	}

}
