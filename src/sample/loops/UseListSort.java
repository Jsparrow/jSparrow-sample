package sample.loops;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;

public class UseListSort {
	
	public void baseCase() {
		List<String> strings = Collections.emptyList();
		Comparator<String> comparator = (String string1, String string2) -> string1.compareTo(string2);
		Collections.sort(strings, comparator);
		sort(strings, comparator);

		
		
		Collections.sort(strings, (String string1, String string2) -> string1.compareTo(string2));
		Collections.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
	}
	
	public void sortUsers(List<User> users) {
		Collections.sort(users, (User o1, User o2) -> o1.getId() - o2.getId());
	}
	
	class User {
		public int getId() {
			return 0;
		}
	}
	
	public void negativeCases(List<String> strings, Comparator<String> comparator) {
		Collections.sort(strings);
		sort(strings, comparator);
		
		
	}

}
