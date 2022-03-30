package sample.junit;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

//import org.junit.Test;

//import org.junit.jupiter.api.Test;

//import junit.framework.TestCase;

public class ReturnValueWithAmbiguousTypeAsArgumentTest 
	extends TestCase 
	{

//	@Test
	public void test() {
		assertEquals(getGenericTurnValue1(), getGenericTurnValue2());
		assertEquals(getGenericTurnValue1(), getGenericTurnValue2(), getGenericTurnValue3(), getGenericTurnValue4());
		assertEquals(getGenericTurnValue(getGenericTurnValue1()), getGenericTurnValue(getGenericTurnValue2()));
	}
	
	<T> T getGenericTurnValue(T arg) {
		return arg;
	}

	@SuppressWarnings("unchecked")
	<T> T getGenericTurnValue1() {
		return (T)Byte.valueOf((byte) 0);
	}
	
	@SuppressWarnings("unchecked")
	<T> T getGenericTurnValue2() {
		return (T)Byte.valueOf((byte) 0);
	}
	
	@SuppressWarnings("unchecked")
	<T> T getGenericTurnValue3() {
		return (T) Byte.valueOf((byte) 0);
	}
	
	@SuppressWarnings("unchecked")
	<T> T getGenericTurnValue4() {
		return (T) Byte.valueOf((byte) 0);
	}
}
