package sample.methodreference;

import java.util.ArrayDeque;

import java.util.Deque;

import java.util.function.Function;

public class BugDemo {

	void testValidTransformation() {

		Function<? super ArrayDeque<Integer>, Number> jokerSuperArrayDequeToInteger = (Deque<Integer> x1) -> x1.getFirst();
		Function<Deque<Integer>, Integer> DequeOfIntegerToInteger = (Deque<Integer> x1) -> x1.getFirst();

		Function<? super Deque<Integer>, Integer> jokerSuperDequeToInteger = (Deque<Integer> x1) -> x1.getFirst();
		Function<? super Deque<Integer>, Number> jokerSuperDequeToInteger2 = (Deque<Integer> x1) -> x1.getFirst();

		Function<? super Deque<Integer>, Comparable<?>> jokerSuperDequeToComparable = (Deque<Integer> x1) -> x1.getFirst();
		Function<? super ArrayDeque<Integer>, Comparable<?>> jokerSuperArrayDequeToComparable = (Deque<Integer> x1) -> x1.getFirst();
		Function<? super Deque<Integer>, ? extends Comparable<?>> jokerSuperDequeToJokerExtendsComparable = (Deque<Integer> x1) -> x1.getFirst();
		Function<? extends Deque<Integer>, Integer> jokerExtendsDequeToInteger = (Deque<Integer> x1) -> x1.getFirst();
		Function<? extends Deque<Integer>, Comparable<?>> jokerExtendsDequeToComparable = (Deque<Integer> x1) -> x1.getFirst();
		Function<? extends Deque<Integer>, ? extends Comparable<?>> jokerExtendsDequeToJokerExtendsComparable = (Deque<Integer> x1) -> x1.getFirst();
	}

	void testInvalidTransformation() {

		Function<? extends Deque<? super Integer>, Integer> jokerToInteger4 = (Deque<Integer> x1) -> x1.getFirst();
		Function<? extends Deque<? super Integer>, Integer> jokerToInteger41 = (ArrayDeque<Integer> x1) -> x1.getFirst();
		Function<? extends Deque<Integer>, Integer> jokerExtendsDequeToInteger1 = (ArrayDeque<Integer> x1) -> x1.getFirst();

		Function<? extends Deque<? extends Integer>, Integer> jokerToInteger5 = (Deque<Integer> x1) -> x1.getFirst();
		Function<? extends Deque<? extends Comparable<?>>, Integer> jokerToInteger51 = (Deque<Integer> x1) -> x1.getFirst();

		Function<?, ?> jokerToJoker = (Deque<Integer> x1) -> x1.getFirst();

		Function<?, ? extends Comparable<?>> jokerToJokerExtendsComparable = (Deque<? extends Comparable<?>> x1) -> x1.getFirst();

		Function<?, Integer> jokerToInteger = (Deque<Integer> x1) -> x1.getFirst();

		FunctionToInt<?> localFunction = (Deque<Integer> x1) -> x1.getFirst();

	}

	interface FunctionToInt<T> extends Function<T, Integer> {

	}
}
