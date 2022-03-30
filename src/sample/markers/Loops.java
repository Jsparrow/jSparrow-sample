package sample.markers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Loops {

	void sample(List<String>values) {
		for (int i = 0; i<values.size(); i++) {
			String value = values.get(i);
			System.out.println(value);
		}
		

		String[] ms = {};
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ms.length; i++) {
			String s = ms[i];
			sb.append(s);
		}
	}
	
	void sampleWhileToForEach() {
		List<String>list = Collections.singletonList("");
		int i = 0;
		while (i < list.size()) {
			String t = list.get(i);
			System.out.println(t);
			i++;
		}
	}
	
	String stringBuildingLoop() {
		List<String> collectionOfStrings = java.util.Arrays.asList("1", "2", "3");
		String result = "";
		for(String val : collectionOfStrings) {
			result = result + val;
		}
		return result;
	}
	
	String useStringJoinResolver() {
		List<String> values = new ArrayList<>();
		return values.stream().collect(Collectors.joining(","));
	}
	
}
