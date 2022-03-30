package sample.casting;

import java.util.Arrays;
import java.util.List;

public class CasesUsingOverloadedMethods {
	
	public void usingOverloadedWithIterable(OverloadedMethods om) {
		om.usingIterable("", (List<String>)Arrays.asList("", ""));
		om.usingList("", (List<String>) Arrays.asList("", ""));
		om.usingList(15, Arrays.asList(1, 2, 3));
	}

}
