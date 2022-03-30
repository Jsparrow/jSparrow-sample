package sample.markers.model;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User> {

	private String name;
	private String email;
	private String id;

	public User(String name, String email, String id) {
		super();
		this.name = name;
		this.email = email;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", id=" + id + "]";
	}

	@Override
	public int compareTo(User o) {
		Comparator<User> comparator = Comparator.comparing(User::getName)
				.thenComparing(User::getEmail)
				.thenComparing(User::getId);
		return comparator.compare(this, o);
	}

}
