package sample;

import java.util.Comparator;
import java.util.function.Supplier;

import sample.flattern.Address;
import sample.flattern.User;

public class UsingComparators {
	
	class TestClassWithTypeParameterSupplyingComparable<T extends Supplier<Integer>> {

		Comparator<T> comparatorOfT;

		void test() {
			comparatorOfT = (x1, x2) -> x1.get()
				.compareTo(x2.get());
			comparatorOfT = (x1, x2) -> x2.get()
				.compareTo(x1.get());

			comparatorOfT = (T x1, T x2) -> x1.get()
				.compareTo(x2.get());
			comparatorOfT = (T x1, T x2) -> x2.get()
				.compareTo(x1.get());

			comparatorOfT = (Comparator<T>) (x1, x2) -> x1.get()
				.compareTo(x2.get());
			comparatorOfT = (Comparator<T>) (x1, x2) -> x2.get()
				.compareTo(x1.get());
		}
	}
	
	public void comparingUsers() {
		User user1 = new sample.flattern.User(
				"email", "011223345", "John", "Snow", 
				new Address("street", "1010", "Castle Black", "Seven Landings"));
		User user2 = new sample.flattern.User(
				"email", "011223345", "Rob", "Stark", 
				new Address("street", "7010", "Winterfell", "Seven Landings"));
		
		Comparator<User> c1 = (u1, u2) -> u1.getFirstName().compareTo(u2.getFirstName());
		Comparator<User> c2 = (u3, u4) -> u3.getLastName().compareTo(u4.getLastName());
		Comparator<User> comparator = c1.thenComparing(c2);
		comparator.compare(user1, user2);
	}
	
//	public int comparingDoubles(User john, User rob) {
//		Comparator<Double> comparator = (val1, val2) -> val1.compareTo(val2);
//		Comparator<User> userComparator = (u1, u2) -> u1.getSalary().compareTo(u2.getSalary());
//		
//		Comparator<User> newUserComparator = Comparator.comparingDouble(User::getSalary);
//		return userComparator.compare(john, rob);
//	}
	
	public int comparingNaturalOrder(User john, User snow) {
		Comparator<User> comparator = (User u1, User u2) -> u1.compareTo(u2);
		Comparator<User> naturalOrder = Comparator.naturalOrder();
		return comparator.compare(john, snow);
	}
	
	public int comparingReverseOrder(User john, User snow) {
		Comparator<User> comparator = (User u1, User u2) -> u2.compareTo(u1);
		Comparator<User> reverseOrder = Comparator.reverseOrder();
		return comparator.compare(john, snow);
	}
	
	public int comparing(User john, User snow) {
		Comparator<User> comparator = (User u1, User u2) -> u1.getEmail().compareTo(u2.getEmail());
		Comparator<User> comparing = Comparator.comparing(User::getEmail);
		return comparator.compare(john, snow);
	}

}
