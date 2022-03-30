package sample.functionalinterface;

public class UsingThis {
	
	public void usingThisKeywordIn() {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				consumeRunnable(this);
				
			}
		};
	}
	
	public void usingThisKeyword2() {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				sampleMethod(this.toString());
				
			}
		};
	}
	
	private void consumeRunnable(Runnable runnable) {
		
	}
	
	private void sampleMethod(String value) {

	}
	
	

}
