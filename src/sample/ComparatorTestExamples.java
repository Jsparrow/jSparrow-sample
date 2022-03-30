package sample;

import java.util.Comparator;
import java.util.function.Supplier;

public class ComparatorTestExamples {

	class TestComparatorForInnerClass {
		class InnerClass {
			String getString() {
				return toString();
			}
		}

		void test() {
			Comparator<InnerClass> comparator = (lhs, rhs) -> lhs.getString().compareTo(rhs.getString());
		}
	}

	class TestClassWithTypeParameterSupplyingComparable<T extends Supplier<Integer>> {

		Comparator<T> comparatorOfT;

		void test2() {
			comparatorOfT = (x1, x2) -> x1.get().compareTo(x2.get());
			comparatorOfT = (x1, x2) -> x2.get().compareTo(x1.get());

			comparatorOfT = (x1, x2) -> x2.get().compareTo(x1.get());
			comparatorOfT = (T x1, T x2) -> x2.get().compareTo(x1.get());
		}

		void test() {
			comparatorOfT = (x1, x2) -> x1.get().compareTo(x2.get());
			comparatorOfT = (x1, x2) -> x2.get().compareTo(x1.get());

			comparatorOfT = (T x1, T x2) -> x1.get().compareTo(x2.get());
			comparatorOfT = (T x1, T x2) -> x2.get().compareTo(x1.get());

			comparatorOfT = (Comparator<T>) (x1, x2) -> x1.get().compareTo(x2.get());
			comparatorOfT = (Comparator<T>) (x1, x2) -> x2.get().compareTo(x1.get());
		}
	}
}
