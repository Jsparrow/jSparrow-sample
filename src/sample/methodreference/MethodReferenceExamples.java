package sample.methodreference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceExamples {
	
	Comparator<?> comparator;
	Comparator<?>[] comparators;
	
	void testMethodReferencesNotPossible() {
		Comparator<?> comparatorDequeOfInt = Comparator.comparingInt((Deque<Integer> x1) -> x1.getFirst());
		Comparator<?> comparatorDequeOfString = Comparator.comparing((Deque<String> x1) -> x1.getFirst());
	}
	
	void testInvalidTransformation() {

		comparator = (Integer lhs, Integer rhs) -> lhs.compareTo(rhs);
		comparator = (Integer lhs, Integer rhs) -> lhs.compareTo(rhs);
		
		Comparator<Integer> c = (lhs, rhs) -> lhs.compareTo(rhs);
		Comparator<Integer> c2 = (Integer lhs, Integer rhs) -> lhs.compareTo(rhs);
		
		c.compare(3,  5);
		c2.compare(4, 4);

		// invalid transformation
		comparators = new Comparator[] {
				(Comparator<?>) (Integer lhs, Integer rhs) -> lhs.compareTo(rhs),
				(Comparator<?>) (String lhs, String rhs) -> lhs.compareTo(rhs) 	
		};
	}
	

	void testValidTransformation() {
		comparator = (Comparator<Integer>) (Integer lhs, Integer rhs) -> lhs.compareTo(rhs);
		comparator = (Deque<Integer> lhs, Deque<Integer> rhs) -> lhs.getFirst().compareTo(lhs.getFirst());

		comparator = Comparator.comparingInt((Deque<Integer> x1) -> x1.getFirst());
		comparator = Comparator.comparing((Deque<String> x1) -> x1.getFirst());
		comparator = (Comparator<?>) Comparator.comparingInt((Deque<Integer> x1) -> x1.getFirst());
		comparator = (Comparator<?>) Comparator.comparing((Deque<String> x1) -> x1.getFirst());

		// invalid transformation
		comparators = new Comparator[] {
				(Comparator<Integer>) (Integer lhs, Integer rhs) -> lhs.compareTo(rhs),
				Comparator.comparingInt((Deque<Integer> x1) -> x1.getFirst()),
				Comparator.comparing((Deque<String> x1) -> x1.getFirst()),
				(Comparator<?>) Comparator.comparingInt((Deque<Integer> x1) -> x1.getFirst()),
				(Comparator<?>) Comparator.comparing((Deque<String> x1) -> x1.getFirst()) };

	}

}
