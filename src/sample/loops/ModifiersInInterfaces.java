package sample.loops;



public interface ModifiersInInterfaces {
	
	public String PUBLIC_FIELD = "";
	
	public static String PUBLIC_STATIC_FIELD = "";
	
	public static final String PUBLIC_STATIC_FINAL_FIELD = "";
	
	
	void method();
	
	public void publicMethod();
	
	public static void publicStaticMethod() {
		
	}
	
	public default void publicDefaultVoidMethod() {
		
	}
	

}
