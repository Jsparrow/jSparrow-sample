package sample.loops;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapGetOrDefault {
	
	private void removeAllParameters(String one, int second, float third) {
		String t = String.valueOf(second);
	}
	
	/**
	 * Java doc for the affected method
	 * 
	 * @param first  discarded parameter
	 * @param second used parameter
	 * @param third  discarded parameter
	 */
	private void discardedParameters(String first, String second, String third) {
		consume(second);
	}
	
	void invocationSample() {
		discardedParameters("first", "second", "third");
	}
	
	private void consume(String value) {
		value.chars();
	}
	
	private void postSample(String d, Map<String, String> map) {
		String key = "key";
		String defaultValue = "";
		String value = map.getOrDefault(key, defaultValue);
		overloadedmethod(1);
		overloadedmethod("");
		
	}
	
	public void preSample(Map<String, String> map) {
		String key = "key";
		String defaultValue = "";
		String value = map.get(key);
		if(value == null) {
			value = defaultValue;
		}
		
		removeAllParameters("one", 2, 3);
		
		postSample("", new HashMap<>());
	}
	
	public void publicMethod(String unusedParameter) {
		/*
		 * Should not transform
		 */
	}
	
	protected void protectedMethod(String unusedParameter) {
		
	}
	
	void packagePrivate(String unusedParameter) {
		
	}
	
	private void overloadedmethod(String unusedParameter) {
		
	}
	
	private void overloadedmethod(int unusedParameter) {
		
	}
	

	
	class InnerClass {
		public InnerClass() {
			postSample("", Collections.emptyMap());
		}
	}

}
