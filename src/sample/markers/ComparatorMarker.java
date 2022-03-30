package sample.markers;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.Comparator;
import java.util.List;

public class ComparatorMarker {
	
	<T extends Supplier<Integer>> void testWithArrayListOfTSupplyingInteger() {
		
		ArrayList<T> arrayList = new ArrayList<>();
		arrayList.sort(Comparator.comparingInt(T::get));
	}
	
	public void usingInefficientConstructors() {
		Integer intValue = new Integer("10");
		Comparator<Integer> c = (i1, i2) -> i2.compareTo(i1);
		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
	}
}
