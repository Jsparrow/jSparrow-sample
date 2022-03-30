package sample.functionalinterface;

public class UsingUndeclaredFields {
	
	private Runnable r = new Runnable() {
		@Override
		public void run() {
			consumeRunnable(r);
		}
	};
	
	private Runnable r2 = new Runnable() {
		@Override
		public void run() {
			consumeRunnable(r);
			consumeRunnable(r3);
		}
	};
	
	private Runnable r3 = () -> {};

	
	
	private void consumeRunnable(Runnable r) {
		
	}

}
