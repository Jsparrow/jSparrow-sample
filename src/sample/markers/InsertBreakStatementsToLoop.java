package sample.markers;

import java.util.Arrays;
import java.util.List;

public class InsertBreakStatementsToLoop {
	
	void sample() {
		boolean contains = true;
		List<String> values = Arrays.asList("value1", "value2", "3");
		for (String value : values) { 
		    if (value.isEmpty()) { 
		    	contains = false;
		    } 
		}
	}
	
	
	void sample2() {
		boolean contains = true;
		List<String> values = Arrays.asList("value1", "value2", "3");
		for (String value : values) { 
		    if (value.isEmpty()) 
		    	contains = false;
		}
	}

}
