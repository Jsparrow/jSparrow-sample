package sample.loops;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class CastingSampleTests {
	
	public void overloadedMethods() {
		overloaded((Callable)()-> "");
	}
	
	public void overloaded(Callable<String> callable) {
		
	}
	
	public void overloaded(Supplier<String>supplier, int i) {
		
	}

}
