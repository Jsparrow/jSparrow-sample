package sample;

import java.util.List;
import java.util.Collections;

public class CollectionsSingleTonListTest {
	
	
	public void baseCase() {
		List<String> list = Collections.singletonList("value");
		List<String> emptyList = Collections.emptyList();
	}
	
	
	public void usingStaticImport() {
//		List<String> list = asList("value");
		List<String> emptyList = Collections.emptyList();
	}
	
	public void usingFullyQualifiedNames() {
		List<String> list = Collections.singletonList("value");
		List<String> emptyList = Collections.emptyList();
	}
	
	public void moreThanOneOperatorParameter() {
		List<String> list = Collections.singletonList("1");
	}
	
//	private List<String> asList() {
//		return Arrays.asList();
//	}

}
