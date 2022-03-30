package sample.unused.methods;

public class UnusedPublicFieldsAndMethods {
	
	public String unusedPublicField;
	public String usedInternally = "";
	
	
	public void unusedPublicMethod() {
		
	}
	
	
	public void usedInternally() {
		System.out.println(usedInternally);
	}
	
	public void usedIntestsOnly() {
		
	}
	
	public static void main(String[]args) {
		UnusedPublicFieldsAndMethods unused = new UnusedPublicFieldsAndMethods();
		unused.usedInternally();
		
	}

}
