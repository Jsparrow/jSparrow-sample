package sample.bugfixes;

import java.util.List;

public class Sim1914UseStreamMap {
	
	void sample_bugInput(List<String> list) {
		list.stream().filter(s -> !s.isEmpty()).forEach((final String s) -> {
			final String subString = s.substring(1);
			System.out.print(subString);
		});
	}
	
	void sample_expectedOutput(List<String> list) {
		list.stream().filter(s -> !s.isEmpty())
			.map((final String s) -> s.substring(1))
			.forEach((final String subString) -> System.out.print(subString));
	}

}
