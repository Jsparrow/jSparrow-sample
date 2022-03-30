package sample.casting;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import sample.optional.User;

public class TypeVariables<T extends User> {
	
	List<T> users;
	
	public List<T> findUsers() {
		Function<Object, String> function = (Function<Object, String>) Object::toString;
		Supplier<String> function2 = (Supplier<String>) super::toString;
		Supplier<Object> sup = (Supplier<Object>) Object::new;
		Predicate<List<String>> function4 = (Predicate<List<String>>) List<String>::isEmpty;
		List<T> myUsers = users;
		return myUsers;
	}
	
	public <T extends User> List<T> findAllUsers() {
		List<T> someUsers = (List<T>)users;
		return (List<T>) users;
	}
}
