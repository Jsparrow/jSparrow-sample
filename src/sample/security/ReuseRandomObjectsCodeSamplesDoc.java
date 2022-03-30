package sample.security;

import java.security.SecureRandom;
import java.util.Random;

public class ReuseRandomObjectsCodeSamplesDoc {
	
	public void sampleMethod(String value) {
		Random random = new Random();
		int nextIndex = random.nextInt();
		//...
	}

}
