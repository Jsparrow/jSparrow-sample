package sample.markers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import sample.markers.model.User;

public class UseListSort {

	public void sortUsersById_original(List<User> users) {
		Comparator<User> comparator = Comparator.naturalOrder();
		Collections.sort(users, comparator);
	}

	public void sortUsersById_expected(List<User> users) {
		Comparator<User> comparator = Comparator.naturalOrder();
		users.sort(comparator);
	}

	public void foo() {
		List<String> values = Collections.emptyList();
		Comparator<String> comparator = Comparator.naturalOrder();
		Collections.sort(values, comparator);
	}

}
