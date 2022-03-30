package sample.casting;

import java.util.List;

public class OverloadedMethods {
	
	public void usingIterable(String value, Iterable<String> values) {
		
	}
	
	public void usingIterable(CharSequence value, Iterable<CharSequence> values) {
		
	}
	
	public void usingList(String value, List<String> values) {
		
	}
	
	public void usingList(CharSequence value, List<CharSequence> values) {
		
	}
	
	public void usingList(Integer value, List<Integer> values) {
		
	}

}
