package sample.loops;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BreakingLoops {
	
	public void searchingConstantValue(List<String> values) {
		boolean found = false;
		for(String value : values) {
			if(value.equals("John")) {
				found = true;
			}
		}
	}
	
	public void preservingSideEffects(List<String> values) {
		boolean found = false;
		for(String value : values) {
			if(consumeValue(value)) {
				found = true;
			}
		}
	}
	
	
	public void matchingValueInCollection(List<String> values, Collection<String> collection) {
		boolean found = false;
		for(String value : values) {
			if(collection.contains(value)) {
				found = true;
			}
		}
	}
	
	public void wrappingStatementInBlock(List<String> values, Collection<String> collection) {
		boolean empty = false;
		for(String value : values)
			if(value.isEmpty()) 
				empty = true;
		
	}
	
	
    public void postfixExpression(List<Integer> values) {
        boolean contains = false;
        int t = 3;
        for (Integer value : values) {
            if (++value == ++t) {
                contains = true;
            }
        }
        
        System.out.print("Values: " + t + " contains = " + contains);
    }
	
    public void loopCanBeInterrupted(List<String> values, List<String> expected) {
        boolean contains = true;
        for (String value : findValues()) {
            if (expected.contains(value)) {
                contains = false;
            }
        }
    }
    
    public void loopingOnCollection() {
        boolean contains = false;
        Collection<String> collection = Collections.singletonList("value");
        for (String value : collection) {
            if (value.isEmpty()) {
                contains = true;
            }
        }
    }
    
    public void loopCanBeInterrupted2(List<String> values) {
        boolean contains = false;
        for (String value : findValues()) {
            if (value.isEmpty() || value.equals("-") || value.equalsIgnoreCase("another String")) {
                contains = true;
            }
        }
    }
    
    public void loopCanBeInterrupted3(List<String> values) {
        boolean contains = false;
        for (String value : findValues()) {
            if (!value.isEmpty() || (value.equals("-")) || value.equalsIgnoreCase("another String")) {
                contains = true;
            }
        }
    }
    
    public void loopCanBeInterrupted4(List<String> values) {
        boolean contains = false;
        for (String value : findValues()) {
            if (value.length() == 3) {
                contains = true;
            }
        }
    }
    
    public void loopCanBeInterrupted5() {
        boolean contains = false;
        List<Object> values = Collections.emptyList();
        for (Object value : values) {
            if (value.hashCode() == 37) {
                contains = true;
            }
        }
    }
    
    public void noSideEffect(List<String> values) {
        boolean contains = true;
        for (String value : values) {
            if (value.endsWith("t")) {
                contains = false;
            }
        }
    }
    
    public void noSideEffect2(List<String> values) {
        boolean contains = false;
        for (String value : values) {
            if (value.isEmpty()) {
                contains = true;
            }
        }
    }
    
    public void noSideEffect4(List<String> values) {
        boolean contains = false;
        for (String value : values) {
            if (value.endsWith(new String("--"))) {
                contains = true;
            }
        }
    }

    public void noSideEffect5(List<String> values) {
        boolean contains = false;
        for (String value : values) {
            if (findValues().contains(value)) {
                contains = true;
            }
        }
    }
    
	
    public void sideEffect(List<String> values) {
        boolean contains = true;
        for (String value : values) {
            if (consumeValue(value)) {
                contains = false;
            }
        }

        if (contains) {
            System.out.println("Value is contained");
        }
    }
    
    
    public void missingAssignmentLiteral(List<String> values) {
        boolean contains = false;
        for (String value : findValues()) {
            if (value.length() == 3) {
                contains = 3 == value.length();
            }
        }
    }
    
    public void elseStatement(List<String> values) {
        boolean contains = false;
        for (String value : findValues()) {
            if (value.length() == 3) {
                contains = true;
            } else {
            	contains = false;
            }
        }
    }
    
    public void multiple1StatementsInForBody(List<String> values) {
        boolean contains = false;
        for (String value : findValues()) {
            if (value.length() == 3) {
                contains = true;
            }
            System.out.print(value);
        }
    }

    public void multipleStatementsInIfBody(List<String> values) {
        boolean contains = false;
        for (String value : findValues()) {
            if (value.length() == 3) {
                contains = true;
                System.out.print(value);
            }
        }
    }

    private boolean computeContains() {

        return true;
    }

    private boolean consumeValue(String value) {
        System.out.println(value);
        if (value.isEmpty()) {

            System.out.println("VALUE IS EMPTY");
        }
        return value.equals("VALUE");
    }

    private List<String> findValues() {
        System.out.println("Invoked");
        return Arrays.asList("1", "2", "3");
    }

}
