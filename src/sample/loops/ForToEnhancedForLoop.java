package sample.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ForToEnhancedForLoop {

	private static final int MAX_HASH_BUCKET_LENGTH = 0;

	private static boolean hashFloodingDetected(List<?>[] hashTable) {
		for (int i = 0; i < hashTable.length; i++) {
			int bucketLength = 0;
			
			/*
			 * for (Multisets.ImmutableEntry<?> entry = hashTable[i]; entry != null; entry =
			 * entry.nextInBucket()) { bucketLength++; if (bucketLength >
			 * MAX_HASH_BUCKET_LENGTH) { return true; } }
			 */
			 
		}
		return false;
	}
	
	private void passingCollectionAsParameter() {
		List<String> list = new ArrayList<>();
		for (int i =0; i<list.size(); i++) {
			String value = list.get(i);
			if(value.contains("0")) {
				List<String> newList = new ArrayList<>();
				newList.addAll(list);
			}
		}
		
		for (int i =0; i<list.size(); i++) {
			String value = list.get(i);
			if(value.contains("0")) {
				List<String> newList = new ArrayList<>(list);
			}
		}
	}
	
	private void reassignment() {
		List<String> list = new ArrayList<>();
		for (int i =0; i<list.size(); i++) {
			String value = list.get(i);
			if(value.contains("0")) {
				List<String> newList = new ArrayList<>();
				list = newList;
			}
		}
	}
	
	private void reassignment2() {
		List<String> list = new ArrayList<>();
		for (int i =0; i<list.size(); i++) {
			String value = list.get(i);
			if(value.contains("0")) {
				List<String> newList = new ArrayList<>();
				newList = list;
			}
		}
	}
	
	private void variableInitializer() {
		List<String> list = new ArrayList<>();
		for (int i =0; i<list.size(); i++) {
			String value = list.get(i);
			if(value.contains("0")) {
				List<String> newList = list;
			}
		}
	}
	
	private void alteredCollection() {
		List<String> list = new ArrayList<>();
		for (int i =0; i<list.size(); i++) {
			String value = list.get(i);
			if(value.contains("0")) {
				List<String> newList = new ArrayList<>(list);
			}
		}
	}
	
	private void alteredArray() {
		String[] list = new String[10];
		for (int i =0; i<list.length; i++) {
			String value = list[i];
			if(value.contains("1")) {
				list = new String[3];
			}
		}
	}
	
	private void queue() {
		Queue<String> queue = null;
		
		for (int i =0; i<queue.size(); i++) {
			String value = queue.peek();
			System.out.println(value);
		}
		
		Stack<String> stack = new Stack<String>();
		for(int i=0; i<stack.size();i++) {
			String value = stack.get(i);
			if(value.isEmpty()) {
				System.out.println(value);
			}
		}
		
	}
	
	
	private void whileLoop() {
		List<String> list = new ArrayList<>();
		int i = 0;
		while(i < list.size()) { 
			String value = list.get(i);
			if(value.contains("0")) {
				list = new ArrayList<>();
			}
			System.out.println(value);
			i++;
		}
	}

}
