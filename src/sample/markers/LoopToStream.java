package sample.markers;

import java.util.Arrays;
import java.util.List;

public class LoopToStream {

	void anyMatch_original() {
		List<String> strings = Arrays.asList("", "");
		boolean containsEmpty = false;
		for (String value : strings) {
			if (value.isEmpty()) {
				containsEmpty = true;
				break;
			}
		}
	}

	void anyMatch_expected() {
		List<String> strings = Arrays.asList("", "");
		boolean containsEmpty = strings.stream().anyMatch(value -> value.isEmpty());
	}
	
	//////////////////////////////////
	
	
	void findFirst_original() {
		String key = "b";
		List<String> values = Arrays.asList("a", "b");
		for(String value : values) {
		    if(value.length() > 4) {
		         key = value;
		         break;
		    }
		}
	}

	void findFirst_expected() {
		List<String> values = Arrays.asList("a", "b");
		String key = values.stream().filter(value -> value.length() > 4).findFirst().orElse("b");
	}

	
	//////////////////////////////////
	
	
	void forEach_original() {
		List<String> values = Arrays.asList("a", "b");
		for (String string : values) {
		    System.out.println(string);
		    System.out.println(string);
		}
	}

	void forEach_expected() {
		System.out.print("");
		List<String> values = Arrays.asList("a", "b");
		values.forEach(string -> {
		    System.out.println(string);
		    System.out.println(string);
		});
	}
	
	/*
	 * findSum_original
	 */
	
	void findSum_original() {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		int sum = 0;
		for(int n : numbers) {
		    sum += n;
		}
	}
	
	void findSum_expected() {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		int sum = numbers.stream().mapToInt(Integer::intValue).sum();
	}
	
	/////////////////
	
	void takeWhile_original() {
		List<String> values = Arrays.asList("a", "b");
		for(String value : values) {
		    if(!value.isEmpty()) {
		        break;
		    }
		    System.out.println(value);
		}
	}
	
	void takeWhile_expected() {
		List<String> values = Arrays.asList("a", "b");
		values.stream().takeWhile(value -> value.isEmpty()).forEach(value -> {
			System.out.println(value);
		});
	}

}
