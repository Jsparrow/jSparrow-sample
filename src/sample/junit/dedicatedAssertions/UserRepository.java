package sample.junit.dedicatedAssertions;

public interface UserRepository {
	
	User findById(String id);
	
	User findById(int id);
	
	User save(User user);

}
