package sample;


public class StringUtilsInnerClassCornerCaseRule {

	public int testIndexOf(String testString) {
		return testString.indexOf("e");
	}
	
	class StringUtils {
		public int indexOf(String s1, String s2) {
			// do nothing
			return 0;
		}
	}
}
