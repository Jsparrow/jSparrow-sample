package sample.make_final;

public class TestCu3 {
	
	private String value = "";
	
	public class InnerClass {
		private String value2;
		public InnerClass() {
			value = "2";
			value2 = "3";
		}
	}
	
private void sampleMethod(String value) {
	class Local {
		private String value = "";
	}
	final Local local = new Local();
	local.value = "2";
	
}


}
