package sample.functionalinterface;

public interface InterfaceWithDefaultMethod {
	
	String sampleMethod();
	
	default String defaultSampleMethod() {
		return "";
	}

}
