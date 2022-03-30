package sample.functionalinterface;

public class UsingInterfacesWithDefaultMethod {
	
	public void method() {
		InterfaceWithDefaultMethod iwdm = new InterfaceWithDefaultMethod() {
			
			@Override
			public String sampleMethod() {
				return "in sample method";
			}
		};
		
		InterfaceWithDefaultMethod iwdm2 = () -> {
			
			return "in sample method";
		};
	}
	
	public void sampleMethod2() {
		InterfaceWithDefaultMethod iwdm = new InterfaceWithDefaultMethod() {
			@Override
			public String sampleMethod() {
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						defaultSampleMethod();
					}
				};
				runnable.run();
				return "in sample method";
			}
		};
		iwdm.sampleMethod();
	}

}
