package sample.arrays.stream;

import java.util.Arrays;

public class MoreCodeSamplesFromVisitorTests {

	private void sampleCode() {
		Arrays.asList("1", "2", "3").stream();
		String[] values = new String[] { "1", "2", "3" };
		Arrays.stream(values);
	}

	private void sampleCode2() {
		Arrays.asList("1", "2", "3").stream();
		Arrays.stream(new String[] { "1", "2", "3" });
	}

	private void sampleCodeWithSpezialedStream() {
		Arrays.asList(1, 2, 3).stream();
		Arrays.stream(new int[] { 1, 2, 3 });
	}

	private void sampleCodeCompatibleStreamChain() {
		Arrays.asList(1, 2, 3).stream().filter(value -> value > 0).filter(value -> {
			System.out.println(value);
			return true;
		}).mapToInt(i -> i);

		Arrays.asList(1, 2, 3).stream().filter(value -> value > 0).filter(value -> value < 1).forEach(val -> {
		});
	}

	private void invoceMethodInBoxedType() {
		Arrays.asList(1, 2, 3).stream().map((Integer value) -> value + 3).forEach(val -> {
		});

		Arrays.stream(new int[] { 1, 2, 3 }).map(value -> value + 3).forEach(val -> {
		});
	}

	private void usingMethodReferences() {
		Integer expected = 5;
		Arrays.asList(1, 2, 3).stream().filter(expected::equals).forEach(val -> {
		});
	}
	
	private void missingArguments() {
		Arrays.asList().stream().forEach(val -> {});
	}
	
	private void staticImportAsList() {
		Arrays.asList(1, 2, 3).stream().forEach(val -> {});
	}
	
	/*
	 * Code changes
	 */

	public void avoidBoxingOfIntStream() {
		Arrays.asList(1, 2, 3).stream()
			.forEach(this::consumePrimitiveInt);
	}
	
	public void usingStreamOf() {
		Arrays.asList("1", "2", "3").stream()
			.forEach(this::consumeString);
	}
	
	public void existingStringArray() {
		String [] stringArray = stringArrayFactory();
		Arrays.asList(stringArray).stream()
			.forEach(this::consumeString);
	}
	
	public void existingIntArray() {
		int []intArray = intArrayFactory();
		Arrays.asList(intArray).stream().forEach(val -> {});
	}
	
	private int[] intArrayFactory() {
		return new int[] {};
	}
	
	private String[] stringArrayFactory() {
		return new String[] {};
	}
	
	private void consumePrimitiveInt(int vlaue) {}
	
	private void consumeString(String value) {}
	
	
	
	
}
