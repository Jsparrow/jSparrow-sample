package sample.markers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoryMethodsForCollections {

	List<String> list1 = Collections.unmodifiableList(new ArrayList<String>() {
		{
			add("a");
			add("b");
			add("c");
		}
	});

	List<String> list1_expected = Collections.unmodifiableList(new ArrayList<String>() {
		{
			add("a");
			add("b");
			add("c");
		}
	});

	void listOfExamples_original() {
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list2 = Collections.unmodifiableList(list2);
	}

	void listOfExamples_expected() {
		List<String> list2 = List.of("a", "b", "c");
	}

	void setOfExample_original() {
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		set = Collections.unmodifiableSet(set);
	}

	void setOfExample_expected() {
		Set<String> set = Set.of("a", "b", "c");
	}

	void mapOfExample_original() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map = Collections.unmodifiableMap(map);
	}
}
