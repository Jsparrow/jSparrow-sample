package sample.loops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EnhancedForLoopToStreamTakeWhile {
	
	
	public void savingComments(List<String> values) {
		/* 1 */
		for/* 2 */(/* 3 */String /* 4 */value /* 5 */:/* 6 */ values/* 7 */) /* 8 */{/* 9 */
			/* 10 */if/* 11 */(/* 12 */value.isEmpty()/* 13 */)/* 14 */ {/* 15 */
				/* 16 */
				break;
				/* 17 */
			}/* 18 */
			/* 19 */
			System.out.println(value);/* 20 */
		}/* 21 */
	}
	
	public void usingTakeWhile(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) {
				break;
			}
			System.out.println(value);
		}
	}
	
	public void visit_singleThenBody_shouldTransform(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) 
				break;
			
			System.out.println(value);
		}
	}
	
	public void negatingCondition(List<String> values) {
		for(String value : values) {
			if(!value.isEmpty()) {
				break;
			}
			System.out.println(value);
		}
	}
	
	public void multipleRemainingStatements(List<String> values) {
		for(String value : values) {
			if(!value.isEmpty()) {
				break;
			}
			System.out.println(value);
			value.length();
			value.chars();
		}
	}
	
	public void usingNonEffectivelyFinalVariables(List<String> values) {
		int i = 0;
		for(String value : values) {
			if(value.isEmpty()) {
				break;
			}
			i++;
			System.out.println(value);
		}
	}
	
	public void usingMoreThanOneExpressionInIfBody(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) {
				value.length();
				break;
			}
			System.out.println(value);
		}
	}
	
	public void thenElseStatement(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) {
				break;
			} else {
				value.length();
			}
			System.out.println(value);
		}
	}
	
	public void missingIfStatement(List<String> values) {
		for(String value : values) {
			values.add("");
			System.out.println(value);
		}
	}
	
	public void missingBreakStatement(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) {
				value.length();
			}
			System.out.println(value);
		}
	}
	
	public void havingReturnStatement(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) {
				return;
			}
			System.out.println(value);
		}
	}
	
	public void havingReturnStatement2(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) {
				break;
			}
			System.out.println(value);
			return;
		}
	}
	
	public void havingThrowsStatement(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) {
				break;
			}
			System.out.println(value);
			throw new RuntimeException();
		}
	}
	
	public void havingContinueStatement(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) {
				break;
			}
			if(value.length() > 1) {				
				continue;
			}
			System.out.println(value);
		}
	}
	
	public void emptyRemainingBody_shouldNotTranform(List<String> values) {
		for(String value : values) {
			if(value.isEmpty()) {
				break;
			}
		}
	}
	
	public void iteratingOverArrays(String[] values) {
		for(String value : values) {
			if(value.isEmpty()) {
				break;
			}
			System.out.println(value);
		}
	}
	
	public void iteratingOverMaps() {
		Map<String, String> map = new HashMap<>();
		Set<Entry<String, String>> entrySet = map.entrySet();
		for(Map.Entry<String, String> entry : entrySet) {
			if(entry.getKey().isEmpty()) {
				break;
			}
			System.out.println(entry.getValue());
		}
		
		
//		map.entrySet()
//		.stream()
//		.takeWhile(entry -> entry.getKey().isEmpty())
//		.forEach(entry -> {System.out.println(entry.getValue());});
	}

}
