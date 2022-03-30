package sample;

import java.util.Random;

public class UseSecureRandom {
	
//	private Random random = new Random(seed);

	
	
	private Random random = new Random(getSeed());
	private Random withStaticFinalSeed = new Random(seed);
	public void usingSecureRandom() {
	}
	
	private static final int seed = 10;
	public void sampleMethod() {
	}

	private int getSeed() {
		return 0;
	}
}
