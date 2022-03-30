package sample.arrays.stream;

import static java.util.Arrays.asList;

import java.util.Arrays;

public class UsingStaticImports {
	
	public void baseCase() {
		asList("1", "2", "3").stream().forEach(value -> {});
	}
	
	public void baseCaseWithIntStream() {
		asList(1, 2, 3).stream().forEach(value -> {});
		Arrays.stream(new int[] {1, 2, 3}).forEach(value -> {});
	}

}
