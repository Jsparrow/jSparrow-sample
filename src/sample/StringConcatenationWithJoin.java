package sample;

import java.util.List;
import java.util.stream.Collectors;

public class StringConcatenationWithJoin {
	
	public void baseCase(List<String>values) {
		values.stream().collect(Collectors.joining(","));
		String t = String.join(",", values);
		System.out.print(t);
		
		values.stream().collect(Collectors.joining());
		String.join("", values);
		
	}
	
	public void assignmentExpression(List<String>values) {
		String joinWithComma = "";
		joinWithComma = values.stream().collect(Collectors.joining(","));
		
		String simpleConcat = "";
		simpleConcat = values.stream().collect(Collectors.joining());
		
	}
	
	public void variableInitializationExpression(List<String>values) {
		String joinWithComma = values.stream().collect(Collectors.joining(","));
		System.out.println(joinWithComma);
		
		String simpleConcat = values.stream().collect(Collectors.joining());
	}
	
	
	public void sampleCodes(List<String>values) {
		String result = values.stream().collect(Collectors.joining(","));
		result = String.join(",", values);
		String.join(",", values);
		
		
	}

}
