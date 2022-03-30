package sample.markers;

import java.io.Serializable;

public class ReimplementingInterface extends Parent implements Comparable<User>, Foo, Serializable {
	@Override
	public int compareTo(User o) {
		return 0;
	}
}

class Parent implements Comparable<User>, Foo {
	@Override
	public int compareTo(User o) {
		return 0;
	}
}

interface Foo {
}

class User {
}
