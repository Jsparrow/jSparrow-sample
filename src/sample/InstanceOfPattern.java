package sample;

public class InstanceOfPattern {

	public void sampleMethod(Object o) {
		if (o instanceof String) {
			String value = (String) o;
			System.out.println(value);
		}
	}

	public void sampleMethod2(Object o) {
		if (o instanceof String value) {
			System.out.println(value);
		}
	}

}
