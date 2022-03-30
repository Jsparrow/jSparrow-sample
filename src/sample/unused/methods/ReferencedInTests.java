package sample.unused.methods;

public class ReferencedInTests {

	public void foo2() {}
	
	public String multipleReferencesInTheSameTestCase() {
		int var = 0;
		return "multiple invocations in the same test";
	}
}
