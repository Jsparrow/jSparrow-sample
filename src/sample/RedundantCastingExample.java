package sample;

import java.util.function.Supplier;

public class RedundantCastingExample {
	

	public void castingNeededForTypeVariables(Object o) {
		
		findSomething((Foo)getFoo());
		findSomething(getFoo());
		findSomething(getSomething(o));
		findSomething((Foo)getSomething(o));
		findSomething(getFooSubtype(o));
		findSomething((Foo)getFooSubtype(o));
		findSomething((Foo)getFooSubtype(o)).fooMethod();
		
		
		useFoo((Foo)getFooSubtype(o)).fooMethod();
		useFoo(getFooSubtype(o)).fooMethod();
		
		
		findSomething((Foo)getFoo()).fooMethod();
		findSomething(getFoo()).fooMethod();
	}
	
	public void lambdas() {
		usingObject((Supplier<String>)() -> "");
		Object object = (Supplier<String>) () -> "";
		usingSupplier((Supplier<String>)() -> ""); 
		Supplier<String> supplier = (Supplier<String>) () -> "";
		
		Runnable r =  () -> {};
	}
	
	private void usingSupplier(Supplier<String>supplier) {
		
	}
	
	private void usingObject(Object supplier) {
		
	}
	
	public void primitiveCasting() {
		int i = 0, i2 = 2;
		double d = 2.1, d2 = 2.2;
		float f = 3.2F;
		boolean bool = false;
		byte b = 0;
		char c = 'c';
		short s = 0;
		long l = 0, l2, l3;
		
		
		i = (int)d;
		i = (int) f;
		i = (int)i2;
		i = (int) 5;
		
		d = (double)i;
		d = (double)f;
		
		d = (double)d2;
		
		l2 = (long)l;
		l3 = l;
		
	}
	
	
	public String castingString(String param) {
		String s = (String)param;
		return s;
	}
	
	public String assignmentWithoutCasting() {
		String s = "2";
		return s;
	}
	
	public int castingInt() {
		int i = (int)3;
		 return i;
	}
	
	public int assigningIntWithoutCasting() {
		int i = (int)4;
		return i;
	}
	
	public String objectToString(Object o) {
		String s = (String)o;
		return s;
	}
	
	public Object stringToObject(String s) {
		Object o = (Object)s;
		return s;
	}
	

	
	Foo getFoo() {
		return null;
	}
	
	<T> T getSomething(T t) {
		return null;
	}
	
	<T extends Foo> T getFooSubtype(Object o) {
		return (T)new Foo();
	}
	
	
	private <T extends Object> T findSomething(T t) {
		return t;
	}
	
	<T extends Foo> T useFoo(Foo foo) {
		return (T)new Foo();
	}
 	

}
