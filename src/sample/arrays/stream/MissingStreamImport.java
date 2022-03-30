package sample.arrays.stream;

import java.util.Arrays;

public class MissingStreamImport {
	
	public void baseCase() {
		Arrays.asList("1", "2", "3").stream().forEach(value -> {});
	}

}
