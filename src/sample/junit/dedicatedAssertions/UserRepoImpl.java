package sample.junit.dedicatedAssertions;

public class UserRepoImpl implements UserRepository {

	@Override
	public User findById(int id) {
		return new User(id, "John", "Snow");
	}

	
	@Override
	public User findById(String id) {
		return new User(Integer.parseInt(id), "John", "Snow");
	}


	@Override
	public User save(User user) {
		return user;
	}
}
