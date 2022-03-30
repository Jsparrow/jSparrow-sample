package sample.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddAll {
	
	/*
	 * Corner cases for Collections AddAll rule
	 */
	
	public void baseCase() {
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList("1", "2", "3"));
	}
	
	public void savingComments() {
		Set<String> set = new HashSet<>(/*1 */);
		/*2 */
		set./*3 */addAll(/* 4*/Arrays.asList("1", "2", "3"))/* 5*/;
		/* 6*/
	}
	
	public void addAllWithQualifiedName() {
		InnerClass ic = new InnerClass();
		List<String> list = new ArrayList<>();
		ic.list.addAll(new ArrayList<>());
	}
	
	public void singleBodyStatement(int i) {
		List<String> list = new ArrayList<>();
		if(i > 0) 
			list.addAll(Arrays.asList("1", "2"));
		
	}
	
	public void multipleDeclarationFragments(int i) {
		List<String> list = new ArrayList<>(), list2 = new ArrayList<>();
		list.addAll(Arrays.asList("1", "2"));
		
	}
	
	public void addAllWithMultipleParameters(int i) {
		List<String> list = new ArrayList<>();
		list.addAll(i, Arrays.asList("1", "2"));
	}
	
	public void differentNames() {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		list1.addAll(Arrays.asList("1", "2"));
		list2.addAll(Arrays.asList("1", "2"));
	}
	
	public boolean returnStatement() {
		List<String> list1 = new ArrayList<>();
		return list1.addAll(Arrays.asList("1", "2"));
	}
	
	
	
	public void addAllToSelf() {
		List<String> list1 = new ArrayList<>();
		list1.addAll(list1);
	}
	
	
	public void anonymousClass() {
		List<String> list1 = new ArrayList<String>() {
			@Override
			public boolean addAll(Collection<? extends String>collection) {
				return false;
			}
		};
		list1.addAll(Arrays.asList("1", "2"));
	}
	
	public void nullInitialization() {
		List<String> list1 = null;
		list1.addAll(Arrays.asList("1", "2"));
	}
	
	List<String> field = new ArrayList<>();
	public void addAllToField() {
		field.addAll(Arrays.asList("1", "2"));
	}
	class InnerClass {
		List<String> list = new ArrayList<>();
	}


}
