package sample.junit.inefficientConstructors;

public class BoxedPrimitives {
	
	public Short createFromString(String shortValue) {
		short s2 = 3;
		Short s3 = new Short(s2);
		Short.parseShort(shortValue);
		Short s = new Short(shortValue);
		char c = 'a';
		Character character = new Character(c);
		return s;
	}

}
