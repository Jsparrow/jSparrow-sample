package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import static java.util.Map.entry;

public class FactoryMethodsForCollectionsTest {
	/*
	
	public void creatingMapEntries() {
		Map<String, String> map = new HashMap<>();
		map.put("", "");
		map.put("2", "two");
		map.put("3", "three");
		map = Collections.unmodifiableMap(map);
		
	}
	
	public void usingListOf() {
		
		List<String> list1 = Collections.unmodifiableList(new ArrayList<String>() {{
			add("value");
			add("value2");
		}});
		
		List<String> list11 = Collections.unmodifiableList(new ArrayList<String>() {{

		}});
		
		List<String> list2 = Collections.unmodifiableList(Arrays.asList("1", "2", "3"));
		
		List<String> list3 = new ArrayList<>();
		list3.add("1");
		list3.add("2");
		list3.add("3");
		list3 = Collections.unmodifiableList(list3);
		
		Set<String> set = Collections.unmodifiableSet(new HashSet<String>() {{
			add("1");
			add("2");
		}});
		
		
		
	}
	
	
	public void usingListOf_noTransformation() {
		
		Collections.unmodifiableList(new ArrayList<String>() {{
			add("1");
			add("2");
		}});
		
		List<String> list1 = Collections.unmodifiableList(new ArrayList<String>() {{
			add("value");
			add("value2");
			addAll(Arrays.asList("" , ""));
		}});
		
		List<String> list2 = Collections.unmodifiableList(new ArrayList<>());
		
		Collection<String> collection = Collections.unmodifiableCollection(new ArrayList<String>() {{}});
		
	}
	
	public void convertingFreshCollectionToUnmodifiable() {
		List<String> list3 = new ArrayList<>();
		list3.add("1");
		list3.remove(0);
		list3.add("2");
		list3.add("3");
		list3 = Collections.unmodifiableList(list3);
		
		Map<String, String> map = new HashMap<>();
		map.put("", "");
		map = Collections.unmodifiableMap(map);
		
		Map<String, String> map2 = new HashMap<String, String>(){{
			put("4", "four");
			put("3", "three");
		}};
		map2.put("2", "two");
		map = Collections.unmodifiableMap(map2);
		
		List<String> l = new ArrayList<>();
		List<String> list = new ArrayList<>(l);
		list.add("b");
		list = Collections.unmodifiableList(list);
	}
	
	public void arrayParameter(String... values) {
		List<String> list = Collections.unmodifiableList(Arrays.asList(values));
		list = List.of(values);
	}
	
	public void sampleCode() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list = Collections.unmodifiableList(list);
		
	}
	
	public void sampleCode2() {
		List<String> list = Collections.unmodifiableList(new ArrayList<String>() {{
			add("a");
			add("b");
			add("c");
		}});
		
	}
	
	public void sampleCode3() {
		List<String> list = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
		
	}
	
	public void sampleCode4() {
	    Set<String> set = new HashSet<>();
	    set.add("a");
	    set.add("b");
	    set.add("c");
	    set = Collections.unmodifiableSet(set);
	    
	}
	
	public void sampleCode5() {
	    Map<String, String> map = new HashMap<>();
	    map.put("1", "one");
	    map.put("2", "two");
	    map.put("3", "three");
	    map = Collections.unmodifiableMap(map);
	    
	    map = Map.ofEntries(entry("1", "one"), entry("2", "two"), entry("3", "three"));
	    
	}
	
	*/

}
