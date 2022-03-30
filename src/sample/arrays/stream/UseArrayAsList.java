package sample.arrays.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UseArrayAsList {
	
	private void chainOfStreamMethods() {
		Arrays.asList(1, 2, 3).stream()
			.filter(value -> value > 0)
			.filter(value -> {
				System.out.println(value);
				return true;
			})
			.map(value -> String.format("Value: %s", value))
			.forEach(this::consume);
	}
	
	public void consume(String value) {
		
	}
	
	public void simpleNameAsParameter() {
		int []arrayOfInts = {1, 2, 3, 4, 5};
		String[] arrayOfString = {"1", "two"};
		
		Stream<String> stream = Arrays.asList(arrayOfString).stream();
		stream = Arrays.stream(arrayOfString);
		
//        Stream<String> stream = Arrays.asList(arrayOfString).stream();
//        Stream<Integer> intStream = Arrays.asList(arrayOfInts).stream();
        List<int[]> list = Arrays.asList(arrayOfInts);
        List<Integer> varArgsParameter = Arrays.asList(1, 2, 3, 4);
        stream = Arrays.stream(arrayOfString);
        
        Stream<Integer> values = Stream.of(1, 2, 3, 4);
        List<int[]> listFromIntArray = Arrays.asList(arrayOfInts);
        List<String> listFromArrayOfStrings = Arrays.asList(arrayOfString);
	}
	
	public void varArgsAsParameters() {
		Stream<String>stream = Arrays.asList("1", "2", "3").stream();
		Stream<String>streamofStrings = Arrays.stream(new String[] {"1", "2", "3"});
		
		Stream<Integer> streamOfBoxedInts = Arrays.asList(1, 2, 3, 4).stream();
		IntStream streamOfInts = Arrays.stream(new int[] {1, 2, 3, 4});
//		streamOfBoxedInts = Arrays.stream(new int[] {1, 2, 3, 4});
		
//		 List<Integer> values = Arrays.asList().stream(new int[] {1, 2, 3, 4}).collect(Collectors.toList());
		Arrays.asList(1, 2, 3, 4).stream().map(val -> (val++).toString());
//		Arrays.stream(new int[] {1, 2, 3, 4}).filter(val -> (val++).toString().length()> 1);
		IntStream intStram = Arrays.stream(new int[] {1, 2, 3});
		
		
	}
	
	public void streamOfExamples() {
		Stream<Integer> streamOfInts 		= Stream.of(1, 2, 3);
		Stream<int[]> streamOfArrayInt 		= Stream.of(new int[] {1, 2, 3});
		Stream<Integer> streamOfSingleInt	= Stream.of(1);
		Stream<String> streamOfStringArray 	= Stream.of(new String[] {"1", "2", "3"});
		Stream<String> streamOfVarargStrings = Stream.of("1", "2", "3");
		Stream<String> streamOfSingleString = Stream.of("1");
		
		
	}
	
	public void variations(int []intArray, String[]stringArray) {
		
		Stream<int[]> retType = Arrays.asList(intArray).stream();
			// -> Stream.of(intArray)
		Arrays.asList(1).stream();
		Arrays.asList(1, 2, 3).stream();
			// Arrays.stream(new int[]{1, 2, 3}) -> a check is required to verify if the new IntStream is compatible with the existing Stream<Integer>
		Arrays.asList(stringArray).stream();
			// Stream.of(stringArray)
		Arrays.asList("1").stream();
		Arrays.asList("1", "2" , "3").stream();
			// Stream.of("1", "2", "3") or Stream.of("1")
		
		
	}
	
	public void variations2(int []intArray, String[]stringArray) {
		
		Stream<int[]> retType = Stream.of(intArray);
			// -> Stream.of(intArray)
		Arrays.asList(1).stream();
		Arrays.asList(1, 2, 3).stream();
			// Arrays.stream(new int[]{1, 2, 3}) -> a check is required to verify if the new IntStream is compatible with the existing Stream<Integer>
		Stream.of(stringArray);
			// Stream.of(stringArray)
		Stream.of("1");
		Stream.of("3", "2", "1");
			// Stream.of("1", "2", "3") or Stream.of("1")
	}
	
	public void checkingCompatibility() {
		Arrays.asList(1, 2, 3).stream()
			.filter(value -> value > 0)
			.filter(value -> {
				System.out.println(value);
				return true;
			})
			.mapToInt(i -> i);
		
		Arrays.asList(1, 2, 3).stream()
		.filter(value -> value > 0)
		.filter(value -> {
			System.out.println(value);
			return true;
		})
		.forEach(i -> {
			
		});
		
		Arrays.asList(1, 2, 3).stream()
			.map(value -> value + 0)
			.forEach(i -> {});
		
		Arrays.asList(1, 2, 3).stream()
			.filter((Integer value) -> value > 0)
			.forEach(i -> {});
		
		Arrays.asList(1, 2, 3).stream()
			.map(Integer::intValue)
			.forEach(i -> {});
		Arrays.asList(1, 2, 3).stream()
		.filter(value -> value.intValue() > 0)
		.forEach(i -> {});
		
		Arrays.asList(1, 2, 3).stream()
			.collect(Collectors.toList());
	}
	

}
