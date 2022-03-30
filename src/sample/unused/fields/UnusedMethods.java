package sample.unused.fields;

public class UnusedMethods {
	
	private String value = usedMethods();
	

	public void publicUnusedTestedMethod() {
		
	}
	
	public void publicUnusedMethod() {
		
	}
	

	
	protected void protectedUnusedMethod() {
		
	}
	
	private void privateUnusedMethod() {
		
	}
	
	private void unusedMethod() {
		System.out.println("This method is not used");
	}
	
	private String usedMethods() {
		return "used";
	}

}
