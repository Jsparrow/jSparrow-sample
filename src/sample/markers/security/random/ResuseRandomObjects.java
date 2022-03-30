package sample.markers.security.random;

import java.util.Random;

public class ResuseRandomObjects {

	public void sampleMethod(String value) {
	    Random random = new Random();
	    int nextIndex = random.nextInt();
	    //...
	}
	
	public static void staticSampleMethod(String value) {
	    Random random = new Random();
	    int nextIndex = random.nextInt();
	    //...
	}
}
