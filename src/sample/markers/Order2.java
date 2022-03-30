package sample.markers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Order2 {

	public List<String> items;
	public BigDecimal totalPrice;

	public Order2(List<String> items, BigDecimal totalPrice) {
		this.items = items;
		this.totalPrice = totalPrice;
	}

	public List<String> getItems() {
		return items;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void checkingMarkers() {

		Runnable r = () -> {
			System.out.print("");
		};
		
		r.run();

		r = () -> {
			System.out.print("");
		};

		System.out.print("");
		r.run();
		r = () -> {
			System.out.print("");
		};
		r.run();
		
		r = () -> {
			System.out.print("");
		};

		r.run();
		r =  new Runnable() {
			@Override
			public void run() {
				System.out.print("");
			}
		};
		r.run();
	}

	public void usingComparators() {
		Comparator<Integer> comparator = (lhs, rhs) -> lhs.compareTo(rhs);
		comparator.compare(5, 10);
		
		Comparator<Integer> comparator2 = (lhs, rhs) -> rhs.compareTo(lhs);
		comparator2.compare(5, 10);
	}
	
	<T extends Supplier<Integer>> void testWithArrayListOfTSupplyingInteger() {
		ArrayList<T> arrayList = new ArrayList<>();
		arrayList.sort((T x1, T x2) -> x1.get().compareTo(x2.get()));
		arrayList.sort(Comparator.comparingInt((x1) -> x1.get()));
	}
	
	<T extends Comparable<T>> void testWithArrayListOfT() {
		ArrayList<T> arrayList = new ArrayList<>();
		arrayList.sort((T x1, T x2) -> x1.compareTo(x2));
	}
	
	public void usingInefficientConstructors() {
		Boolean value = new Boolean("true");
		Boolean value2 = Boolean.valueOf("true");
		Boolean value4 = Boolean.valueOf("false");
		Integer intValue = new Integer("10");
		Double doubleValue = new Double("10.0");
		doubleValue = Double.valueOf("25.0");
		System.out.print(value.toString() + value2 + intValue + value4 + doubleValue);
	}

	public void lambdaToMethodReference() {
		Predicate<String> isEmpty = (String s) -> s.isEmpty();
		Function<String, Double> doublePistol = value -> new Double(value);
		String value = "someValue";
		Predicate<String> checker = v -> value.equals(v);
		isEmpty.test("");
	}
	
	public void usePutIfAbsent(Map<Integer, Integer> map2) {
		Map<Integer, Integer> map = new HashMap<>();
		if (!map.containsKey(1)) {
			map.put(1, 2);
		}
		
		if (!map.containsKey(2)) {
			map.put(2, 3);
		}
		
		if (!map.containsKey(2)) {
			map.put(2, 3);
		}
	}
	
	public void nullCheckBeforeInstanceOf(Object object) {
		Object name = new Object();
		if(name != null && name instanceof String) {
			System.out.println(name);
		}
		
		if(name != null && name instanceof String && name.toString().isEmpty()) {
			String value = (String)name;
			System.out.println(value);
		}
		
		boolean condition = name != null && name instanceof String;
	}
	
	public void useStringLiteralEqualityCheck() {
		String value = "";
		if(value.equals("")) {
			System.out.println("IsEmpty");
		}
		
		if(value.equals("diti")) {
			System.out.println("is not Empty");
		}
		
		if(value.equals("diti")) {
			System.out.println("is not Empty");
		}
	}
	
	public void primitiveBoxedForString(long l, int myInt) {
		String myIntString = new Integer(4).toString();
		String myLongValue = new Long(l).toString();
		String value3 = Integer.valueOf(myInt).toString();
		String value4 = 4 + "";
		System.out.println(myIntString + myLongValue + value3 + value4);
		
	}
	
	public void equalsInEnumConstants(Day day) {
		if(day.equals(Day.MONDAY)) {
			
		}
		
		if(day.equals(Day.TUESDAY)) {
			
		}
		
	}
	
	private void comparingSizeZero(String value, Collection<String>values, Map<String, String>map) {
		if(value.length() == 0) {
			
		}
		
		if(values.size() == 0) {
			values.add("");
			values.add("");
			values.add("");
			values.add("");
			values.add("");
			values.add("");
			values.add("");
			values.add("");
			values.add("");
			values.add("");
			values.add("");
		}
		
		if(map.size() == 0) {
			
		}
	}
	
	enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}
}
