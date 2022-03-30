package sample.markers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaForEach {

	void useStreamFilter() {
		List<String> list = Arrays.asList("foo", "bar");
		list.stream().forEach(s -> {
			if (s.length() > 3) {
				System.out.println(s);
				System.out.println(s + s);
			}
		});

		list.stream().filter(s -> s.length() > 3).forEach(s -> {
			System.out.println(s);
			System.out.println(s + s);
		});
	}

	void useStreamMap() {
		List<String> list = Arrays.asList("foo", "bar");
		list.stream().filter(s -> !s.isEmpty()).map(s -> s.substring(1))
				.forEach(subString -> System.out.print(subString));

		list.stream().filter(s -> !s.isEmpty()).forEach(s -> {
			String subString = s.substring(1);
			System.out.print(subString);
		});
	}

	void useStreamCollect() {
		List<String> objectList = Arrays.asList("foo", "bar");
		List<String> oStrings = new ArrayList<>();
		objectList.stream().map(o -> o.substring(0)).forEach(oString -> {
			oStrings.add(oString);
		});

		oStrings.addAll(objectList.stream().map(o -> o.substring(0)).collect(Collectors.toList()));
	}

}
