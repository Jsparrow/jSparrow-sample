package sample.make_final;

public class TestCU {
	
	private boolean value;
	
	{
		value = true;
	}
	
	private double doubleValue;
	
	public TestCU(String value) {
		if(!value.isEmpty()) {
			doubleValue = value.length();
		}
	}
	
	private static double DOUBLE_VALUE = 0.0;
	
	public TestCU(double value) {
		DOUBLE_VALUE = value;
	}
	
	public TestCU(boolean value) {
		this.value = value;
	}
	
	private int intValue = 0;
	
	private void sampleMethod() {
		final Runnable updateIntValue = new Runnable() {
			public void run() {
				final Runnable r = new Runnable() {
					
					{
						intValue = 1;
					}
					
					public void run() {}
				};
			}
		};
	}

}
