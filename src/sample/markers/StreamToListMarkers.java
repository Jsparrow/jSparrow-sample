package sample.markers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToListMarkers {
	
	void streamToListSample_original() {
		
		List<String> values = Stream.of("a", "b", "c")
				.filter(value -> !value.isEmpty())
				.collect(Collectors.toUnmodifiableList());
		System.out.print(values);
	}
	
	void streamToListSample_expected() {
		
		List<String> values = Stream.of("a", "b", "c")
				.filter(value -> !value.isEmpty()).toList();
		
		System.out.print(values);
	}

}
