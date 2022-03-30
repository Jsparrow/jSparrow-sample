package sample.make_final;

import java.util.Collections;
import java.util.List;

public class MakeVariablesFinal {
	

	private boolean singleton = true;
	private boolean reassignedInAnonymousClass = false;
	private boolean reassignedInConstractorInnerClass = false;
	
	
	private static String STATIC_FIELD = "";
	
	

	public MakeVariablesFinal(String name, Class clazz, boolean prototype) {
		this(name,clazz, Collections.emptyList());
		this.singleton = !prototype;
		
		final Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				reassignedInConstractorInnerClass = true;
				
			}
		};
	}

	public MakeVariablesFinal(String name, Class clazz, List<String> emptyList) {
		// TODO Auto-generated constructor stub
		STATIC_FIELD = "new value";
		if(emptyList.isEmpty()) {
			
		}
	}
	
	public void methodWithAnonymousClass() {
		final Runnable runnable = new Runnable() {
			
			private String value = "value";
			
			{
				final Runnable r =  new Runnable() {
					public void run() {
						reassignedInAnonymousClass = true;
					}
				};
			}
			
			@Override
			public void run() {
				
				
			}
		};
	}
	
	private void modifyInnerClassField() {
		InnerClass innerClass = new InnerClass();
		innerClass.value = true;
	}
	
	class InnerClass {
		private boolean value = false;
	}

}
