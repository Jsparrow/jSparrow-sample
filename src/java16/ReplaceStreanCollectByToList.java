package java16;

import java.util.List;
import java.util.stream.Collectors;

import sample.optional.User;

public class ReplaceStreanCollectByToList {

	void sendMails(List<User> users) {
		List<String> emails = users.stream().map(User::getMail).collect(Collectors.toList());
		for (String email : emails) {
			// ..
		}
	}

}