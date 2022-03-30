package sample.markers;

import java.util.Arrays;
import java.util.stream.Stream;

public class UseArraysStream {

	void sampleArrayStream() {
		Arrays.asList(1, 2, 3).stream().forEach(v -> {
			System.out.println(v);
			System.out.println(v);
		});
		
		Stream.of("1", "2", "3").forEach(v -> {
			System.out.println(v);
			System.out.println(v);
		});
	}
	
	void sampleStreamOf() {
		Arrays.asList("1", "2", "3").stream().forEach(v -> {
			System.out.println(v);
			System.out.println(v);
		});
		
		Stream.of("1", "2", "3").forEach(v -> {
			System.out.println(v);
			System.out.println(v);
		});
	}
}
