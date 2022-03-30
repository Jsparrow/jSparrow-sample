package sample.security;

import java.util.Random;

public class ReuseRandomObjectTests {
	
	private int r5 = 0;
	private Random r6 = new Random();
	
	private void sampleMethod1(String value) {
		Random r = new Random();
		int i = r.nextInt();
		System.out.println(value + ":" + i);
	}

	private void sampleMethod_withR3_1(String value) {
		Random r3 = new Random();
		int i = r3.nextInt();
		System.out.println(value + ":" + i);
	}
	
	private void sampleMethod_withR3_2(String value) {
		Random r3 = new Random();
		int i = r3.nextInt();
		System.out.println(value + ":" + i);
	}
	
	
	private void sampleMethod_withR4(String value) {
		if(value.isEmpty()) {
			Random r4 = new Random();
			int i = r4.nextInt();
			System.out.println("Value:" + i);
		}
		Random r4 = new Random();
		int i = r4.nextInt();
		System.out.println(value + ":" + i);
	}

	
	private static void staticSampleMethod(String value) {
		Random r2 = new Random();
		int i = r2.nextInt();
		System.out.println(value + ":" + i);
	}
	
	
	private void sampleMethod_withR5(String value) {
		Random r5 = new Random();
		int i = r5.nextInt();
		System.out.println(value + ":" + i);
	}

	private void shadowingField() {
		Random r6 = new Random();
		int i = r6.nextInt();
		System.out.println("r6: " + i);
	}
	

//private Random random = new Random();
//private static void sampleMethod(String value) {
//	Random random = new Random();
//	System.out.println(value + random.nextInt());
//}

private void sampleMethod() {}
private Runnable runnable = () -> {
	Random random = new Random();
	int i = random.nextInt();
};

}
