package sample.functionalinterface;

public class FunctionalInterfaces {
	
	
	public void usingInterfaceWithField() {
		InterfaceWithField iwf = new InterfaceWithField() {
			@Override
			public void singleMethod() {
				System.out.print(FIELD.CUSTOM_CLASS_FIELD);
			}
		};
		
		iwf.singleMethod();
	}
	
	public void usingChildInterface() {
		ChildInterface ci = new ChildInterface() {

			@Override
			public void singleMethod() {
				System.out.println(PARENT_FIELD);
				System.out.println(CHILD_FIELD);
				
			}
			
		};
		ci.singleMethod();
	}


}
